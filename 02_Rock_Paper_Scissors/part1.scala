import scala.io.Source

def calculateWinner(line: String): Int = {
  val moves = line.split(" ")
  val player1 = moves(0)
  val player2 = moves(1)

  val matrix1 = Array(1, 2, 3)

  val matrix2 = Array(
    Array(3, 6, 0),
    Array(0, 3, 6),
    Array(6, 0, 3)
  )

  val player2Index = player2 match {
    case "X" => 0
    case "Y" => 1
    case "Z" => 2
  }

  val player1Index = player1 match {
    case "A" => 0
    case "B" => 1
    case "C" => 2
  }

  matrix2(player1Index)(player2Index) + matrix1(player2Index)
}


object Application {
  def main(args: Array[String]): Unit = {
    // stuff goes here.
    var score: Int = 0

    for(line <- Source.fromFile("input.txt").getLines())
      score += calculateWinner(line)

    println(score)
  }
}


