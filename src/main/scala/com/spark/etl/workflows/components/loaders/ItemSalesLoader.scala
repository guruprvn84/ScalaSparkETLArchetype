package com.spark.etl.workflows.components.loaders
import com.spark.etl.utils.SparkIOUtil
import org.apache.spark.sql.{DataFrame, SaveMode}
import com.spark.etl.utils.{TableColumnConstants=>TC}

class ItemSalesLoader extends LoaderTrait {

  override def load(paramsMap: Map[String, Any], dataFrameMap: Map[String, DataFrame]): Unit = {

    val df = dataFrameMap.get("itemSalesDF").get

    SparkIOUtil.writeOrc(df, SaveMode.Append, TC.itemSalesTable , None)

  }
}
