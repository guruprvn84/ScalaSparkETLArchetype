package com.spark.etl.utils

import SparkIOUtil.spark
import org.apache.log4j.Logger
import org.apache.spark.sql.{DataFrame, SQLContext, SQLImplicits, SaveMode, SparkSession}
import com.spark.etl.utils.{StringConstantsUtil => StrConst}


object SparkIOUtil {

  val log = Logger.getLogger(this.getClass.getName)

  var spark :SparkSession = null

  def configureSpark(configMap : Map[String,Any]):Unit={

    val appName = configMap.get(StrConst.WORKFLOW).get.toString
    val master = configMap.get(StrConst.MASTER).get.toString

    val sparkSession = SparkSession.builder().appName(appName).master(master)

    master match {
      case StrConst.LOCAL =>

      case _ => sparkSession.enableHiveSupport()
    }

    for((key, value) <- configMap.-(StrConst.WORKFLOW).-(StrConst.MASTER)) {

      value match {
        case bool: Boolean =>
          sparkSession.config(key, bool)
        case str: String =>
          sparkSession.config(key, str)
        case d: Double =>
          sparkSession.config(key, d)
        case l: Long =>
          sparkSession.config(key, l)
        case i: Int =>
          sparkSession.config(key, i)
        case _ =>
      }

    }

    spark = sparkSession.getOrCreate()
    spark.sql("set spark.sql.orc.enabled=true")
    spark.sql("set spark.sql.hive.convertMetastoreOrc=true")
    spark.sql("set spark.sql.orc.filterPushdown=true")
    spark.sql("set spark.sql.orc.char.enabled=true")

  }

  def getSparkSession():SparkSession = spark


  def execute(sql:String):Unit={
    log.debug("Executing SQL = " + sql)
    println("Executing SQL = " + sql)
    spark.sql(sql).collect()
  }

  def writeOrc(df:DataFrame,mode:SaveMode,tableName:String, partition:Option[String]):Unit = {
    partition match {
      case Some(x) => df.write.mode(mode).format("orc").partitionBy(x).saveAsTable(tableName)

      case None => df.write.mode(mode).format("orc").saveAsTable(tableName)
    }
  }

  def fetch(sql:String):DataFrame={
    log.debug("Executing SQL = " + sql)
    println("fetch SQL = " + sql)
    spark.sql(sql)
  }

  def read(fileName:String):DataFrame = {
    spark.read.option("header", "true").csv(fileName)
  }

  def isTableExists(database:String,tableName:String):Boolean={
    spark.catalog.tableExists(database + "." + tableName)

  }

  def refreshMetaData(schema:String,table:String):Unit={
    spark.catalog.refreshTable(schema + "." + table)
  }



  def buildTempDF():DataFrame = {
    val rdd = spark.sparkContext.parallelize(List(1,2,3))
    import SparkImplicits._
    rdd.toDF()
  }
}


object SparkImplicits extends SQLImplicits with Serializable {
  protected override def _sqlContext: SQLContext = spark.sqlContext
}
