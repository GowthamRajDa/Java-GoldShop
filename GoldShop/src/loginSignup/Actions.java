package loginSignup;

import products.Jewellery;
import products.Sales;

public abstract class Actions {

	private static void getRoleLogin() {
		String Role = Login.loginUser();
		if (Role.equalsIgnoreCase("ADMIN")) {
			adminActions();
		} else if (Role.equalsIgnoreCase("CUSTOMER")) {
			customerActions();
		}
	}

	private static void productActions(Jewellery jewel) {
		System.out.println("\n*****Good Choice*****\nSelected Product :");
		System.out.println(jewel);
		String response = ScannerAndPrinters.addToCartResponse();
		if (response.equalsIgnoreCase("yes")) {
			Sales.addToCart(jewel);
			System.out.println(jewel.getJewelName() + " added to Cart");
			customerActions();
		} else {
			customerActions();
		}
	}

	private static void cartActions() {
		Sales.showCart();
		int response = ScannerAndPrinters.cartActions();
		// 1.Buy All products in Cart 2.Remove All Product from Cart 3.Back to Purchase
		if (response == 1) {
			Sales.buyAllProductCart();
		} else if (response == 2) {
			System.out.println("*****Removing All Products from Cart*****");
			Sales.removeAllProductFromCart();
			Actions.customerActions();
		} else {
			customerActions();
		}
	}

	private static void editProduct() {
		System.out.println("\nDevelopment in progress!! \nPlease come again later");
		adminActions();
	}

	private static void removeProductfromstore() {
		Sales.showAllProducts();
		String jewelname = Sales.removeProductFromStore(Sales.selectProduct());
		System.out.println(jewelname + " removed from the Store.");
		adminActions();
	}

	public static void mainOptions() {

		int mainResponse = ScannerAndPrinters.getMainOptions();
		if (mainResponse == 1) {
			getRoleLogin();
		} else if (mainResponse == 2) {
			Registeration.createUser();
		} else {
			ScannerAndPrinters.ExitGreet();
		}

	}

	public static void adminActions() {
		int response = ScannerAndPrinters.getAdminActions();
		// 1.Add product to Store 2.Remove product 3.Edit Product 4.view admin users
		// 5.View customers 6.UserOptions 7.Logout 8.Exit
		if (response == 1) {
			System.out.println("\n*****Adding jewels to Store*****");
			Sales.addJewelToStore();
		} else if (response == 2) {
			System.out.println("\n*****Removing jewels to Store*****");
			removeProductfromstore();
		} else if (response == 3) {
			System.out.println("\n*****Editing jewels on Store*****");
			editProduct();
		} else if (response == 4) {
			System.out.println("\n*****ADMIN USERS*****");
			Registeration.showAdmins();
		} else if (response == 5) {
			System.out.println("\n*****CUSTOMER USERS*****");
			Registeration.showCustomers();
		} else if (response == 6) {
			editUser();
		} else if (response == 7) {
			System.out.println("\n*****Logging out*****");
			mainOptions();
		} else {
			ScannerAndPrinters.ExitGreet();
		}

	}

	public static void customerActions() {
		int response = ScannerAndPrinters.getCustomerActions();
		// 1.View All Products 2.View Products by Category 3.View Products by Materials
		// 4.View Cart 5.User Options
		// 6.logout 7.Exit"
		if (response == 1) {
			System.out.println("\n*****Showing All Jewels*****");
			Sales.showAllProducts();
			productActions(Sales.selectProduct());
		} else if (response == 2) {
			Sales.showJewelsByCata();
			System.out.println("\n*****Showing Jewels by Category*****");
			productActions(Sales.selectProduct());
		} else if (response == 3) {
			System.out.println("\n*****Showing Jewels by Materials*****");
			Sales.showJewelsBymaterial();
			productActions(Sales.selectProduct());
		} else if (response == 4) {
			System.out.println("\n*****Showing Cart*****");
			cartActions();
		} else if (response == 5) {
			editUser();
		} else if (response == 6) {
			System.out.println("\n*****Logging out*****");
			mainOptions();
		} else {
			ScannerAndPrinters.ExitGreet();
		}
	}

	public static void editUser() {
		String username = Login.getLoggedInUser();
		String role;
		System.out.println("\nPlease, Confirm your Identity");
		while (true) {
			role = Registeration.checkLogin(username, ScannerAndPrinters.getPassword());
			if (role!=null) {
				break;
			}else {
				System.out.println("Wrong password !! Please Try again");
			}
		}

		int response = ScannerAndPrinters.userActions();
		// 1.Change Name 2.Change PhoneNumber 3.Change Email ID 4.Change Date of Birth
		// 5.Change Password 6.Back
		if (response == 1) {
			System.out.println("\n*****Name Change*****");
			Registeration.editNameofUser(role, username);
		} else if (response == 2) {
			System.out.println("\n*****Phone Number Change*****");
			Registeration.editphone(role, username);
		} else if (response == 3) {
			System.out.println("\n*****Email Change*****");
			Registeration.editemailUser(role, username);
		} else if (response == 4) {
			System.out.println("\n*****Date Birth Change*****");
			Registeration.editDOBofUser(role, username);
		} else if (response == 5) {
			System.out.println("\n*****Password Change*****");
			Registeration.editPassword(role, username);
		} else if (response == 6) {
			customerActions();
		} else {
			ScannerAndPrinters.ExitGreet();
		}

	}

}
