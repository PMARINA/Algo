
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Player {
	public String[] cards;

	public String findLowestOfSuit(String suit) {
		List<Integer> pos = valuesOfSuit(suit);
		return suit + String.valueOf(((Integer) pos.get(0)).intValue());
	}

	public String findLowestOfSuitGreaterThan(String card) {
		List<Integer> pos = valuesOfSuit(card.substring(0, 1));
		int bar = intValue(card);
		for (int i = 0; i < pos.size(); i++) {
			if (((Integer) pos.get(i)).intValue() > bar) {
				return card.substring(0, 1) + String.valueOf(pos.get(i));
			}
		}
		return null;
	}

	public String getCompleteLowest() {
		Card[] car = new Card[5];
		for (int i = 0; i < cards.length; i++) {
			car[i] = new Card(cards[i]);
		}
		Arrays.sort(car, Card.compareNumber());
		List<Card> cardsf = new ArrayList<Card>();
		cardsf.add(car[0]);
		boolean done = false;
		for (int i = 0; i < car.length - 1 && !done; i++) {
			if (car[i].val == car[i + 1].val) {
				cardsf.add(car[i + 1]);
			} else {
				done = true;
			}
		}
		Card[] cardsfs = new Card[cardsf.size()];
		cardsfs = cardsf.toArray(cardsfs);
		Arrays.sort(cardsfs, Card.compareSuit());
		return cardsfs[0].toString();
	}

	public String getLowestByNumber() {
		String[] sortedCardsInverted = new String[cards.length];
		for (int i = 0; i < cards.length; i++) {
			sortedCardsInverted[i] = new StringBuilder(cards[i]).reverse().toString();
		}
		Arrays.sort(sortedCardsInverted);
		if (!(sortedCardsInverted[0].substring(0, 1).equals(sortedCardsInverted[1].substring(0, 1)))) {
			return new StringBuilder(sortedCardsInverted[0]).reverse().toString();
		}
		return null;
	}

	public String getLowestBySuit() {
		String[] sortedCardsInverted = new String[cards.length];
		for (int i = 0; i < cards.length; i++) {
			sortedCardsInverted[i] = new StringBuilder(cards[i]).reverse().toString();
		}
		Arrays.sort(sortedCardsInverted);
		boolean done = false;
		List<String> pos = new ArrayList<String>();
		for (int i = 0; i < cards.length - 1 && !done; i++) {
			if (cards[i].substring(0, 1).equals(cards[i + 1].substring(0, 1))) {
				pos.add(cards[i]);
			} else {
				done = true;
			}
		}
		String[] ret = new String[pos.size()];
		pos.toArray(ret);
		for (int i = 0; i < cards.length; i++) {
			ret[i] = new StringBuilder(cards[i]).reverse().toString();
		}
		Arrays.sort(ret);
		return ret[0];
	}

	public boolean hasSuit(String suit) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].substring(0, 1).equals(suit)) {
				return true;
			}
		}
		return false;
	}

	private int intValue(String card) {
		int bar = -1;
		try {
			bar = (new Integer(card.substring(1, 2))).intValue();
		} catch (Exception E) {
			if (card.substring(1, 2).equals("T")) {
				bar = 10;
			}
			if (card.substring(1, 2).equals("J")) {
				bar = 11;
			}
			if (card.substring(1, 2).equals("Q")) {
				bar = 12;
			}
			if (card.substring(1, 2).equals("K")) {
				bar = 13;
			}
			if (card.substring(1, 2).equals("A")) {
				bar = 1;
			}
		}
		return bar;
	}

	private List<Integer> valuesOfSuit(String suit) {
		List<Integer> pos = new ArrayList<Integer>();
		if (hasSuit(suit)) {
			for (int i = 0; i < cards.length; i++) {
				if (cards[i].substring(0, 1).equals(suit)) {
					Integer val = intValue(cards[i]);
					pos.add(new Integer(val));
				}
				pos.sort(new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return (Integer) o1 - (Integer) o2;
					}

				});
			}
			return pos;
		}
		return null;
	}
}
