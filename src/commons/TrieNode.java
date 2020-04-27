package commons;
//prifix_tree  node
public class TrieNode {
    //if this node is a leaf-node of prifix-tree
    private TrieNode[]links;
    private final int Size=26;
    private boolean isEnd;
    public TrieNode(){
        this.links=new TrieNode[Size];
    }

    public TrieNode get(char aChar){
        return  links[aChar-'a'];
    }
    public void put(char aChar,TrieNode TrieNode){
          links[aChar-'a']=TrieNode;
    }
    public boolean contains(char aChar){
       return links[aChar-'a']!=null;
    }
    public boolean getIsEnd(){
        return this.isEnd;
    }
    public void setIsEnd(boolean isEnd){
        this.isEnd=isEnd;
    }
}
