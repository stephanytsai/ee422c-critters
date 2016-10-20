/*
 *Turtle walks in the 1 direction each time step.
 *Turtles do not reproduce. They only fight when encountered.
 *They will show on the board as a "t".  
 */
package assignment4;

public class Turtle extends Critter {
	@Override
	public String toString() {
		return "t"; 
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
