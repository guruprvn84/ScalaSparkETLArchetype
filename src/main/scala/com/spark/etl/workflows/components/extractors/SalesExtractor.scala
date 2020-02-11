package com.spark.etl.workflows.components.extractors

import com.spark.etl.utils.SparkIOUtil
import org.apache.log4j.Logger
import org.apache.spark.sql.DataFrame

class SalesExtractor extends ExtractorTrait {

  override def extract(paramsMap: Map[String, Any], extractedDF:
            Option[Map[String, DataFrame]]): Option[Map[String, DataFrame]] = {

    val log = Logger.getLogger(this.getClass.getName)

    val salesDF = SparkIOUtil.read("./data/sales.csv")

    Some(Map("salesDF" -> salesDF))

  }
}
