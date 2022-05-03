package loginSignup;

import java.util.Scanner;

import products.Jewellery;

public abstract class ScannerAndPrinters {
	static Scanner scan = new Scanner(System.in);

	private static int getInt() {
		int response = scan.nextInt();
		scan.nextLine();
		return response;
	}

	private static double getDouble() {
		double response = scan.nextDouble();
		scan.nextLine();
		return response;
	}

	private static String getLine() {
		String response = scan.nextLine();
		return response;
	}

	public static void welcomegreet() {
		System.out.println(
				"\n******************************************\nWelcome to JAVA Jewellery Shop\n******************************************");
	}

	public static void ExitGreet() {
		System.out.println("\n************Closing Application***************\nThank you came again");
		System.exit(0);
	}

	public static void registeredGreet() {
		System.out.println("\nCongrats, you completed your registeration.\nUser created");
	}

	public static void passwordLimitReached() {
		System.out.println("\nMax limit reached Please try again later");
	}

	public static void wrongPassword() {
		System.out.println("!!WRONG PASSWORD Try Again!!");
	}

	public static int getMainOptions() {

		System.out.println(
				"\n****************************HOME PAGE****************************\nPlease Select your Option :\n1.Login\n2.SignUp\n3.Exit");
		return getInt();
	}

	public static int getAdminActions() {
		System.out.println(
				"\n****************************ADMIN HOME PAGE****************************\nPlease Select the Action below to perform\n1.Add product to Store\n2.Remove product"
						+ "\n3.Edit Product\n4.View All Admin users\n5.View All Customer users\n6.User Options\n7.Logout\n8.Exit");
		return getInt();
	}

	public static int getCustomerActions() {
		System.out.println(
				"\n****************************CUSTOMER HOME PAGE****************************\nPlease Select the Action below to perform\n1.View All Products\n2.View Products by Category"
						+ "\n3.View Products by Materials\n4.View Cart\n5.User Options\n6.Logout\n7.Exit");
		return getInt();

	}

	public static int cartActions() {
		System.out.println("\n*****CART ACTIONS*****"
				+ "\nPlease select the actions to Perform : \n1.Buy All products in Cart\n2.Remove All Product from Cart\n3.Back to Purchase");
		return getInt();
	}

	public static int userActions() {
		System.out.println("\n*****USER ACTIONS*****"
				+ "\nPlease select the actions to Perform : \n1.Change Name\n2.Change PhoneNumber\n3.Change Email ID\n4.Change Date of Birth\n5.Change Password\n6.Back");
		return getInt();
	}

	public static String addToCartResponse() {
		System.out.println("\nShall I add this to Cart?(yes/no)");
		return getLine();
	}

	public static String likeToBuy() {
		System.out.println("\nDo you like to buy any of this jewel?");
		return getLine();
	}

	public static int getProductInt() {
		System.out.print("\nPease select the Product : ");
		return getInt();
	}

	public static int getUserCreationOptions() {
		System.out.println(
				"\n****************************USER CREATION PAGE****************************\nPlease Select the type of user you want to create :"
						+ "\n1.Admin\n2.Customer\n3.Back\n4.Exit");
		return getInt();
	}

	public static String getUserName() {
		System.out.println(
				"\n****************************LOGIN PAGE****************************\n\nPlease enter your Username: ");
		String username = getLine();
		return username;
	}

	public static String getNewPassword() {
		String password;
		while (true) {
			System.out.println("\nPlease enter your Password: ");
			password = getLine();
			if (Validations.validatePassword(password)) {
				break;
			} else {
				System.out.println("Please Enter a valid password with following conditions:\n"
						+ "It contains at least 8 characters and at most 20 characters.\r\n"
						+ "It contains at least one digit.\r\n" + "It contains at least one upper case alphabet.\r\n"
						+ "It contains at least one lower case alphabet.\r\n"
						+ "It contains at least one special character which includes !@#$%&*()-+=^.\r\n"
						+ "It doesn’t contain any white space.");
			}
		}
		return password;
	}

	public static String getPassword() {
		System.out.println("\nPlease enter your Password: ");
		String password = getLine();
		return password;
	}

	public static String getProductCata() {

		System.out.println("\nPlease enter the Product Catagory :");
		String response = getLine();
		return response;
	}

	public static String getProductMaterial() {
		while (true) {
			System.out.println("\nPlease enter the Jewel Material");
			String material = getLine();
			if (Jewellery.isMaterial(material)) {
				return material;
			} else if (material.equalsIgnoreCase("exit")) {
				ScannerAndPrinters.ExitGreet();
			} else {
				System.out.println("There is no material found with name :'" + material + "'");
			}
		}

	}

	public static String getProductName() {
		System.out.println("\nPlease enter the Jewel Name :");
		String response = getLine();
		return response;
	}

	public static double getPrice() {
		System.out.println("\nPlease enter the Jewel Price :");
		double response = getDouble();
		return response;
	}

	public static String getName() {
		System.out.println("\nPlease Enter your name: ");
		String name = getLine();
		return name;
	}

	public static String getDOB(String name) {
		String dob;
		while (true) {
			System.out.println("\nHi, " + name + ". Please Enter your Date of birth (DD/YY/MM format): ");
			dob = getLine();
			if (Validations.validateDOB(dob)) {
				break;
			} else {
				System.out.println("\nInvalid Date of Birth");
			}
		}
		return dob;

	}

	public static String getPhone() {
		String phone;
		while (true) {
			System.out.println("\nPlease Enter your Phone Number(10):");
			phone = scan.nextLine();
			if (Validations.validatePhone(phone)) {
				break;
			} else {
				System.out.println("\nInvalid phone Number");
			}
		}
		return phone;
	}

	public static String getEmail() {
		String email;
		while (true) {
			System.out.println("\nPlease Enter your Email ID: ");
			email = scan.nextLine();
			if (Validations.validateMail(email)) {
				break;
			} else {
				System.out.println("\nInvalid mail ID");
			}
		}
		return email;
	}
}
