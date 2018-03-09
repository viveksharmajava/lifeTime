package sample.test.problems.linkedLists;

//How to find middle element of linked list in one pass?
//javarevisited.blogspot.com/2013/03/top-15-data-structures-algorithm-interview-questions-answers-java-programming.html#ixzz4KREiw6E5
public class FindMiddleElementInListInOnePass {

	public <T> Node<T> middleNode(Node <T> inputList){
		Node <T> middle =inputList;  
		Node <T> last = inputList;
		if(inputList == null) return middle;
		int i=1;
		while(last != null){
			
			if(i%2 == 0){
				middle =middle.next;
			}
			last = last.next;
			i++;
			
		}
		
		System.out.println(" i ="+i);
		if(i%2 == 1){
			
			middle =middle.next;
		}
		return middle;
	}
}
