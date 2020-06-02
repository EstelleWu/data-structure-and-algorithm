package tree;

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree {
	static class TrieNode{
        Character c;
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        
        TrieNode(Character c){
            this.c = c;
        }
    }
    
    private TrieNode root = new TrieNode('#');
    
    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        ;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode temp = this.root;
        for (int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if (!temp.children.containsKey(c)){
            	TrieNode newNode = new TrieNode(c);
            	// cannot put the construct directly into l32 since constructor doesn't return the object
                temp.children.put(c, newNode);
            }
            temp = temp.children.get(c);
            if (i == word.length() - 1){
                temp.isWord = true;
            }
            
        }
    }
    
    /* return the node if it exist in the trie, otherwise return null*/
    public TrieNode find(String word){
        TrieNode temp = this.root;
        for (int i = 0; i < word.length(); i++){
            Character c = word.charAt(i);
            if (!temp.children.containsKey(c)){
                return null;
            }else{
                temp = temp.children.get(c);
            }
        }
        return temp;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = find(word);
        if (node != null && node.isWord){
            return true;
        }else{
            return false;
        }
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementTriePrefixTree t = new ImplementTriePrefixTree();
		t.insert("apple");
		System.out.println(t.search("apple"));
		System.out.println(t.search("app"));
		System.out.println(t.startsWith("app"));
		t.insert("app");
		System.out.println(t.search("app"));

	}

}
