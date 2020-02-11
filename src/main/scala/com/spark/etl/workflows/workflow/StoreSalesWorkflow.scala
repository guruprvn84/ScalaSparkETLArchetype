package com.spark.etl.workflows.workflow

import com.spark.etl.workflows.components.extractors.{ItemExtractor, SalesExtractor, StoreExtractor}
import com.spark.etl.workflows.components.loaders.{ItemSalesLoader, StoreSalesLoader}
import com.spark.etl.workflows.components.transformers.{ItemSalesTransformer, StoreSalesTransformer}



object StoreSalesWorkflow extends WorkFlowTrait{

  addExtractors(new SalesExtractor, new StoreExtractor)

  addTransformers(new StoreSalesTransformer)

  addLoaders(new StoreSalesLoader)

}
