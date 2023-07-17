package telran.interviews;

import java.util.HashMap;

public class Anagram {
/**
 * 
 * @param word
 * @param anagram
 * @return true if anagram is one of the possible anagrams of a given word
 * anagram is a string containing all symbols from a given word with different order
 * Example: yellow (wolely, lowlye, yellow) , wrong anagrams (yello, yelllw)
 */
	public static boolean isAnagram(String word, String anagram) {
		boolean res = false;
		
		//TODO
		if(word.length() == anagram.length() && word != null) {
			res = getMap(word).equals(getMap(anagram));
			}
		
		return res;		
	}

	private static HashMap<String, Integer> getMap(String str) {
		String[] arStr = str.split("");
		HashMap<String, Integer> hashMapStr = new HashMap<>();
		for(String s: arStr) {
			hashMapStr.merge(s, 1, (a, b) -> a + b);
		}		
		return hashMapStr;
	}


}
