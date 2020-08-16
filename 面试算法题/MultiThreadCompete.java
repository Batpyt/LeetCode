package 面试算法题;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreadCompete extends Thread{
	static final int LOOP = 100000;
	static Lock lock = new ReentrantLock();
	static int counter = 0;
	
	public void run() {
		synchronized(lock) {
			for(int i = 0; i < LOOP; i++) {
				counter++;
				//System.out.println(counter);
			}
			//System.out.println(counter);
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		List<MultiThreadCompete> tlist = new ArrayList<>();
		//synchronized(lock) {
			for(int i = 0; i < 100; i++) {
				tlist.add(new MultiThreadCompete());
				tlist.get(i).start();
			}
		//}
		
		
		while(true) {
			if(!tlist.stream().anyMatch(MultiThreadCompete::isAlive)) {
				System.out.println(counter);
				break;
			}
			Thread.sleep(100);
		}
		
	}

}
