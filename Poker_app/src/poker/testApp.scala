package poker

object testApp extends App {
  // Cards
  val aceOfSpades = new Card(1, "Spades", "A")
  val twoOfSpades = new Card(2, "Spades", "2")
  val threeOfSpades = new Card(3, "Spades", "3")
  val fourOfSpades = new Card(4, "Spades", "4")
  val fiveOfSpades = new Card(5, "Spades", "5")
  val sixOfSpades = new Card(6, "Spades", "6")

  val aceOfClubs = new Card(1, "Clubs", "A")
  val twoOfClubs = new Card(2, "Clubs", "2")

  val aceOfHearts = new Card(1, "Hearts", "A")
  val aceOfDiamonds = new Card(1, "Diamonds", "A")

  // Hands
  val straightFlush = new Hand(Vector(aceOfSpades, twoOfSpades, threeOfSpades, fourOfSpades, fiveOfSpades))
  val straight = new Hand(Vector(aceOfClubs, twoOfSpades, threeOfSpades, fourOfSpades, fiveOfSpades))
  val flush = new Hand(Vector(aceOfSpades, sixOfSpades, threeOfSpades, fourOfSpades, fiveOfSpades))
  val pair = new Hand(Vector(aceOfSpades, aceOfClubs, threeOfSpades, fourOfSpades, fiveOfSpades))
  val twoPairs = new Hand(Vector(aceOfSpades, aceOfClubs, twoOfSpades, twoOfClubs, fiveOfSpades))
  val trips = new Hand(Vector(aceOfSpades, aceOfHearts, aceOfClubs, fourOfSpades, fiveOfSpades))
  val quads = new Hand(Vector(aceOfSpades, aceOfClubs, aceOfHearts, aceOfDiamonds, fiveOfSpades))
  val fullHouse = new Hand(Vector(aceOfSpades, aceOfClubs, aceOfHearts, twoOfClubs, twoOfSpades))
  val aHigh = new Hand(Vector(aceOfClubs, twoOfSpades, threeOfSpades, fourOfSpades, sixOfSpades))

  // Printed hand scores
  println("Hand: " + straightFlush)
  println("Score: " + straightFlush.inspectWin + "\n")
  
  println("Hand: " + straight)
  println("Score: " + straight.inspectWin + "\n")
  
  println("Hand: " + flush)
  println("Score: " + flush.inspectWin + "\n")
  
  println("Hand: " + twoPairs)
  println("Score: " + twoPairs.inspectWin + "\n")
  
  println("Hand: " + pair)
  println("Score: " + pair.inspectWin + "\n")
  
  println("Hand: " + trips)
  println("Score: " + trips.inspectWin + "\n")
  
  println("Hand: " + quads)
  println("Score: " + quads.inspectWin + "\n")
  
  println("Hand: " + fullHouse)
  println("Score: " + fullHouse.inspectWin + "\n")
  
  println("Hand: " + aHigh)
  println("Score: " + aHigh.inspectWin + "\n")

}