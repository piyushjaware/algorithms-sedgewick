package sort.elementary;

public class DeckSort {

	static String[] suits = { "S", "H", "C", "D" };

	static class Card implements Comparable {
		int number;
		String suit;

		public String toString() {
			return number + suit;
		}

		@Override
		public int compareTo(Object o) {
			Card card = (Card) o;
			if (getSuitIndex(this) < getSuitIndex(card)) {
				return -1;
			} else if (getSuitIndex(this) > getSuitIndex(card)) {
				return 1;
			} else {
				return this.number - card.number;
			}
		}

		public int getSuitIndex(Card card) {
			int suitIndex = 0;
			for (int i = 0; i < suits.length; i++) {
				if (suits[i] == card.suit) {
					suitIndex = i;
					break;
				}
			}
			return suitIndex;
		}
	}

	public static void main(String[] args) {
		Card[] cards = new Card[52];
		init(suits, cards);

		Sortable sorter = new Shell();
		System.out.print("Input Deck : ");
		sorter.show(cards);

		// Sort
		sorter.sort(cards);

		assert sorter.isSorted(cards);
		System.out.print("Sorted Deck : ");
		sorter.show(cards);
		sorter.stats(cards);

	}

	public static void init(String[] suits, Card[] cards) {
		int count = 0;
		for (int i = 4; i >= 1; i--) {
			for (int j = 1; j <= 13; j++) {
				Card card = new Card();
				card.number = j;
				card.suit = suits[i - 1];
				cards[count++] = card;
			}
		}

		// for (int i = 0; i < cards.length; i++) {
		// System.out.println(cards[i]);
		// }
	}
}
