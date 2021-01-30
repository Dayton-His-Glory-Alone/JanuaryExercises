import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Restaurants {
	
	public RestDetails[] list;
	public int count = 0;
	public String filename;
	private int SIZE= 1000;
	public Restaurants(String filename) {
		list = new RestDetails[SIZE];
		this.filename = filename;
	}

	public void fill() {
		File file = new File(filename);

		try {
			Scanner scan = new Scanner(file);
			int i = 0;
			RestDetails rd= null;
			scan.nextLine();
			// remove the first blank lines
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] items = line.split(",");
				rd= new RestDetails(items[0],items[1],items[2]);
				list[count]=rd;
				count++;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("reading file '" + file + "' failed");
			e.printStackTrace();
		}
	}

	/**
	 * Add one new restaurant
	 * 
	 * @param rest
	 */
	public void addRest(String name) {
		File file = new File(filename);
		RestDetails rd;
		try {
			Scanner scan = new Scanner(System.in);
	
			 PrintWriter pw = new PrintWriter(new FileOutputStream(
					    new File(filename), 
					    true /* append = true */));
			pw.write(""+name + ",");
			System.out.println("1)$\n2)$$\n3)$$$");
			System.out.println("Enter the price of the restaurant:");
			String price = scan.nextLine();
			pw.write(price + ",");
			System.out.println("1)American\n2)Mexican\n3)Italian\n4)Chinese\n5)Mediterranean\n6)ALL");
			System.out.println("Enter the category of the restaurant:");
			String category = scan.nextLine();
			pw.write(category + ",/r/n");
			rd= new RestDetails(name,price,category);
			list[count]=rd;
			count++;
			pw.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

	public void allRestuarants() {
		for (int i = 0; i < count; i++) {
			System.out.println(list[i].name);
		}
	}
	/**
	 * Picks a random restaurant based on preferences...
	 * FIX: logic of choosing restaurant for all
	 */
	public void randomPicker() {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		String price = null;
		String category = null;
		System.out.println("1($) 2($$) 3($$$) 4(ALL)");
		price = scan.nextLine();
		System.out.print("1(Americano)\n2(South of the Border)\n3(Mama mia)\n4(Chinese)\n5(Mediterranean)\n6(ALL)");
		category = scan.nextLine();
		String[] picker = new String[SIZE];

		int pickerCount = 0;
		boolean flag= true;
		for (int i = 0; i < count; i++) {
			int p = Integer.parseInt(price);
			int c = Integer.parseInt(category);
			if ((list[i].price.equals(price) || price.equals("4"))
					&& (list[i].category.equals("6") || category.equals(category))) {
				picker[pickerCount] = list[i].getName();
				pickerCount++;
			}
		}
		if(pickerCount==0) {
			System.out.println("\n\n\nNo restaurants available with your preferences... please try again.\n\n\n");
		}
		else {
		int randomNumber= rand.nextInt(pickerCount-0) + 0;
		System.out.println("Your restaurant is...");
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Drum roll please...");
			TimeUnit.SECONDS.sleep(1);
			System.out.print("----");
			TimeUnit.SECONDS.sleep(1);
			System.out.print("----");
			System.out.println(picker[randomNumber] + "!!!\n\n\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
}
