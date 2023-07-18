package telran.interviews;

import java.util.*;

public class Words {
	//TODO
	TreeSet<String> stringSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
	
	
	/**
	 * adds word
	 * @param word
	 * @return true if added, otherwise false if an word already exists (case insensitive)
	 */
	public boolean addWord(String word) {
		int sizeBefore = stringSet.size();
		stringSet.add(word);
		return sizeBefore == stringSet.size();
	}
	/**
	 * 
	 * @param prefix
	 * @return list of words starting from a given prefix (case insensitive)
	 */
	public List<String> getWordsByPrefix(String prefix) {
		List<String> listPref = new LinkedList<>();
		for(String str: stringSet) {
			if(str.toLowerCase().startsWith(prefix.toLowerCase())) {
				
				listPref.add(str);
			}
		}
		return listPref;
	}
			
	
}
