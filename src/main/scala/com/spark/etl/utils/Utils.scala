package com.spark.etl.utils

import org.apache.log4j.Logger

import scala.collection.mutable.LinkedHashSet

object Utils {


  def print(obj: Any, log: Logger): Unit = {

    val builder: StringBuilder = new StringBuilder

    obj match {
      case set: LinkedHashSet[Any] => for (obj <- set) {
        builder.append(obj.getClass.getName + "\n")
      }
        log.info(builder.toString())
    }

  }

  def printString(obj: Any): String = {

    val builder: StringBuilder = new StringBuilder

    obj match {
      case set: LinkedHashSet[Any] => for (obj <- set) {
        builder.append("\n\t" + obj.getClass.getName)
      }
    }
    builder.toString()
  }

}
