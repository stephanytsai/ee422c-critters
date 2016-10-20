/*
 * Bear runs in the 5 direction each time step if its 
 * energy is less than or equal to 200. Otherwise, it will
 * reproduce and the offspring will be in the space to the 
 * right of it parent. Bears will be shown by a "B". 
 */
package assignment4;

public class Bear extends Critter {
	
	@Override
	public String toString() {
		return "B";
	}
	
	@Override
	public void doTimeStep() {
		// TODO Auto-generated method stub
		if (this.getEnergy()>200){
			Bear offspring=new Bear();
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
