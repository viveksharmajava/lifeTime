package ds500problems.linkedlist;

public class ListProblems {

	public static void main(String[] args) {
		 Node root = new Node('A');
		 root.next = new Node('D');
		 root.next.next = new Node('E');
		 root.next.next.next = new Node('D');
		 root.next.next .next.next = new Node('A');
		 Node n = new Node('A');
		 n.next = root;
		 root =n;
		 System.out.println(isPalindrome(root));
	}

//check if given list is a palindrom or not.
public static boolean isPalindrome(Node root) {
	boolean isPalindrom = true;
	
    Node slow = root;
    Node fast = root.next;
    Node temp;
    Node mid;
    Node reverse_tail = null;
    Node reverse = null;
    while(fast!= null && fast.next!= null){
    	
    	if(reverse == null) {
    		temp = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    		reverse= temp;
    		reverse.next  = null;
    		reverse_tail = reverse;
    	}else {
    		temp = slow;
    		slow = slow.next;
    		fast = fast.next.next;
    		temp.next = reverse;
    		reverse = temp;
    	}
    }
    mid = slow;
    reverse_tail.next = mid;
    temp = mid.next;
    while(temp !=null && reverse !=mid) {
    	if(temp.data != reverse.data) {
    		isPalindrom = false;
    		break;
    	}
    	temp = temp.next;
    	reverse =reverse.next;
    }
    if(temp!=null)//list is even size
    	isPalindrom =false;
    
	return isPalindrom;
	
}
	
}



class Node{
	Character data;
	Node next;
	Node(){
		
	}
	Node(Character d){
		this.data = d;
	}
}
