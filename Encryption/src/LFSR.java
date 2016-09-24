import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author PMARINA
 * @version 09/21/2016
 */
public class LFSR {
	private String seed;
	private int tap;

	public LFSR(String seed, int t) {
		this.seed = seed;
		this.tap = seed.length()-t-1;//use -1 only if rightmost position is 0. Else, take out -1
	}

	public String toString() {
		return seed;
	}

	public int step() {
		boolean xor = (Integer.parseInt(seed.substring(0,1)) +  Integer.parseInt(seed.substring(tap,tap+1))) == 1;
		String s = "\"";
		if(xor)s="1";
		else s="0";
		seed = seed.substring(1,seed.length()) + s;
		return Integer.parseInt(s); 
	}

	public int generate(int k) {
		String a = "";
		for (int i = 0; i < k; i++) {
			int s = step();
			a += Integer.toString(s);
		}
		return Integer.parseInt(a, 2);
	}

	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("What is the LFSR seed?");
		int t = Integer.parseInt(JOptionPane.showInputDialog("What is the tap?"));
		String p = JOptionPane.showInputDialog("What is the file(name)");
		LFSR lfsr = new LFSR(s,t);
		for(int i = 0; i<)
	}
}
