package assignment4;

public class Tiger extends Critter{
	
	@Override
	public String toString() {
		return "T";
	}
	
	
	// Runs in direction 7 and uses amt of energy in run_energy_cost
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		this.run(7); 
		
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
