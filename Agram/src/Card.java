import java.util.Comparator;

public class Card {
	public static Comparator<Card> compareNumber() {
		return new Comparator<Card>() {

			@Override
			public int compare(Card o1, Card o2) {
				return o1.val - o2.val;
			}

		};
	}

	public static Comparator<Card> compareSuit() {
		return new Comparator<Card>() {

			@Override
			public int compare(Card o1, Card o2) {
				return o1.suit.compareTo(o2.suit);
			}

		};
	}

	public int val;
	public String suit;

	public Card(String offForm) {
		val = intc(offForm.substring(1, 2));
		suit = offForm.substring(0, 1);
	}

	private int intc(String substring) {
		try {
			return Integer.parseInt(substring);
		} catch (Exception e) {
			if (substring.equals("A")) {
				return 1;
			}
			if (substring.equals("T")) {
				return 10;
			}
			if (substring.equals("J")) {
				return 11;
			}
			if (substring.equals("Q")) {
				return 12;
			}
			if (substring.equals("K")) {
				return 13;
			}
			return -1;
		}
	}

	private String str(int val2) {
		if (val2 > 1 && val2 < 10) {
			return String.valueOf(val2);
		} else if (val2 == 1) {
			return "A";
		} else if (val2 == 10) {
			return "T";
		} else if (val2 == 11) {
			return "J";
		} else if (val2 == 12) {
			return "Q";
		} else if (val2 == 13) {
			return "K";
		}
		System.out.println(val);
		return "nullehaha";
	}

	public String toString() {
		return str(val) + suit;
	}
}
