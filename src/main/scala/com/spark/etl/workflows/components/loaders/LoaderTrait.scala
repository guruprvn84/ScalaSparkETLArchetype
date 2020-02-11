package com.spark.etl.workflows.components.loaders

import org.apache.spark.sql.DataFrame

trait LoaderTrait {
  def load(paramsMap: Map[String, Any], dataFrameMap: Map[String, DataFrame]): Unit
}
