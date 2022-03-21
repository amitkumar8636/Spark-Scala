package app.sparkcode

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext

object MovieProblem extends App{

  Logger.getLogger("org").setLevel(Level.ERROR)

  val spark = new SparkContext("local[*]","MovieProblem")
  val file = spark.textFile("data/moviedata-201008-180523.data")

  val data = file.map(x=>(x.split("\t")(2),1)).reduceByKey((x,y)=>x+y).sortBy(x=>x._2)
  val result = data.collect
  result.foreach(println)

}
