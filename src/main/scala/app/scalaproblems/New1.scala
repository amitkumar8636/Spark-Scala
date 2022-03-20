import scala.annotation.tailrec


object New1 {
  def main(args: Array[String]): Unit = {
    println(largestAmongThree(8, 4, 5))
    println(isEven(4))
    println(isOdd(9))
    println(characterConversion('A'))
    println(characterConversion('b'))
    println(factorial(5))
    if (isPrimeNo(11)) println("Prime No") else println("Not Prime")
    fibonacciNo(20)
    println()
    println("Pallindrom No", 12321, isPallendrom("12321"))
    println(f"Pallindrom No 12354 ${isPallendrom("12354")}")

  }

  def isPallendrom(number: String): Boolean = {
    //    val newNumber = Integer.parseInt(number)
    val charArray = number.toCharArray
    val reverseNo = charArray.reverse
    val reverseString = reverseNo.mkString
    number == reverseString

  }

  def fibonacciNo(number: Int): Int = {
    val a: Int = 0
    val b: Int = 1
    val constRangePrinter = fibPrinter(_, _, number)
    print(0 + " " + 1 + " ")
    constRangePrinter(a, b)


    0
  }

  @tailrec
  def fibPrinter(a: Int, b: Int, range: Int): Unit = {
    if (a + b <= range) {
      print(a + b + " ")
      fibPrinter(b, a + b, range)
    }
  }

  def isPrimeNo(x: Int): Boolean = {
    val constDivider = divider(x, _)
    for (i <- 2 to x / 2) if (constDivider(i)) return false
    true
  }

  def divider(x: Int, y: Int): Boolean = x % y == 0

//  def factorial(number: Int): Int =
//    if (number == 0) 1 else number * factorial(number - 1)

  def factorial(x:Int):Int = recursiveFactorial(x,1,x)
//  def factorial(number:Int):Int = if (number==0) 1 else factorial(number*(number-1))


  @tailrec
  def recursiveFactorial(number:Int,it:Int, range:Int ):Int = {
    if (it==range) return number*(it+1)
    recursiveFactorial(it*(it+1),it+1,range)
  }

  def characterConversion(x: Char): Char = {
    if (x >= 65 && x <= 97) (x + 32).toChar else (x - 32).toChar
  }

  def isOdd(x: Int): Int = {
    val v = x % 2
    v match {
      case 0 =>
        print("Even Number")

      case 1 => print("Odd Number")
    }
    0
  }

  def isEven(x: Int): String = {
    if (x % 2 == 0) "Even" else "False"
  }

  def largestAmongThree(x: Int, y: Int, z: Int): Int = {
    if (x >= y && y >= z) x
    else if (y >= x && y >= z) y
    else z
  }
}
