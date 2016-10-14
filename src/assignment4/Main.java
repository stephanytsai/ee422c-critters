/* CRITTERS Main.java
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
package assignment4; // cannot be in default package
import java.util.Scanner;
import java.io.*;


/*
 * Usage: java <pkgname>.Main <input file> test
 * input file is optional.  If input file is specified, the word 'test' is optional.
 * May not use 'test' argument without specifying input file.
 */
public class Main {

    static Scanner kb;	// scanner connected to keyboard input, or input file
    private static String inputFile;	// input file, used instead of keyboard input if specified
    static ByteArrayOutputStream testOutputString;	// if test specified, holds all console output
    private static String myPackage;	// package of Critter file.  Critter cannot be in default pkg.
    private static boolean DEBUG = false; // Use it or not, as you wish!
    static PrintStream old = System.out;	// if you want to restore output to console


    // Gets the package name.  The usage assumes that Critter and its subclasses are all in the same package.
    static {
        myPackage = Critter.class.getPackage().toString().split(" ")[1];
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
	public static boolean validInput (String[] array){
		String[] valid={"make", "show", "step", "seed", "make", 
				"stats","Turtle","Tiger", "Lion", "Bear", "TestCritter",
				"Algae", "Craig"};
		boolean gotvalid=false;
		int num;
		for (String word:array){
			gotvalid=false;
			for (String v:valid){
				if(word.equals(v)){
					gotvalid=true;
					break;
				}else{
					try{
						num=Integer.parseInt(word);
						gotvalid=true;
					}catch(NumberFormatException e){
					}
				}
			}
			if(gotvalid==false){
				return false;
			}			
		}
		return true;
	}
	
    /**
     * Main method.
     * @param args args can be empty.  If not empty, provide two parameters -- the first is a file name, 
     * and the second is test (for test output, where all output to be directed to a String), or nothing.
     */
    public static void main(String[] args) { 
        if (args.length != 0) {
            try {
                inputFile = args[0];
                kb = new Scanner(new File(inputFile));			
            } catch (FileNotFoundException e) {
                System.out.println("USAGE: java Main OR java Main <input file> <test output>");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("USAGE: java Main OR java Main <input file>  <test output>");
            }
            if (args.length >= 2) {
                if (args[1].equals("test")) { // if the word "test" is the second argument to java
                    // Create a stream to hold the output
                    testOutputString = new ByteArrayOutputStream();
                    PrintStream ps = new PrintStream(testOutputString);
                    // Save the old System.out.
                    old = System.out;
                    // Tell Java to use the special stream; all console output will be redirected here from now
                    System.setOut(ps);
                }
            }
        } else { // if no arguments to main
            kb = new Scanner(System.in); // use keyboard and console
        }

        /* Do not alter the code above for your submission. */
        /* Write your code below. */
        String userinput;
        String[] inputArray; //holds inputs
        System.out.print("critters>");

        while(kb.hasNext()){
        	userinput= kb.nextLine();
        	
        //	inputArray=processInput(userinput, inputArray);
        	
        	userinput=userinput.trim();
        	inputArray=userinput.split("\\s+"); 
        	if(!validInput(inputArray)){
        		System.out.println("error processing: "+userinput);	//TODO change to include "error processing: "	
        		
        	}
        	
        	//check order? if needed
        	//check input and do stuff
        	implementInput(Array); 

            System.out.print("critters>");
        }
        /* Write your code above */
        System.out.flush();

    }
}
