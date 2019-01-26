package poker
import scala.collection.mutable.Buffer
import scala.util.Random

/* The deck creates and shuffles the cards that are used in the game.
	 It also deals (creates) the hands */
object Deck {

  private val numbers = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13)
  private val ranks = Vector("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
  private val ranksFromNumbers = numbers.zip(ranks).toMap
  var cards: Buffer[Card] = Buffer[Card]()

  // Creates 13 cards of each suit.
  for (i <- 1 to 13) {
    cards += new Card(i, "Hearts", ranksFromNumbers(i))
    cards += new Card(i, "Spades", ranksFromNumbers(i))
    cards += new Card(i, "Diamonds", ranksFromNumbers(i))
    cards += new Card(i, "Clubs", ranksFromNumbers(i))

    cards = util.Random.shuffle(Deck.cards) // Shuffles the deck.
  }

  val hands = Buffer[Hand]()

  def deal() = {
    val amountOfHands = 7 // 10 maximum.
    // Creates a hand from the first five cards of the deck. Saves the hands into a Buffer.
    for (i <- 0 until amountOfHands) {
      hands += new Hand(Deck.cards.take(5).toVector)
      cards.remove(0, 5) // Removes the same cards.
    }
  }
}