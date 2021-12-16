import java.util.PriorityQueue;
import java.util.Random;
/**
 * Maintains a queue of random directions that the car should go.
 * @author Justin Hixson
 */
public class CarQueue {

	PriorityQueue<Integer> queue = new PriorityQueue<>();
	Random direction = new Random();
	/**
	 * 6 numbers in the queue so that when the animation starts – there will be something to retrieve from the queue
	 */
	public CarQueue() {
		for (int i = 0; i < 6; i++)
			queue.add(direction.nextInt(4));
	}

	public void addToQueue() {
		class RunQueue implements Runnable {
			/** Adds 0,1,2 or 3 to queue
			 *  0 = up
			 *  1 = down
			 *  2 = right
			 *  3 = left
			 */
			@Override
			public void run() {
				queue.add(direction.nextInt(4));
			}
		}
		Runnable run = new RunQueue();
		Thread thread = new Thread(run);

		thread.start();
	}

	public int deleteQueue() {
		return queue.remove();
	}
}