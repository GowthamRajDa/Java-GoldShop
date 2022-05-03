package loginSignup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import products.Sales;

public abstract class Loader {

	public static void userLoader(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner scnObj = new Scanner(file);
		while (scnObj.hasNextLine()) {
			String[] userarray = scnObj.nextLine().split(",");
			if (userarray[0].equalsIgnoreCase("admin")) {
				Registeration.createAdminUser(userarray[1], userarray[2], userarray[3], userarray[4]);
			} else if (userarray[0].equalsIgnoreCase("Customer")) {
				Registeration.createCustomerUser(userarray[1], userarray[2], userarray[3], userarray[4]);
			} else {
				System.out.println("Error on parsing file, Please check the strings on file");
			}
		}
		scnObj.close();
	}

	public static void jewelLoader(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		Scanner scnObj = new Scanner(file);
		while (scnObj.hasNextLine()) {
			String[] jewelarray = scnObj.nextLine().split(",");
			Sales.addJewelToStore(jewelarray[0], jewelarray[1], jewelarray[2], Double.parseDouble(jewelarray[3]));
		}
		scnObj.close();
	}
}
