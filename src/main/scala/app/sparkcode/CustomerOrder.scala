package app.sparkcode

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object CustomerOrder extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)
  val sc = new SparkContext("local[*]", "CustomerData")
  val input = sc.textFile("data/customerorders-201008-180523.csv")
  val splitData = input.map(x => x.split(',')) //This Should return Array of String
  val arrData = splitData.map(x => (x(0), x(2).toFloat))
  val calc = arrData.reduceByKey((x, y) => x + y)
  val result = calc.sortBy(x => x._2,ascending = false)
//  val finalResult = result.collect.sortBy(x => x._2)
//  val sortedResult = result.sortBy(x=>x._2,ascending = false)
    result.foreach(println)
}
