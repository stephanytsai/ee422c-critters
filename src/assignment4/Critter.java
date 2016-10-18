/* CRITTERS Critter.java
 * EE422C Project 4 submission by
 * Replace <...> with your actual data.
 * <Student1 Name>
 * <Student1 EID>
 * <Student1 5-digit Unique No.>
 * <Student2 Name>
 * <Student2 EID>
 * <Student2 5-digit Unique No.>
 * Slip days used: <0>
 * Fall 2016
 */
package assignment4;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;

/* see the PDF for descriptions of the methods and fields in this class
 * you may add fields, methods or inner classes to Critter ONLY if you make your additions private
 * no new public, protected or default-package code or data can be added to Critter
 */


public abstract class Critter {
	private static String myPackage;
	private	static List<Critter> population = new java.util.ArrayList<Critter>();
	private static List<Critter> babies = new java.util.ArrayList<Critter>();

	// Gets the package name.  This assumes that Critter and its subclasses are all in the same package.
	static {
		myPackage = Critter.class.getPackage().toString().split(" ")[1];
	}
	
	private static java.util.Random rand = new java.util.Random();
	public static int getRandomInt(int max) {
		return rand.nextInt(max);
	}
	
	public static void setSeed(long new_seed) {
		rand = new java.util.Random(new_seed);
	}
	
	
	/* a one-character long string that visually depicts your critter in the ASCII interface */
	public String toString() { return ""; }
	
	private int energy = 0;
	protected int getEnergy() { return energy; }
	
	private int x_coord;
	private int y_coord;
	protected int getX(){ return x_coord;}
	protected int getY(){ return y_coord;}
	
