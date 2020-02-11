package com.spark.etl.workflows.components.extractors

import org.apache.spark.sql.DataFrame

trait ExtractorTrait {

  val dataframes:Map[String, DataFrame] = Map()

  def extract(paramsMap: Map[String,Any],
              extractedDF : Option[Map[String,DataFrame]]): Option[Map[String,DataFrame]]

}
