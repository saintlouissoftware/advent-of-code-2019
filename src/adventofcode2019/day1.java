//day 1, problem 1
//fuel needed for each module = (round_down(mass/3))-2
//input.txt has the module mass values, one on each line
//calculate them individually and then add them all up
//

package adventofcode2019;

import java.io.*;
import java.util.Scanner;


public class day1 {
	
	static int calc_fuel(int mass) {
		int fuel = 0;
		fuel = mass / 3;
		fuel -= 2;
		return fuel;	
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		//tests based on description of problem
		System.out.println(calc_fuel(12));
		System.out.println(calc_fuel(14));
		System.out.println(calc_fuel(1969));
		System.out.println(calc_fuel(100756));
		
		//the total amount of fuel needed
		int total = 0;
		
		//starting to open file
		Scanner fileIn;
        String filename = "input.txt";
        File someFile = new File(filename);
        if (someFile.exists()){
        	//file exists
            fileIn = new Scanner(someFile);
            while (fileIn.hasNext()) {
            	//getting lines from the file
                int module = calc_fuel(fileIn.nextInt());
                total += module;
            }
        } else {
            System.out.println("no file called input.txt");
        }
        System.out.println("Total fuel needed: " + total);

	}
}
