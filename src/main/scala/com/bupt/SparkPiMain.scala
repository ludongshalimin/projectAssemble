package com.bupt

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


object SparkPiMain {
  def main(args: Array[String]): Unit = {
//    val conf = new SparkConf().setMaster("local[*]").setAppName("spark pi test")
    val spark = SparkSession
      .builder()
//      .config(conf)
      .getOrCreate()
    val sc = spark.sparkContext
    val slices = 2
    val n = 10000 * slices
    val count = sc.parallelize(1 to n,slices).map(i => {
      val x = Math.random() * 2 -1
      val y = Math.random() * 2 -1
      if (x * x + y * y < 1) 1 else 0
    }).reduce((a,b) => a + b)
    println("Pi is roughly " + 4.0 * count / n)
  }

}

