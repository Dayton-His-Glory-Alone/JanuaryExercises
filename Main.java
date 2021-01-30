import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 
 */

/**
 * Dine-O-Matic
 * 
 * @author Rumbold Family
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Dine-O-Matic experience!");
		Restaurants rest = new Restaurants("names.csv");
		rest.fill();
		String choice = null;
		int input = 0;

		while (input != 4) {
			menu();
			choice = scan.nextLine();
			input = Integer.parseInt(choice);
			if (input == 1) {
				System.out.println("Please enter the name of the restaurant you would like to add:");
				String name= scan.nextLine();
				rest.addRest(name);
			} else if (input == 2) {
				//random restaurant
				rest.randomPicker();

			} else if (input == 3) {
				rest.allRestuarants();
			}
			else if(input==4) {
				System.out.println("Thank you for choosing Dine-O-Matic");
				
				System.out.print("----");
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.print("----");
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
				System.exit(0);
			}
				else {
				System.out.println("Invalid input. Please choose a number 1-4");
			}
		}
	}

	public static void menu() {
		System.out.println(
				"\nWould you like to...\n1)add a new Restaurant\n2)or choose a restaurant\n3)or list all the restaurants\n4)or exit Dine-O-matic?");

	}

}
