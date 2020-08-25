package 堆;
import java.util.*;

public class Test {
	public static void main(String[] args) {
		Queue<Integer> minHeap = new PriorityQueue<>();
		minHeap.add(1);
		minHeap.add(2);
		System.out.println(minHeap.peek());
		
		Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		maxHeap.add(1);
		maxHeap.add(2);
		System.out.println(maxHeap.peek());
		
	}

}
