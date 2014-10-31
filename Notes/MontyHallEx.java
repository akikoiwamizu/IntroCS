import java.util.Random;
 
/** 
 * Simulates the MontyHall problem. 3 doors, 2 with goats and 1 with car. You choose a door, 
 * Monty hall opens one of the other two to reveal a goat. How often will you be correct if you
 * stay? How often if you switch? 
 * @author copeg
 *
 */
public class MontyHallSimulation implements Runnable{
 
	/*Random number generator */
	private static final Random RANDOM = new Random();
	/*Number of rounds to simulate*/
	private int rounds;
	/*Number of doors total*/
	private int doors;
	/*Rate for staying*/
	private double stayRate = 0;
	/*Rate for changing*/
	private double changeRate = 0;
 
	/**
	 * Constructs a MontyHallSimulation with 3 doors, to iterate 1000 times. 
	 */
	public MontyHallSimulation(){
		this(1000);
	}
	/**
	 * Constructs a MontyHallSimulation with the number of rounds to simulate, and 
	 * 3 doors.
	 * @param rounds The number of rounds to simulate.
	 */
	public MontyHallSimulation(int rounds){
		this(rounds, 3);
	}
 
	/**
	 * Constructs a MontyHallSimulation with the number of rounds and doors to use in
	 * the simulation. 
	 * @param rounds The number of rounds to simulate
	 * @param doors The number of doors to use in the simulation.
	 * @throws IllegalArgumentException if doors is less than 3.
	 */
	public MontyHallSimulation(int rounds, int doors){
		if ( doors < 3 ){
			throw new IllegalArgumentException("Cannot simulate the problem with less than 3 doors.");
		}
		this.rounds = rounds;
		this.doors = doors;
	}
 
	/**
	 * Implementation of the Runnable interface. Simulates the Monty Hall Problem.
	 * This loops doors number of times, determining whether staying or changing
	 * results in a correct answer. 
	 */
	public void run(){
		int stayCount = 0;
		int changeCount = 0;
		for ( int i = 0; i < rounds; i++ ){
			int choose = RANDOM.nextInt(doors);//choose a door at random
			int solution = RANDOM.nextInt(doors);//find a random place where the car will be.
			if ( solution != choose ){//Car is in the other door - if you change you win
				changeCount++;
			}else{//If you stay you win.
				stayCount++;
			}
		}
		stayRate = stayCount/(double)rounds;
		changeRate = changeCount/(double)rounds;
	}
 
	/**
	 * Retrieves the rate one will be correct if one stays. This method returns
	 * zero unless run has been called. 
	 * @return
	 */
	public double getStayRate(){
		return stayRate;
	}
 
	/**
	 * Retrieves the rate one will be correct if one changes.  This method returns
	 * zero unless run has been called. 
	 * @return
	 */
	public double getChangeRate(){
		return changeRate;
	}
 
	/**
	 * Application entry point. 
	 * @param args
	 */
	public static void main(String[] args){
		MontyHallSimulation sim = new MontyHallSimulation(1000, 1000);
		sim.run();
		System.out.println("Choose to stay: percent correct - " + sim.getStayRate());
		System.out.println("Choose to change: percent correct - " + sim.getChangeRate());
	}