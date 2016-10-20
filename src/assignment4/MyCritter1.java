/*
 * MyCritter1 runs in the 5 direction each time step if its 
 * energy is less than or equal to 200. Otherwise, it will
 * reproduce and the offspring will be in the space to the 
 * right of it parent. MyCritter4 will be shown by a "1". MyCritter4 
 * will always fight if encountered.
 */
package assignment4;

public class MyCritter1 extends Critter {
	
	@Override
	public String toString() {
		return "1";
	}
	
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		if (this.getEnergy()>200){
			MyCritter1 offspring=new MyCritter1();
			this.reproduce(offspring, 0);
		}else{
			this.run(5);
		}
	}

	@Override
	public boolean fight(String oponent) {
		// TODO Auto-generated method stub
		return true;
	}
	


}
