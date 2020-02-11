package com.spark.etl.workflows.components.transformers

import com.spark.etl.utils.SparkIOUtil
import org.apache.log4j.Logger
import org.apache.spark.sql.DataFrame
import com.spark.etl.utils.{TableColumnConstants=>TC}
import org.apache.spark.sql.functions._

class ItemSalesTransformer extends TransformTrait {

  override def transform(paramsMap: Map[String, Any],
                         dataFrameMap: Map[String, DataFrame]):Map[String, DataFrame] = {

    val log = Logger.getLogger(this.getClass.getName)

    val itemDF = dataFrameMap.get("itemDF").get
    val salesDF = dataFrameMap.get("salesDF").get

    val salesItemExpr = itemDF.col(TC.itemNbr) === salesDF.col(TC.itemNbr)

    val result = salesDF.groupBy(col(TC.itemNbr))
      .agg(sum(TC.saleAmt).alias(TC.saleAmt))
      .join(itemDF, salesItemExpr, "inner")
      .select(itemDF(TC.itemNbr), col(TC.itemDesc), col(TC.saleAmt))

    result.show(10)


    Map("itemSalesDF" -> result)
  }


}
