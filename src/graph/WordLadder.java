package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)){
            return 0;
        }
        
        // step1: construct the transformedMap
        Map<String, List<String>> map = new HashMap<>();
        for (String s : wordList){
        	String[] genericForm = getGenericForm(s);
        	for (String g : genericForm) {
        		List<String> temp = map.getOrDefault(g, new ArrayList<>());
        		temp.add(s);
        		map.put(g, temp);
        	}

        }
        
        Set<String> wordSet = new HashSet<>(wordList);
        
        // step2: bfs
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 0;
        while (q.size() > 0) {
        	int qSize = q.size();
        	res++;
        	for (int i = 0; i < qSize; i++) {
        		String word = q.poll();
//        		 if (word == endWord) {
        		if (word.equals(endWord)) {
//        		if (word.compareTo(endWord) == 0) {
        			return res;
        		}
        		String[] genericForm = getGenericForm(word);
        		for (String g : genericForm) {
        			if (map.containsKey(g)) {
        				List<String> transformedWords = map.get(g);
        				for (String transformedWord : transformedWords) {
        					if (wordSet.contains(transformedWord)) {
            					q.add(transformedWord);
            					wordSet.remove(transformedWord);
            				}
        				}	
        			}
        		}
        	}
        }
        return 0;
        
    }
	private static String[] getGenericForm(String s) {
		// TODO Auto-generated method stub
	  String[] res = new String[s.length()];
      for (int i = 0; i < s.length(); i++){
          StringBuilder sb = new StringBuilder();
          for (int j = 0; j < s.length(); j++){
              if (j == i){
                  sb.append('*');
              }else{
                  sb.append(s.charAt(j));
              }
          }
          res[i] = sb.toString();
      }
	  return res;
	}
	
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
	    String[] wordArray = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));
	    int res= ladderLength(beginWord, endWord, wordList);
	    System.out.print("a");
		// TODO Auto-generated method stub

	}

}

// TODO: why for each loop works for array
// TODO: why == (compare String) works here
