import java.util.List; import java.util.ArrayList;import java.lang.StringBuilder;
public class HashAttack{
	public static void main(String[] args){
		String s  = args[0];
		String all = "";
		StringBuilder sa = new StringBuilder();
		for(int a = 65; a<91; a++)sa.append((char)a);
		for(int a = 97; a<123; a++)sa.append((char)a);
		all = sa.toString();
		int hash = s.hashCode();
		List<String> als = getPossCombos(all, s.length(), new StringBuilder(), new ArrayList<String>());
	}
	public static List<String> getPossCombos(String all, int len, StringBuilder s, List<String> a){
		if(s.length() == len){
			a.add(s.toString());
		}
		else{
			for(int i = 0; i<all.length();i++){
				StringBuilder newS = new StringBuilder(s.toString());
				s.append(all.substring(i,i+1));
				getPossCombos(all,len,s,a);
				s = newS;
			}
			return a;
		}
		return null;
	}
	public static void get(String s, List<String> poss){
		for(String ls : poss)if(ls.hashCode() == s.hashCode())System.out.println(ls);
	}
}
