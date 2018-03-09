package sample.test.collection;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedMapExample {
	public static void main(String[] args) {
      
		SortedSet <WordsCount> set= new TreeSet<WordsCount>();
		WordsCount ws1 = new WordsCount("vivek", 1);
		set.add(ws1);
		ws1 = new WordsCount("sharma", 1);
		set.add(ws1);
		ws1 = new WordsCount("vivek", 2);
		set.add(ws1);
		System.out.println(set);
		
	}
}
	
	class  WordsCount implements Comparable<WordsCount>{
		String name;
		int count;
		public WordsCount(String name, int count) {
			super();
			this.name = name;
			this.count = count;
		}
		@Override
		public int hashCode() {
			//final int prime = 31;
			//int result = 1;
			//result = prime * result + getOuterType().hashCode();
			//result = prime * result + count;
			//result = prime * result + ((name == null) ? 0 : name.hashCode());
			return name.hashCode();
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			WordsCount other = (WordsCount) obj;
		/*	if (!getOuterType().equals(other.getOuterType()))
				return false;*/
			/*if (count != other.count)
				return false;*/
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "WordsCount [name=" + name + ", count=" + count + "]";
		}
		private WordsCount getOuterType() {
			return this;
		}
		@Override
		public int compareTo(WordsCount o) {
			 
			/*if(this.count == o.count) 
				return this.name.compareTo(o.name);
			else{
				
				return -( new Integer(this.count).compareTo(new Integer(o.count)));
			}*/
			return this.name.compareTo(o.name);
		}
		
		
		
}
