package app.sparkcode


import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object WordCount extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)
//  val spark = SparkSession.builder().appName("WordCount").getOrCreate()
  val sc = new SparkContext("local[*]", "TotalSpentByCustomerSorted")
  val file = sc.textFile("data/search_data-201008-180523.txt")

  val words = file.flatMap(_.split(" "))
  val wordsMap = words.map(x=>(x,1))
  val wordsCount = wordsMap.reduceByKey((x,y)=>x+y)

//1. Simple WordCount
//  wordsCount.foreach(println(_)) // Just for Word Count

//  2. Sorted WordCount
  val sortedWordCount = wordsCount.map( x => (x._2, x._1)).sortByKey(ascending = false)
//  sortedWordCount.foreach(println)
  sortedWordCount.collect.foreach(println)
}
