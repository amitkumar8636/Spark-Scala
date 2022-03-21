package app.sparkcode.week9

import org.apache.spark.SparkContext


case object Assignment1 extends App {

  val spark = new SparkContext("local[*]", "Assignment1")
  val file = spark.textFile("data/-201125-161348.dataset1")

  def ageDecider(num:String):Char = if (num.toFloat>18) 'Y' else 'N'

  val data = file.map(x => x.split(","))
  val result = data.map(x => (x.mkString(","),ageDecider(x(1))))
  val finalResult = result.collect()


  finalResult.foreach(println)

}
