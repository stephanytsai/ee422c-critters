package assignment4;

public class Help {
	/**
	 * checks if a word is in a String[]
	 * @param find
	 * @param group
	 * @return
	 */
	public static boolean isin(String find, String[] group){
		for (String s:group){
			if (find.equals(s)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * checks if a is a critter type 
	 * @param a
	 * @return
	 */
	public static boolean isType(String a){
		String[] types={"Turtle", "Critter", "Lion", "Tiger",
				"Bear", "Algae", "Craig"};
		if(isin(a,types)){
			return true;
		}
		return false; 
	}
	
	 /**
     * is the input an integer?
     * @param a
     * @return 
     */
	public static boolean isInt(String a){
		int i=0;
		try{
			i=Integer.parseInt(a);
			return true;
		}catch(NumberFormatException e){
			//System.out.println("contine!");
			return false;
		}
	}
    /**
     * 1. words in input array exist in valid word list?
     * 		-yes: look at other words
     * 		-no: is it an integer?
     * 			-yes: look at other words
     * 			-no: caught invalid word
     * @param array
     * @return true: all words 
     */
	public static boolean validInput (String[] array){ //deleted static from both
		String[] valid={"make", "show", "step", "seed", "make", 
				"stats","Turtle","Tiger", "Lion", "Bear", "TestCritter",
				"Algae", "Craig"};
		boolean gotvalid=false;
		int num;
		for (String word:array){
			gotvalid=false;
			if (isin(word,valid)){
				gotvalid=true;
			}else{
				if (isInt(word)){
					gotvalid=true;
				}
			}
			if(gotvalid==false){
				return false;
			}			
		}
		
		return true;
	}
	
	/**
	 * checks for invalid commands
	 * implements quit, make, show, step, seed, stats
	 * @param a
	 * @param user
	 */
	public static void implementInput(String[] a, String user){
		if (a[0].equals("quit") && a.length==1){
			System.exit(0); 
		}else if (a[0].equals("show") && a.length==1){
			//Critter.displayWorld();
			System.out.println("displaying world");//DEBUG
		}else if (a[0].equals("step")){
			if(a.length==1){
				System.out.println("WorldTimeStep once");//DEBUG
			}else if (a.length==2 && isInt(a[1])){
				//world time step this a[1] times 
				//run world time step here?
				//parse to int
				System.out.println("WorldTimeStep "+ a[1]);//DEBUG
			}else{
				System.out.println("invalid command: "+ user);
			}
		}else if (a[0].equals("seed") && a.length==2){
			if (isInt(a[1])){
				//Critter.setSeed();
				System.out.println("Critter.setSeed()"); //DEBUG
			}
		}else if(a[0].equals("make") && (a.length==2 || a.length==3)){
			int numMake=0;
			if(a.length==3 && isInt(a[2])){
				numMake=Integer.parseInt(a[2]);
			}
			if(isType(a[1])){
				//for(int i=0; i<numMake; i++){make critters}
					//Critter.makeCritter()
				System.out.println("Critter.makeCritter(): "+ numMake); //DEBUG
			}else{
				System.out.println("invalid command: "+ user);
			}
		}else if (a[0].equals("stats") && a.length==1){
			//Critter.getInstances()
				//types.runStats()
			System.out.println("runStats()"); //DEBUG
			
		}else{
			System.out.println("invalid command: "+ user);
		}
	}
}
