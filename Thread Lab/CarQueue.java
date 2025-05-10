import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
public class CarQueue {
	Queue<Integer> dirQueue = new LinkedList<Integer>();
	Random rand = new Random();
	public CarQueue() {
		for(int i = 0; i < 5; i++) {
			dirQueue.add(rand.nextInt(4));
		}
	}
	
	public void addToQueue() {
		class Running implements Runnable {
			@Override
			public void run() {
				int numOfDirections = rand.nextInt(5)+2;
				for(int i = 0; i < numOfDirections; i++) {
					dirQueue.add(rand.nextInt(4));
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("Interrupted Exception");
				}	
			}
		}
		Running car = new Running();
		Thread thread = new Thread(car);
		thread.start();
	}
	
	
	public int deleteQueue() {
		int temp = dirQueue.remove();
		return(temp);
	}
}

