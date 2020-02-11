package com.spark.etl.workflows.components.transformers

import org.apache.spark.sql.DataFrame

trait TransformTrait {

  def transform(paramsMap: Map[String, Any], dataFrameMap: Map[String, DataFrame])
                              : Map[String, DataFrame]

}
