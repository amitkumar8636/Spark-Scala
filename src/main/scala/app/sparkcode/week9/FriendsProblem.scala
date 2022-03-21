package app.sparkcode.week9

import org.apache.spark.SparkContext

object FriendsProblem extends App {

  val spark = new SparkContext("local[*]", "FriendsProblem")
  val file = spark.textFile("data/friendsdata-201008-180523.csv")

  val data = file.map(x => x.split("::")).map(x => (x(2), (x(3).toFloat, 1)))
  val result = data.reduceByKey((x, y) => (x._1 + y._2, x._2 + y._2))
  val finalResult = result.map(x => (x._1, x._2._1 / x._2._2))
  finalResult.foreach(println)

}
