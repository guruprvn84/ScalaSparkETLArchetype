package com.spark.etl.utils

import com.typesafe.config.{Config, ConfigFactory}
import org.apache.log4j.Logger

import scala.collection._

object ConfigUtil {

  val config: Config = ConfigFactory.parseResources("sparkConf.conf")

  val logger = Logger.getLogger(this.getClass.getName)

  def getGlobalConfig(runMode:Option[Any]) : mutable.Map[String, AnyRef] = {

    logger.debug("Running ->" + runMode.getOrElse(StringConstantsUtil.LOCAL).toString.toUpperCase())

    val confObj = config.getObject(runMode.getOrElse(StringConstantsUtil.LOCAL).toString.toUpperCase())

    val itr = confObj.unwrapped().entrySet().iterator()

    val confMap:mutable.Map[String, AnyRef] = mutable.Map[String, AnyRef]()

    while(itr.hasNext) {
      val e = itr.next()
      confMap.put(e.getKey, e.getValue)
    }
    confMap
  }

  def getAppConfig(appName:String) : mutable.Map[String, AnyRef] = {

    val confMap:mutable.Map[String, AnyRef] = mutable.Map[String, AnyRef]()

    if (config.hasPath(appName)) {

          val confObj = config.getObject(appName)

          val itr = confObj.unwrapped().entrySet().iterator()

          while (itr.hasNext) {
            val e = itr.next()
            confMap.put(e.getKey, e.getValue)
          }
    }
    confMap
  }


  def getAppName(appName:String): String = config.getString("app.appName")

  def getWarehouseLocation: String = config.getString("app.warehousedir")


}
