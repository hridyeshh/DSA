package TrieAndHashing;
import java.util.*;
public class TrieNode {
    Map<Character,TrieNode> children; // children map will have the value of the node and the
    // access to the children and endOfString

    TrieNode [] child;

    boolean endOfString; // value of the key of every TrieNode

    public TrieNode(){
        children = new HashMap<>();
        endOfString = false;
    }


    public static void main(String[] args) {
        Trie s = new Trie();
        System.out.println(s);

    }
}
