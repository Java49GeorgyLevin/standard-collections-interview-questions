package telran.interviews;

import java.util.*;

public class Words {
	TreeSet<String> stringSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	
	/**
	 * adds word
	 * @param word
	 * @return true if added, otherwise false if an word already exists (case insensitive)
	 */
	public boolean addWord(String word) {

		return stringSet.add(word);
	}
	/**
	 * 
	 * @param prefix
	 * @return list of words starting from a given prefix (case insensitive)
	 */
	public List<String> getWordsByPrefix(String prefix) {
		List<String> listPref = new LinkedList<>();
		String prefixPlus = prefixPlus(prefix);
		NavigableSet<String> subTree = stringSet.subSet(prefix, true, prefixPlus, false);
		
		for(String str: subTree) {
			if(str.toLowerCase().startsWith(prefix.toLowerCase())) {
				
				listPref.add(str);
			}
		}
		return listPref;
	}
	
	public static String prefixPlus(String prefix) {
		int len = prefix.length();
		char[] charAr = prefix.toCharArray();
		char lastChar = charAr[len - 1];
		char lastCharPlus = (char)((int)lastChar + 1);
		charAr[len - 1] = lastCharPlus;		
		
		return new String(charAr);
	}
	
}
