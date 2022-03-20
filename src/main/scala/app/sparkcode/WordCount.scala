package app.sparkcode

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

object WordCount extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)
//  val spark = SparkSession.builder().appName("WordCount").getOrCreate()
  val sc = new SparkContext("local[*]", "TotalSpentByCustomerSorted")
  val file = sc.textFile("data/search_data-201008-180523.txt")

  val words = file.flatMap(_.split(" "))
  val wordsMap = words.map(x=>(x,1))
  val wordsCount = wordsMap.reduceByKey((x,y)=>x+y)

  wordsCount.foreach(println(_))

}
