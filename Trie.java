

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Iterative implementation of insert into trie
     */
    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.endOfWord = true;
    }

	
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            //if node does not exist for given char then return false
            if (node == null) {
                return false;
            }
            current = node;
        }
        //return true of current's endOfWord is true else return false.
        return current.endOfWord;
    }


	
	public static void main(String[] args) {
		Trie t = new Trie();
		
		String[] word = {"abc","abgl","cdf","abcd","lmn"};
		
		for(int i = 0 ; i < word.length; i++) {
			t.insert(word[i]);
		}
		
		
		String[] searchWord = {"lmn","ab","cdf", "gh"};
		for(int i = 0 ; i < word.length; i++) {
			
			System.out.println("Word search:  "+searchWord[i]+" : "+t.search(searchWord[i]));
		}
		
	}
}
