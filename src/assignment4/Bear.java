package assignment4;

public class Bear extends Critter {
	
	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		this.run(5);
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//TODO do we even need a constructor if this is done in makeCritter()?
	public Bear(int start_energy) {
		//get a random position
		//get start energy?
		super.setEnergy(start_energy); //TODO fix
	}

}
