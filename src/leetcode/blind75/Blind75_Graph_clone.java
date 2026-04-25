package leetcode.blind75;

import java.util.ArrayList;
import java.util.List;

public class Blind75_Graph_clone {

	public static void main(String[] args) {

		
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