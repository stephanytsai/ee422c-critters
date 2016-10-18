package assignment4;

public class Turtle extends Critter {
	@Override
	public String toString() {
		return "t"; 
	}
	
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		
	/*	int energy=this.getEnergy();
		if (energy>100){
			Critter offspring=new Turtle();
			offspring.setEnergy(new_energy_value);=this.getEnergy()/2;
			this.reproduce(offspring, 0);
		} //DEBUG help
		*/
		this.walk(1); //energy level reduced in walk function
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return true;
	}
	


}
