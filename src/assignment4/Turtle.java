package assignment4;

public class Turtle extends Critter {

	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		this.walk(0);
		int energy=this.getEnergy();
		
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return false;
	}

}