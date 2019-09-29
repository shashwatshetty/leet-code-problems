package mediumproblems;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

// Took 2 attempts
// Time Taken To Solve: 35 mins
class BeforeAfterPuzzleSolution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
    	if (phrases == null || phrases.length == 0) {
    		return new ArrayList<String>();
    	}
        HashMap<String, List<Integer>> trackWordIndex = new HashMap<>();
        HashSet<String> connectedPhrases = new HashSet<>();
        for (int i = 0; i < phrases.length; i++) {
        	String phrase = phrases[i];
        	String first = phrase.split(" ")[0];
        	if (!trackWordIndex.containsKey(first)) {
        		trackWordIndex.put(first, new ArrayList<Integer>());
        	}
        	trackWordIndex.get(first).add(i);
        }

        for (int i = 0; i < phrases.length; i++) {
        	String phrase = phrases[i];
        	String[] phraseWords = phrase.split(" ");
        	String last = phraseWords[phraseWords.length - 1];
        	if (trackWordIndex.containsKey(last)) {
        		for (int j : trackWordIndex.get(last)) {
        			if (i != j) {
	        			String connected = phrase + phrases[j].substring(last.length());
        				connectedPhrases.add(connected);
        			}
        		}
        	}
        }
        List<String> result = new ArrayList<>(connectedPhrases);
        Collections.sort(result);
        return result;
    }
}

public class BeforeAfterPuzzle {
	public static void main(String args[]) {
		BeforeAfterPuzzleSolution obj = new BeforeAfterPuzzleSolution();
		String[] arr = {"a", "b", "a"};
		List<String> ans = obj.beforeAndAfterPuzzles(arr);
		for (String p : ans) {
			System.out.println(p);
		}
	}
}