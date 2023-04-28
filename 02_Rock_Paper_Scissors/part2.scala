import scala.io.Source

def calculateWinner(line: String): Int = {
  val moves = line.split(" ")
  val player1 = moves(0)
  val player2 = moves(1)

  // X = lose
  // Y = draw
  // Z = win

  // A = rock
  // B = paper
  // C = scissors

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

  //   A B C
  // X 2 3 1
  // Y 1 2 3
  // Z 2 

  val matrix = Array(
    Array(2,3,1),
    Array(3,1,2),
    Array(1,2,3),
  )

  val player1Score = player1 match {
    case "A" => 0
    case "B" => 3
    case "C" => 6
  }



  player1Score + matrix(player1Index)(player2Index)
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


