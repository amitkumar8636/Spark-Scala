object Assignment2 {
  def main(args: Array[String]): Unit = {
    val list = List[Int](10,20,30,40,50)
    val k = 40
    val length = 5
    var result = 0
    list.foreach((element:Int)=>if (element<k) result += 1 )
    println(result)
  }
}