	protected final void walk(int direction) {
		if (direction==0){
			this.x_coord++;
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
		}else if(direction==1){
			this.x_coord++;
			this.y_coord++;
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
		}else if(direction==2){
			this.y_coord++;
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);

		}else if(direction==3){
			this.x_coord--;
			this.y_coord++;
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);

		}else if (direction==4){
			this.x_coord--;
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
		}else if(direction==5){
			this.x_coord--;
			this.y_coord--;
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);

		}else if(direction==6){
			this.y_coord--;
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);

		}else if(direction==7){
			this.x_coord++;
			this.y_coord--;
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);

		}
		int energy=this.getEnergy();
		energy=energy-Params.walk_energy_cost; //subtract energy needed to walk here
	}
	
	protected final void run(int direction) {
		if (direction==0){
			this.x_coord+=2;
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
		}else if(direction==1){
			this.x_coord+=2;
			this.y_coord+=2;
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);

		}else if(direction==2){
			this.y_coord+=2;
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);

		}else if(direction==3){
			this.x_coord-=2;
			this.y_coord+=2;
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
			
		}else if (direction==4){
			this.x_coord-=2;
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
		}else if(direction==5){
			this.x_coord-=2;
			this.y_coord-=2;
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);

		}else if(direction==6){
			this.y_coord-=2;
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);

		}else if(direction==7){
			this.x_coord+=2;
			this.y_coord-=2;
			this.x_coord= Math.floorMod(this.x_coord, Params.world_width);
			this.y_coord= Math.floorMod(this.y_coord, Params.world_height);
 

		}
		int energy=this.getEnergy();
		energy=energy-Params.run_energy_cost; 
	}
	
	/**
	 * Places the new offspring in an adjacent coordinate location to the parent, according to the direction that is passed
	 * @param offspring
	 * @param direction
	 */
	@SuppressWarnings("unchecked")
	protected final void reproduce(Critter offspring, int direction) {
		offspring.setEnergy(this.getEnergy()/2);
		offspring.walk(direction);
		Iterator I=babies.iterator();
		Critter current;
		while(I.hasNext()){
			current=(Critter) I.next();
		}
		babies.add(offspring); 
		
	}

	public abstract void doTimeStep();
	public abstract boolean fight(String oponent);
	
	protected void setEnergy(int new_energy_value) {
		energy = new_energy_value;
	}
	
	protected void setX_coord(int new_x_coord) {
		x_coord = new_x_coord;
	}
	
	protected void setY_coord(int new_y_coord) {
		y_coord = new_y_coord;
	}
	
	/**
	 * create and initialize a Critter subclass.
	 * critter_class_name must be the unqualified name of a concrete subclass of Critter, if not,
	 * an InvalidCritterException must be thrown.
	 * (Java weirdness: Exception throwing does not work properly if the parameter has lower-case instead of
	 * upper. For example, if craig is supplied instead of Craig, an error is thrown instead of
	 * an Exception.)
	 * @param critter_class_name
	 * @throws InvalidCritterException
	 * @throws IllegalAccessException 
	 */

	public static void makeCritter(String critter_class_name) throws InvalidCritterException, InstantiationException, ClassNotFoundException, IllegalAccessException {
		Critter critterInstance = null;
		Class critterType; 
		String name="";
		try { 
			name=name.concat("assignment4."+critter_class_name);
			critterType = Class.forName(name); 
			critterInstance =  (Critter) critterType.newInstance(); 
		} catch (ClassNotFoundException e) {
			return;
			//throw new InvalidCritterException(e.toString());
		} catch (IllegalAccessException | InstantiationException e){
		//	throw new InvalidCritterException(e.toString());
			return;
		}
		
		(critterInstance).setX_coord(getRandomInt(Params.world_width));
		(critterInstance).setY_coord(getRandomInt(Params.world_height));
		(critterInstance).setEnergy(getRandomInt(Params.start_energy));
		
		CritterWorld.critterCollection.add(critterInstance); //ADDING CRITTER
		
		//TODO if critter is reproduced, energy reset in reproduce fxn
		
	}
	
	/**
	 * Gets a list of critters of a specific type.
	 * @param critter_class_name What kind of Critter is to be listed.  Unqualified class name.
	 * @return List of Critters.
	 * @throws InvalidCritterException
	 */
	public static List<Critter> getInstances(String critter_class_name) throws InvalidCritterException {
		List<Critter> result = new java.util.ArrayList<Critter>();
		Critter critterInstance = null;
		Class critterType; 

		try { 
			critterType = Class.forName(critter_class_name); 
		} catch (ClassNotFoundException e) {
		    throw new InvalidCritterException(e.toString());
		}
		for (Critter c:CritterWorld.critterCollection){
			if (c.getClass().equals(critterType)){ //add if same critter type
				result.add(c);
			}
		}
		
		return result;
	}
	
	/**
	 * Prints out how many Critters of each type there are on the board.
	 * @param critters List of Critters.
	 */
	public static void runStats(List<Critter> critters) {
		System.out.print("" + critters.size() + " critters as follows -- ");
		java.util.Map<String, Integer> critter_count = new java.util.HashMap<String, Integer>();
		for (Critter crit : critters) {
			String crit_string = crit.toString();
			Integer old_count = critter_count.get(crit_string);
			if (old_count == null) {
				critter_count.put(crit_string,  1);
			} else {
				critter_count.put(crit_string, old_count.intValue() + 1);
			}
		}
		String prefix = "";
		for (String s : critter_count.keySet()) {
			System.out.print(prefix + s + ":" + critter_count.get(s));
			prefix = ", ";
		}
		System.out.println();		
	}
	
	/* the TestCritter class allows some critters to "cheat". If you want to 
	 * create tests of your Critter model, you can create subclasses of this class
	 * and then use the setter functions contained here. 
	 * 
	 * NOTE: you must make sure that the setter functions work with your implementation
	 * of Critter. That means, if you're recording the positions of your critters
	 * using some sort of external grid or some other data structure in addition
	 * to the x_coord and y_coord functions, then you MUST update these setter functions
	 * so that they correctly update your grid/data structure.
	 */
	static abstract class TestCritter extends Critter {
		protected void setEnergy(int new_energy_value) {
			super.energy = new_energy_value;
		}
		
		protected void setX_coord(int new_x_coord) {
			super.x_coord = new_x_coord;
		}
		
		protected void setY_coord(int new_y_coord) {
			super.y_coord = new_y_coord;
		}
		
		protected int getX_coord() {
			return super.x_coord;
		}
		
		protected int getY_coord() {
			return super.y_coord;
		}
		

		/*
		 * This method getPopulation has to be modified by you if you are not using the population
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.
		 */
		protected static List<Critter> getPopulation() {
			population=CritterWorld.critterCollection; 
			return population; //returns list of non-babies
		}
		
		/*
		 * This method getBabies has to be modified by you if you are not using the babies
		 * ArrayList that has been provided in the starter code.  In any case, it has to be
		 * implemented for grading tests to work.  Babies should be added to the general population 
		 * at either the beginning OR the end of every timestep.
		 */
		protected static List<Critter> getBabies() {
			return babies; //returns list of babies
		}
	}
	
	
	/**
	 * subtracts rest_energy
	 * clears dead critters from critterworld
	 * returns updated list 
	 * 
	 * @return
	 */
	
	private static List<Critter> clearDead(){ 
		Iterator I=CritterWorld.critterCollection.iterator();
		Critter current;
		while(I.hasNext()){
			current=(Critter) I.next();
			int energy= current.getEnergy();
			energy=energy-Params.rest_energy_cost;
			current.setEnergy(energy);
			if (energy<=0){
				I.remove(); 
			}
		}
		return CritterWorld.critterCollection; 
	}
	
	/**
	 * Clear the world of all critters, dead and alive
	 */
	public static void clearWorld() {
		Iterator I= CritterWorld.critterCollection.iterator(); 
		Critter current;
		while (I.hasNext()){
			current=(Critter) I.next();
			I.remove();
		}
		
	}
	
	/**
	 * Check to see if a critter (this) is in the same position as another critter (c2)
	 * @param c2
	 * @return
	 */
	public boolean isSamePostion(Critter c2) {
		if ( (this.getX() == c2.getX()) && (this.getY() == c2.getY())){
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Resolve encounter between two critters that occupy the same location
	 * @param c1
	 * @param c2
	 */
	private static void resolveEncounter(Critter c1, Critter c2) {
		//determine which critters want to attack and give them an attack power number
		boolean c1fight = c1.fight(c2.toString()); 
		boolean c2fight = c2.fight(c1.toString());
		int c1Attack = 0;
		int c2Attack = 0;
		
	
		if (c1.getEnergy()>0 && c1fight){
			c1Attack = Critter.getRandomInt(c1.getEnergy());
		}else if (c2.getEnergy()>0 && c2fight){
			c2Attack = Critter.getRandomInt(c2.getEnergy());
		}else if (c2.getEnergy()<=0){
			c2.setEnergy(0);
		}else if (c1.getEnergy()<=0){
			c1.setEnergy(0);
		}
	//	if(c1fight){ c1Attack = Critter.getRandomInt(c1.getEnergy());}
	//	if(c2fight){ c2Attack = Critter.getRandomInt(c2.getEnergy());}
		
		//use attack power number to determine which critter wins 
		//winner retains energy and is awarded 1/2 losers energy. Loser dies (Energy is set to <= 0).
		if(c1Attack >= c2Attack){
			int c1Energy = c1.getEnergy() + (c2.getEnergy()/2);
			c1.setEnergy(c1Energy);
			c2.setEnergy(0);
		}
		else{
			int c2Energy = c2.getEnergy() + (c1.getEnergy()/2);
			c2.setEnergy(c2Energy);
			c1.setEnergy(0);
		}
	}
	
	/**
	 *invoke doTimeStep for each critter in critterworld
	 *encounters
	 *rest energy
	 *generate algae
	 *add babies to population
	 *clear dead
	 */
	public static void worldTimeStep() {
		Iterator critterIter= CritterWorld.critterCollection.iterator(); 
		Critter current; 
		while(critterIter.hasNext()){
			current=(Critter) critterIter.next();
			current.doTimeStep();
		}
		//if more than one critter in space, 
		//encounter
		int i;
		int j;
		int numCritters = CritterWorld.critterCollection.size();
		for (i=0; i<numCritters; i++){
			current = CritterWorld.critterCollection.get(i);
			for(j=i+1; j<numCritters; j++){
				Critter nextCritter = CritterWorld.critterCollection.get(j);
				//compare current to nextCritter in terms of coordinate location
				if(current.isSamePostion(nextCritter) && (current.getEnergy()*nextCritter.getEnergy() > 0)){
					Critter.resolveEncounter(current, nextCritter);
				}
			}
		}
 
		
		//TODO generate algae
		//add babies to population
		Iterator babiesI= babies.iterator(); 
		Critter currentB;
		while (babiesI.hasNext()){
			CritterWorld.critterCollection.add((Critter) babiesI.next());
		}
		babies.clear();
		Critter.clearDead(); //rest energy and clear dead
	}
	
	
	/**displayWorld()
	 * create a matrix of values height x width
	 * prints top border
	 * for each critter in critter world
	 * 		prints each position [row][col] of grid
	 * end
	 * prints bottom border
	 * print matrix
	 */
	public static void displayWorld() {
		String array[][]=new String[Params.world_width][Params.world_height];  //height is rows, width is cols

		Iterator I= CritterWorld.critterCollection.iterator(); 
		Critter current; 
		String word;
		while(I.hasNext()){
			current=(Critter) I.next();
			/*int x=current.getX(); //DEBUG
			int y=current.getY();
			System.out.println("x: "+ x+" y: "+y);*/
			array[current.x_coord][current.y_coord]=current.toString();
			
		}

		
		//printing first border
		System.out.print("+"); //not println so won't have --- on a new line
		for (int i=0; i<Params.world_width; i++){
			System.out.print("-"); //TODO don't know if this has spaces
		}
		System.out.println("+"); //println moves cursor to new line after printing "+"
		
		//printing grid
		for (int i=0; i<Params.world_height; i++){
			System.out.print("|"); //side border
			for (int j=0; j<Params.world_width; j++){ //prints each row
				if(array[j][i]==null){
					System.out.print(" "); 
				}else{
					System.out.print(array[j][i]); 
				}
			}
			System.out.println("|");
		}
		
		//bottom border
		System.out.print("+"); 
		for (int i=0; i<Params.world_width; i++){
			System.out.print("-");
		}
		System.out.println("+"); 		
	}
}
