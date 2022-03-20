object Assignment1 {

  def main(args: Array[String]): Unit = {
    var total =0
    val arr = Array(10,20,16,25,30,40,36)
    val lenght = 7

    arr.foreach((element:Int)=> {
      val e = Math.round(Math.sqrt(element))
      if ( e*e == element ) {
//        println(element)
        total = total+1
        }
      println(element , e * e)

    })
    print(total)
  }

}
