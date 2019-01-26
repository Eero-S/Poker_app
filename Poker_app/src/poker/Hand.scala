package poker

class Hand(val hand: Vector[Card]) {
  override def toString = hand.mkString(", ")

  def inspectStraight: Boolean = {
    val uniqueNumbersInHand = hand.map(_.number).distinct
    val ordered = uniqueNumbersInHand.sortBy(-_)
    val difference = ordered.head - ordered.last
    val aceHighStraight = Vector(13, 12, 11, 10, 1) // Ace exception.

    (difference == 4 && ordered.length == 5) || (ordered == aceHighStraight) // Boolean.
  }

  def inspectFlush: Boolean = {
    val amountOfDifferentColors = hand.map(_.suit).distinct.length
    amountOfDifferentColors == 1 // Boolean
  }

  def inspectOthers: String = {
    val handNumbers = hand.map(_.number)
    val uniqueNumbersInHand = handNumbers.distinct

    var highestAmountOfSameNumber = 0 // Counter.
    // Inspects the maximum amount of the same number in hand.
    for (i <- 0 until handNumbers.size) {
      var amountOfSameNumber = handNumbers.filter(_ == handNumbers(i)).size
      if (amountOfSameNumber > highestAmountOfSameNumber) {
        highestAmountOfSameNumber = amountOfSameNumber
      }
    }
    if (uniqueNumbersInHand.size == 3) { // Hand has 3 unique numbers.
      highestAmountOfSameNumber match {
        case 2 => "TWO PAIRS!"
        case 3 => "THREE OF A KIND!"
      }
    } else if (uniqueNumbersInHand.size == 2) { // Hand has 2 unique numbers.
      highestAmountOfSameNumber match {
        case 3 => "FULL HOUSE!"
        case 4 => "QUADS!"
      }
    } else if (uniqueNumbersInHand.size == 4) { // Hand has 4 unique numbers.
      highestAmountOfSameNumber match {
        case 2 => "PAIR!"        
      }
    } else this.highCard + "-high."     

  }

  def highCard: String = {
    if (hand.sortBy(_.number).head.number == 1) {
      "A"
    } else {
      hand.sortBy(-_.number).head.rank
    }
  }

  def inspectWin: String = {
    if (this.inspectStraight && this.inspectFlush) {
      "STRAIGHT FLUSH!"
    } else if (this.inspectStraight) {
      "STRAIGHT!"
    } else if (this.inspectFlush) {
      "FLUSH!"
    } else {
      this.inspectOthers
    }
  }

}