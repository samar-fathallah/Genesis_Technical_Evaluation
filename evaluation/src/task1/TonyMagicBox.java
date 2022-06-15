package task1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class TonyMagicBox {
	
	//Method to check if arraylist is sorted descendingly
   public static boolean isSortedDescendingly(ArrayList<Integer> a)
   {
	    // base case
       if (a == null || a.size() <= 1) {
           return true;
       }
	   for (int i = 0; i <a.size()-1; i++) {
		    if (a.get(i) < a.get(i+1)) {
		        return false;
		    }
		}
		return true;
   }
   //Method to figure out the type of data structure the box uses 
	public static String DetectDataStructure(int numberOfOperations,ArrayList<String> operations) 
	{
		String result="";
		ArrayList<Integer> insertedBills = new ArrayList<Integer>();
		ArrayList<Integer> expeledBills = new ArrayList<Integer>();
		for(int i=0;i<operations.size();i++) {
			String current=operations.get(i);
			//Detect type of operation to add into corresponding arraylist
			if(current.charAt(0)=='1') {
				int bill=Integer.parseInt(current.substring(2));
				insertedBills.add(bill);
			}
			if(current.charAt(0)=='2') {
				int bill=Integer.parseInt(current.substring(2));
				expeledBills.add(bill);
			}
		}
		//Check if both the expeled & inserted bills contain the same elements in any order
		if(!new HashSet<Integer>(insertedBills).equals(new HashSet<Integer>(expeledBills))) {
			return "!";
		}
		//Check if data structure is stack
		int firstExpeled=expeledBills.get(0);
		int lastInserted=insertedBills.get(insertedBills.size()-1);
		if(firstExpeled==lastInserted) {
			result+="s";
		}
		//Check if data structure is queue
		int firstInserted=insertedBills.get(0);
		if(firstInserted==firstExpeled) {
			result+="q";
		}
		//Check if data structure is priority queue
		if(isSortedDescendingly(expeledBills)) {
			result+="p";
		}
		//Check if  more than one data structure is possible
		if(result.length()>1) {
			result="?";
		}
		// Check if type can't be determined or invalid operation
		if(result.isEmpty()) {
			result="!";
		}
		return result;
	
	}
	
	public static void main(String[] args) 
	{
		//Attributes to be used
		Scanner scanner = new Scanner(System.in);
		String output="";
		int numberOfOperations=0;
		ArrayList<String> operations = new ArrayList<String>();
	
		//Program Start
		System.out.println("Hello Tony, Let's Play!!");
		System.out.println("Please enter number of operations to start");
		while(true) {
			//Keep reading input till user enters an empty line
			String input =scanner.nextLine();
			if(input=="") {
				break;
			}
				//Break the program if the number of operations is greater than 500 or less than 0
				if(Integer.parseInt(input)>500) {
					System.out.println("Sorry, operations must be less than 500, Please enter a value less than 500");
					break;
				}
				if(Integer.parseInt(input)<0) {
					System.out.println("Sorry, operations must be more than 0, Please enter a value greater than 0");
					break;

				}
				//The program now is ready to start
				numberOfOperations=Integer.parseInt(input);
				for (int i=0;i<numberOfOperations;i++) {
					String inputOperation =scanner.nextLine();
					//the program will keep receiving input till exceeding the number of operations defined by the user
					int bill=Integer.parseInt(inputOperation.substring(2));
					//Check for valid bills & reject the invalid ones
					if(bill==1 || bill==5 || bill==10 || bill==20 || bill==50 || bill==100) {
						operations.add(inputOperation);
					}
					else {
						numberOfOperations--;
					}
				}
				//Starting the necessarily checks
				String currentOutput=DetectDataStructure(numberOfOperations,operations);
				output+=currentOutput+" ";
				//Empty all variables to be ready to read input again
				numberOfOperations=0;
				operations = new ArrayList<String>();
			} 
		//Print Output
		for (char c: output.toCharArray()) {
			if(c !=' ') {
				System.out.println(c);
			}
		}
		//Write output to a txt file saved in the same location as TonyMagicBox.java
		File myObj = new File("Results.txt");
		try {
		      FileWriter myWriter = new FileWriter("Results.txt");
		      myWriter.write(output);
		      myWriter.close();
		    } 
		catch (IOException e) {
		      e.printStackTrace();
		    }
		  }
		
		}
	

