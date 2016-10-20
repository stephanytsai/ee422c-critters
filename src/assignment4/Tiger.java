/*
 *Tiger runs in a random direction at each time step. 
 *On the board, tigers will show as a "T". Tigers
 *do not reproduce.  
 */
package assignment4;

public class Tiger extends Critter{
	
	public int dir;
	// Tiger constructor
	public Tiger() {
		dir = Critter.getRandomInt(8);
	}
	
	@Override
	public String toString() {
		return "T";
	}
	
	
	// Runs in direction 7 and uses amt of energy in run_energy_cost
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		this.run(dir); 
		
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return true;
	}

}
