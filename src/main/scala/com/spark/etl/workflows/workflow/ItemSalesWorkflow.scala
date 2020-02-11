package com.spark.etl.workflows.workflow

import com.spark.etl.workflows.components.extractors.{SalesExtractor, ItemExtractor}
import com.spark.etl.workflows.components.transformers.ItemSalesTransformer
import com.spark.etl.workflows.components.loaders.ItemSalesLoader

object ItemSalesWorkflow extends WorkFlowTrait {

  addExtractors(new SalesExtractor, new ItemExtractor)

  addTransformers(new ItemSalesTransformer)

  addLoaders(new ItemSalesLoader)

}
