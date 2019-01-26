package poker

/**
 * 	@param number 			Stands for the numerical value of the card.
 *  @param suit					Stands for the "color" of the card.
 * 	@param rank					Stands for the "name" of the card.
 * 											For example, we want the card number 1 to stand for A, 11 for J and so on.
 */
class Card(val number: Int, val suit: String, val rank: String) {

  override def toString = this.rank + "-" + this.suit
}
