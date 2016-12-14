/* Jordan Stein
 *  My solution is deadlock free because I do not allow any chop sticks to be picked up unless both are available.
 *  Once a philosopher has both chop sticks, they will drop both right after they are done eating, making them available to use in the next cycle.
 *  My solution is starvation free because every philosopher eventually gets a chance to eat. (usually after 4 cycles everyone has eaten once)
 */

package pa5;

public class DiningPhilosophers{
	public static void main(String[] args){

		Chopstick cs1 = new Chopstick();
		Chopstick cs2 = new Chopstick();
		Chopstick cs3 = new Chopstick();
		Chopstick cs4 = new Chopstick();
		Chopstick cs5 = new Chopstick();
		
		Thread p1 = new Thread(new Philosopher(1, cs5, cs1));
		Thread p2 = new Thread(new Philosopher(2, cs1, cs2));
		Thread p3 = new Thread(new Philosopher(3, cs2, cs3));
		Thread p4 = new Thread(new Philosopher(4, cs3, cs4));
		Thread p5 = new Thread(new Philosopher(5, cs4, cs5));

		p1.start();
		p2.start();
		p3.start();
		p4.start();
		p5.start();
		
	}
	
}