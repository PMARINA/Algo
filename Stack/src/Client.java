import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Implement the ArrayStack ADT using arrays. Look at the API in the class
 * website. Design and implement a client to calculate the following postfix
 * expression: 8 4 -3 * 1 5 + / *
 * 
 * @author PMARINA
 * @version 9/28/16
 *
 */
public class Client {
	/**
	 * @param args
	 *            does nothing
	 * @throws Exception
	 *             if there are too many operators present or if the operator
	 *             given is not currently supported
	 */
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		StringTokenizer stCount = new StringTokenizer(s, " ");
		StringTokenizer stCompute = new StringTokenizer(s, " ");
		ArrayStackOfIntegers a = new ArrayStackOfIntegers(count(stCount));
		while (stCompute.hasMoreTokens()) {
			String as = stCompute.nextToken();
			try {
				a.push(Integer.parseInt(as));

			} catch (NumberFormatException e) {
				Integer num1 = 0;
				Integer num2 = 0;
				if (!a.isEmpty())
					num1 = a.pop();
				else
					throw new Exception("Too many operators");
				if (!a.isEmpty())
					num2 = a.pop();
				else
					throw new Exception("Too many operators");
				a.push(compute(num2, as, num1));
			}
		}
		System.out.println("Result = " + a.pop());
	}

	/**
	 * @param num2
	 *            the first number
	 * @param as
	 *            the operator
	 * @param num1
	 *            the second number
	 * @return the result of the computation
	 * @throws Exception
	 *             if the operator inputted is not supported
	 */
	private static Integer compute(Integer num2, String as, Integer num1) throws Exception {
		switch (as) {
		case "*":
			return num1 * num2;
		case "+":
			return (num1 + num2);
		case "-":
			return num2 - num1;
		case "/":
			return num2 / num1;
		default:
			throw new Exception("Operator Not supported");
		}

	}

	/**
	 * @param st
	 *            String Tokenizer used to count the number of numbers
	 * @return number of numbers
	 */
	private static int count(StringTokenizer st) {
		int count = 0;
		while (st.hasMoreTokens()) {
			try {
				Integer.parseInt(st.nextToken());
				count++;
			} catch (NumberFormatException e) {
			}
		}
		return count;
	}
}
