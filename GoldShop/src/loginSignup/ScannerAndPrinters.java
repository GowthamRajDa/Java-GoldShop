package loginSignup;

import java.util.Scanner;

import products.Jewellery;

public abstract class ScannerAndPrinters {

	public static void Welcomegreet() {
		System.out.println("Welcome to JAVA Jewellery Shop");
	}

	public static void ExitGreet() {
		System.out.println("Thank you came again");
		System.exit(0);
	}

	public static void RegisteredGreet() {
		System.out.println("Congrats, you completed your registeration.Username created");
	}

	public static void PasswordLimitReached() {
		System.out.println("Max limit reached Please try again later");
	}

	public static void WrongPassword() {
		System.out.println("!!WRONG PASSWORD Try Again!!");
	}

	private static int GetInt() {
		Scanner scan = new Scanner(System.in);
		int response = scan.nextInt();
		scan.close();
		return response;
	}

	private static String GetLine() {
		Scanner scan = new Scanner(System.in);
		String response = scan.nextLine();
		scan.close();
		return response;
	}

	public static int GetMainOptions() {

		System.out.println("Please Select your Option :\n1.Login\n2.SignUp\n3.Exit");
		return GetInt();
	}

	public static int GetUserCreationOptions() {
		System.out.println("Please Select the type of user you want to create :\n1.Admin\n2.Customer\n3.Back\n4.Exit");
		return GetInt();
	}

	public static String getUserName() {
		System.out.println("Please enter your Username: \n");
		return GetLine();
	}

	public static String getPassword() {
		System.out.println("Please enter your Password: \n");
		return GetLine();
	}

	public static int getAdminActions() {
		System.out.println(
				"Hi admin, Please Select the Action below to perform\n1.Add product to Store\n2.Remove product"
						+ "\n3.Edit Product\n4.Back\n5.Exit");
		return GetInt();
	}
	
	public static int getCustomerActions() {
		System.out.println(
				"Hi Customer, Please Select the Action below to perform\n1.View All Products\n2.View Products by Category"
						+ "\n3.View Products by Materials\n4.Back\n5.Exit");
		return GetInt();
		
	}

	public static String getProductCata() {
//		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the Product Catagory :");
//		String response = scan.nextLine();
//		scan.close();
//		return response;
		return GetLine();
	}

	public static String getProductMaterial() {
		while (true) {
			System.out.println("Please enter the Jewel Material");
			String material = GetLine();
			if (Jewellery.isMaterial(material)) {
				return material;
			} else if (material.equalsIgnoreCase("exit")) {
				ScannerAndPrinters.ExitGreet();
			} else {
				System.out.println("There is no material found with name :'" + material + "'");
			}
		}

	}

	public static String likeToBuy() {
		System.out.println("Do you like to buy any of this jewel?");
		return GetLine();
	}

	public static int getProductInt() {
		System.out.print("Pease enter the Product number : ");
		return GetInt();
	}

}
