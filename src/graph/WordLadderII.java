package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
    	List<List<String>> res = new ArrayList<>();
    	// edge case
    	if (!wordList.contains(endWord)) {
    		return res;
    	}
    	
    	// step1: construct the transformedMap
    	if (wordList.contains(beginWord)) {
    		wordList.remove(wordList.indexOf(beginWord));
    	}
        Map<String, List<String>> transformedMap = new HashMap<>();
        constructTransformedMap(transformedMap, wordList);
        
        Set<String> wordSet = new HashSet<>(wordList);
        
        // step2: bfs, parentMap, levelMap
        
        Map<String, List<String>> parentMap = new HashMap<>();
        parentMap.put(beginWord, new ArrayList<>(Arrays.asList(new String[] {" "})));
        Map<String, Integer> levelMap = new HashMap<>();
        levelMap.put(beginWord, 1);
        bfs(parentMap, levelMap, transformedMap, beginWord, endWord);
        
        
        if (!parentMap.containsKey(endWord)) {
        	return res;
        }
        // step3: construct the paths, backtracking, dfs
        List<String> curRes = new ArrayList<>();
        curRes.add(endWord);
        constructPath(endWord, beginWord, parentMap, curRes, res);
        for(List<String> r : res) {
        	Collections.reverse(r);
        }
        return res;
    }
    
    private static void bfs(Map<String, List<String>> parentMap, Map<String, Integer> levelMap, Map<String, List<String>> transformedMap, String beginWord, String endWord) {
    	Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int curLevel = 0;
        while (queue.size() > 0) {
        	curLevel++;
        	if (levelMap.containsKey(endWord)) {
    			if (curLevel == levelMap.get(endWord)) {
    				break;
    			}
    		}
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		String curWord = queue.poll();
        		String[] genericForms = getGenericForm(curWord);
        		for (String g : genericForms) {
        			if (!transformedMap.containsKey(g)) {
        				continue;
        			}
        			List<String> nextWords = transformedMap.get(g);
        			for (String nextWord : transformedMap.get(g)) {
        				int nextWordLevel = curLevel + 1;
            			if (levelMap.containsKey(nextWord)) {
            				if (nextWordLevel > levelMap.get(nextWord)) {
            					continue;
            				}else {
            					parentMap.get(nextWord).add(curWord);
            				}
            			}else {
            				levelMap.put(nextWord, nextWordLevel);
            				List<String> l = new ArrayList<>();
            				l.add(curWord);
            				parentMap.put(nextWord, l);
            				queue.add(nextWord);
            			}
        			}
        			
        		}
        	}
        }
		
	}

	private static void constructTransformedMap(Map<String, List<String>> transformedMap, List<String> wordList) {
    	for (String s : wordList){
        	String[] genericForm = getGenericForm(s);
        	for (String g : genericForm) {
        		List<String> temp = transformedMap.getOrDefault(g, new ArrayList<>());
        		temp.add(s);
        		transformedMap.put(g, temp);
        	}

        }
		
	}

	private static void constructPath(String curWord, String beginWord, Map<String, List<String>> parentMap, List<String> curRes, List<List<String>> res) {
		// TODO Auto-generated method stub
    	if (curWord.equals(beginWord)) {
    		// have to create a deep copy of curRes
    		// curRes is a parameter in the func, would be modified frequently
    		res.add(new ArrayList<>(curRes));
    		return;
    	}
    	for (String parentWord : parentMap.get(curWord)) {
    		curRes.add(parentWord);
    		constructPath(parentWord, beginWord, parentMap, curRes, res);
    		curRes.remove(curRes.size() - 1);
    	}

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
		// TODO Auto-generated method stub
//		String beginWord = "hit";
//		String endWord = "cog";
//	    String[] wordArray = {"hot","dot","dog","lot","log","cog"};
		String beginWord = "hot";
		String endWord = "dog";
		String[] wordArray = {"hot","dog"};
		List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));
	    List<List<String>> res= findLadders(beginWord, endWord, wordList);
	    System.out.print("a");

	}

}
