object Assignment3
{

  def main(args: Array[String]): Unit = {
    val str:String = "hello how are you"
    println(str.reverse)
//    val rev:String = str.split(" ").foreach((element:String)=> element.reverse)
//    print(rev.reverse)s
    println(str.split(" ").reverse.mkString(" "))

//   val rev =  str.split(" ")
//    val arr = rev.map((element:String)=> element.reverse)
    val arr = str.split(" ").map((element:String)=> element.reverse)
    print(arr.mkString(" "))
//    print(arr.mkString(" "))
  }
}
