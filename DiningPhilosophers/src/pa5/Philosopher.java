//Jordan Stein

package pa5;

import java.io.IOException;

public class Philosopher implements Runnable {

	int pnum; //philosopher number
	Chopstick leftChopStick;
	Chopstick rightChopStick;
	String action = "hungry"; // can be hungry or eating, all philosophers will be hungry for first cycle
	//int eatCount = 0; //number of times this philosopher has eaten
	boolean hasEaten = false;
	
	public Philosopher(int pnum, Chopstick left, Chopstick right)
	{
		this.pnum = pnum;
		this.leftChopStick = left;
		this.rightChopStick = right;
	}
	
	public void sleep()
	{
		try{Thread.sleep(5000);} // sleep for 5 seconds
		catch(InterruptedException e){}
	}
	
	private void grabChopSticks()
	{
		this.leftChopStick.held = true;
		this.rightChopStick.held = true;
	}
	private void releaseChopSticks()
	{
		this.leftChopStick.held = false;
		this.rightChopStick.held = false;
	}
	
	public void updateStatus()
	{
		if (this.action == "hungry"){
			System.out.println("Philosopher "+this.pnum+" is hungry");
			if (rightChopStick.held == false && leftChopStick.held == false) // if both chop sticks are available, philosopher will eat in next cycle
			{	
				this.grabChopSticks();
				this.action = "eating"; // they will be eating in the next cycle
				//this.eatCount++;
			}
		}
		else if (this.action == "eating"){ // prompt that they are eating and drop chop sticks.
			System.out.println("Philosopher "+this.pnum+" is eating");
			this.releaseChopSticks();
			this.action = "thinking";	// they are done eating / now thinking for the next cycle
		}
		else if (this.action == "thinking"){
			System.out.println("Philosopher " + this.pnum + " is thinking"); // philosopher will think if they are done eating
		}
		sleep();
	}

	public void run() {
		long startTime = System.currentTimeMillis(); // used to set runtime for a minute
		do{
			this.updateStatus();
		} while((System.currentTimeMillis()-startTime)< 35*1000); // runs for 35 seconds
	}
}
