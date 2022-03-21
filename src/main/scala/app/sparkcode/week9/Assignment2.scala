package app.sparkcode.week9

import org.apache.spark.SparkContext

object Assignment2 extends App {

  val spark = new SparkContext("local[*]", "Assignment2")
  val file = spark.textFile("data/tempdata-201125-161348.csv")

  //  def filter(input:string) = {
  //    val arr = input.split(",")
  //    var result = arr.filter
  //  }
  val data = file
    .map(x => x.split(","))
    .filter(x => (x(2) == "TMIN"))
    .map(x => x.mkString(","))


  val result = data.collect()
  result.foreach(println)

}
