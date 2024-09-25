class Solution {
    class TrieNode {
        TrieNode[] child;
        int count;
        TrieNode(){
            child = new TrieNode[26];
            count = 0;
        }
    }
    TrieNode root;

    private void insert(String s){
        TrieNode node = root;
        for(char c: s.toCharArray()){
            if(node.child[c-'a']==null){
                node.child[c-'a'] = new TrieNode();
            }
            node = node.child[c-'a'];
            node.count+=1;
        }
    }
    private int getScoreSum(String s){
        TrieNode node = root;
        int count = 0;
        for(char c: s.toCharArray()){
            node = node.child[c-'a'];
            count+=node.count;
        }
        return count;
    }
    public int[] sumPrefixScores(String[] words) {
        root = new TrieNode();
        for(String s: words){
            insert(s);
        }
        int ans[] = new int [words.length];
        for(int i=0; i<words.length; i++){
            ans[i] = getScoreSum(words[i]);
        }
        return ans;   
    }
}