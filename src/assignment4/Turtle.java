package assignment4;

public class Turtle extends Critter {

	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		this.walk(1); //energy level reduced in walk function
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
