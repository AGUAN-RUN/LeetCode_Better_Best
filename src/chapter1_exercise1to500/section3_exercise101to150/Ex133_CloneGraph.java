package chapter1_exercise1to500.section3_exercise101to150;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;
import commons.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.
Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.

Test case format:

For simplicity sake, each node's value is the same as the node's index (1-indexed). For example, the first node with val = 1, the second node with val = 2, and so on. The graph is represented in the test case using an adjacency list.
Adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

Constraints:
1 <= Node.val <= 100
Node.val is unique for each node.
Number of Nodes will not exceed 100.
There is no repeated edges and no self-loops in the graph.
The Graph is connected and all nodes can be visited starting from the given node.

*/
//用时39ms 击败38%的用户  有待优化
public class Ex133_CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Integer,Node>nodes = new HashMap<>();
        Node copyNode=new Node(node.val);
        cloneGraphWorker(nodes,node,copyNode);
        return copyNode;
    }
    public void cloneGraphWorker(Map<Integer,Node>nodes,Node node,Node copyNode){
        if(nodes.containsKey(node.val))return;
        nodes.put(copyNode.val,copyNode);
        List<Node>neighbors=node.neighbors;
        List<Node>copyNeighbors=new ArrayList<>();
        copyNode.neighbors=copyNeighbors;
        for(int i=0;i<neighbors.size();i++){
            Node neighborNode=neighbors.get(i);
            if(nodes.containsKey(neighborNode.val)){
                copyNeighbors.add(nodes.get(neighborNode.val));
            }else {
                Node newNode=new Node(neighborNode.val);
                copyNeighbors.add(newNode);
                cloneGraphWorker(nodes,neighborNode,newNode);
            }
        }

    }
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
