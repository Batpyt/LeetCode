package 堆;

import java.util.*;
public class MedianFinder {
	Queue<Integer> minHeap, maxHeap;
    public MedianFinder() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }
    
    public void addNum(int num) {
    	if(minHeap.size() > maxHeap.size()) {
    		minHeap.add(num);
    		maxHeap.add(minHeap.poll());
    	}
    	else {
    		maxHeap.add(num);
    		minHeap.add(maxHeap.poll());
    	}

    }
    
    public double findMedian() {
    	if(minHeap.size() == maxHeap.size()) {
    		return (minHeap.peek() + maxHeap.peek()) / 2.0;
    	}
    	else {
    		return minHeap.peek();
    	}

    }

}
