import java.util.PriorityQueue;
import java.util.Random;
/**
 * Maintains a queue of random directions that the car should go.
 * @author Justin Hixson
 */
public class CarQueue {

	PriorityQueue<Integer> queue = new PriorityQueue<>();
	Random direction = new Random();

	public CarQueue() {
		for (int i = 0; i < 6; i++)
			queue.add(direction.nextInt(4));
	}

	public void addToQueue() {
		class RunQueue implements Runnable {

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