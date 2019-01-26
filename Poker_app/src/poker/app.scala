package poker

object app extends App {

  Deck.deal

  for (i <- 0 until Deck.hands.size) {
    var number = i + 1
    println("Hand number " + number + ":    " + Deck.hands(i))
    println("Score:            " + Deck.hands(i).inspectWin + "\n")
  }

}