import scala.annotation.tailrec

object Day2 {
  def main(args: Array[String]): Unit = {
    println(totalEvenOdd_s(20))
    setPractise()
  }


//  def

  def setPractise():Unit = {
    val games = Set("Cricket","FootBall","Cricket","Hockey")
    val uGames = games.head
    println(uGames)
    println(games.mkString("-"))
    print(games.toList)


  }



  @tailrec
  def totalEvenOdd(even: Int, odd: Int, it: Int, range: Int): Tuple2[Int, Int] = {
    if (it == range)
      (even, odd)
    else if (it % 2 == 0)
      totalEvenOdd(even + 1, odd, it + 1, range)
    else totalEvenOdd(even, odd + 1, it + 1, range)
  }

  val totalEvenOdd_s: Int => (Int, Int) = totalEvenOdd(0, 0, 1, _)


}
