import java.awt.Color;
import java.nio.charset.Charset;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 * 1. PM_LFSR data type. Your first task is to write a data type that simulates the
 * operation of a PM_LFSR 2. A client to encrypt and decrypt images: write a PM_LFSR
 * client PM_PhotoMagic.java
 * 
 * Extra credit. Using a short binary password is weak protection and using a
 * long one is inconvenient. For extra credit, write a client
 * PhotoMagicDeluxe.java with the same API as PM_PhotoMagic.java, but use an
 * alphanumeric password instead of a binary one. Assume that the password
 * contains only characters from the 64-character alphabet:
 * 
 * String base64 =
 * "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
 * 
 * @author PMARINA
 * @version an hour and 15 minutes late
 */
public class PM_PhotoMagic {
	/**
	 * @param pm_lfsr
	 *            the lfsr to be working with
	 * @param p
	 *            the picture to be transforming
	 * @return the encrypted picture
	 */
	public static Picture transform(PM_LFSR pm_lfsr, Picture p) {
		Picture n = new Picture(p.width(), p.height());// create a new image
		for (int i = 0; i < p.width(); i++) {
			for (int j = 0; j < p.height(); j++) {
				Color c = p.get(i, j);
				String r = PM_LFSR.xor(Integer.toBinaryString(pm_lfsr.generate(8)), Integer.toBinaryString(c.getRed())); // Find
																													// the
																													// XOR
																													// between
																													// the
																													// rgb
																													// and
																													// the
																													// lfsr
				String g = PM_LFSR.xor(Integer.toBinaryString(pm_lfsr.generate(8)), Integer.toBinaryString(c.getGreen()));
				String b = PM_LFSR.xor(Integer.toBinaryString(pm_lfsr.generate(8)), Integer.toBinaryString(c.getBlue()));
				n.set(i, j, new Color(Integer.parseInt(r, 2), Integer.parseInt(g, 2), Integer.parseInt(b, 2)));// Set
																												// the
																												// correct
																												// color
			}
		}
		return n;// return the correct image
	}

	/**
	 * @param args
	 *            no use
	 */
	public static void main(String[] args) {
		// get usr input
		String s = JOptionPane.showInputDialog("What is the PM_LFSR seed?");
		int t = Integer.parseInt(JOptionPane.showInputDialog("What is the tap?"));
		String path = JOptionPane.showInputDialog("What is the file(name)");
		Picture p = new Picture(path);
		// Check whether or not the lfsr is in binary, or if it needs to be
		// converted
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			Charset b64 = Charset.defaultCharset();
			byte[] b = s.getBytes(b64);
			s = Arrays.toString(b).substring(1);
			s = s.substring(0, s.length() - 1);
			s = s.replace(",", "");
			s = s.replace(" ", "");
		}
		// create the lfsr, get an ecnrypted picture back, and draw it
		PM_LFSR pm_lfsr = new PM_LFSR(s, t);
		Picture n = transform(pm_lfsr, p);
		n.show();
	}
}
