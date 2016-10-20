/*
 *MyCritter3 walks in the 1 direction each time step.
 *They do not reproduce. They will always fight 
 *when encountered. They will show on the board as a "3".  
 */
package assignment4;

public class MyCritter3 extends Critter {
	@Override
	public String toString() {
		return "3"; 
	}
	
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
	
		this.walk(1); //energy level reduced in walk function
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return true;
	}
	


}
