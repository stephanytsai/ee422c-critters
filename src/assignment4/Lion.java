package assignment4;

public class Lion extends Critter {
	
	// Represent the Lion Critter subclass with the char "L"
	@Override
	public String toString() {
		return "L";
	}
	
	// Lion will walk in direction 4 and use amt of energy in walk_energy_cost
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		this.walk(4);	
		
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return false;
	}

}
