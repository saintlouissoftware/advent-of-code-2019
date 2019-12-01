/*
part 1 equation:
fuel needed for each module = (round_down(mass/3))-2

part 2:
fuel also requires fuel

 */

package adventofcode2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1part2 {

	
	//this is the function from part 1
	//but part 2 requires additional stuff
	static int calc_fuel_1(int mass) {
		int fuel = 0;
		fuel = mass / 3;
		fuel -= 2;
		return fuel;	
	}
	
	//the fuel required for the mass of the fuel
	static int fuel_fuel(int mass) {
		int fuel_mass = calc_fuel_1(mass);
		int fuel = fuel_mass;
		while (fuel_mass >= 0) {
			if (calc_fuel_1(fuel_mass) > 0) {
				fuel += calc_fuel_1(fuel_mass);
			}
			fuel_mass = calc_fuel_1(fuel_mass);
		}
		return fuel;
	}
		
	public static void main(String[] args) throws FileNotFoundException{
		//here are the examples the website gives
		int test_cases[] = {14, 1969, 100756};
		
		//here are the answers my code is supposed to get
		int test_answers[] = {2, 966, 50346};
		
		//testing
		for (int i = 0; i < test_cases.length; i++) {
			System.out.print("mass of " + test_cases[i] + " requires: ");
			System.out.print(fuel_fuel(test_cases[i]));
			System.out.println(" fuel");
			if (fuel_fuel(test_cases[i]) == test_answers[i]) {
				System.out.println("Passed the test case!");
			} else {
				System.out.println("Failed the test case :(");
			}
		}
				
		//calculating total for new fuel formula
		//starting to open file
		int total = 0;

		Scanner fileIn;
        String filename = "input.txt";
        File someFile = new File(filename);
        if (someFile.exists()){
        	//file exists
            fileIn = new Scanner(someFile);
            while (fileIn.hasNext()) {
            	//getting lines from the file
                int module = fuel_fuel(fileIn.nextInt());
                total += module;
            }
        } else {
            System.out.println("no file called input.txt");
        }
        System.out.println("Total fuel needed: " + total);	
	}
}
