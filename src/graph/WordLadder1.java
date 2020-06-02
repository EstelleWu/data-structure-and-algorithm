package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)){
            return 0;
        }
        
        String temp = "abcdefghijklmnopqrstuvwxyz";
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int res = 0;
        while (queue.size() > 0){
            int size = queue.size();
            res++;
            // level by level bfs
            for (int i = 0; i < size; i++){
                String cur = queue.poll();
                if (cur.equals(endWord)){
                    return res;
                }
                // find the next word
                // only add to queue if not visited and in wordSet
                
                for (int j = 0; j < cur.length(); j++){
                    for (int k = 0; k < 26; k++){
                        StringBuilder curSb = new StringBuilder(cur);
                        curSb.setCharAt(j, temp.charAt(k));
                        String next = curSb.toString();
                        if (!visited.contains(next) && wordSet.contains(next)){
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                }

            }
        }
        return 0;
        
    }

	public static void main(String[] args) {
		String[] wordArray = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));
		int res = ladderLength("hit", "cog", wordList);
		System.out.println(res);
	}

}
