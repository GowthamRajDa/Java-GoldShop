package loginSignup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class Registeration {

	public static List<User> Customers = new ArrayList<User>();
	public static List<User> Admins = new ArrayList<User>();
	public static Map<String, String> CustomerCredentials = new HashMap<>();
	public static Map<String, String> AdminCredentials = new HashMap<>();

	private static void setCustomerCredentials(String username, String password) {
		CustomerCredentials.put(username, password);
	}

	private static void setAdminCredentials(String username, String password) {
		AdminCredentials.put(username, password);
	}
	
	public static void createUser() {
		int response=ScannerAndPrinters.GetUserCreationOptions();
		if(response==1) {
			createAdminUser();
		}else if(response==2) {
			createCustomerUser();
		}else if(response==3) {
			Login.MainOptions();
		}else {
			ScannerAndPrinters.ExitGreet();
		}
	}

	public static void createCustomerUser() {

		String name;
		String dob;
		String phone;
		String email;

		Scanner scnObj = new Scanner(System.in);
		System.out.println("Please Enter your name: \n");
		name = scnObj.nextLine();

		while (true) {
			System.out.println("Hi, " + name + ". Please Enter your Date of birth (DD/YY/MM format): \n");
			dob = scnObj.nextLine();
			if (Validations.validateDOB(dob)) {
				break;
			} else {
				System.out.println("\nInvalid Date of Birth");
			}
		}

		while (true) {
			System.out.println("Please Enter your Phone Number(10): \n");
			phone = scnObj.nextLine();
			if (Validations.validatePhone(phone)) {
				break;
			} else {
				System.out.println("\nInvalid phone Number");
			}
		}

		while (true) {
			System.out.println("Please Enter your Email ID: \n");
			email = scnObj.nextLine();
			if (Validations.validateMail(email)) {
				break;
			} else {
				System.out.println("Invalid mail ID");
			}
		}

		scnObj.close();

		User customeUser = new User(name, dob, phone, email);
		customeUser.setRole("CUSTOMER");
		Customers.add(customeUser);
		setCustomerCredentials(customeUser.getUsername(), customeUser.getPhone());

		ScannerAndPrinters.RegisteredGreet();
	}

	public static void createCustomerUser(String name, String dob, String phone, String email) {
		User customeUser = new User(name, dob, phone, email);
		customeUser.setRole("CUSTOMER");
		Customers.add(customeUser);
		setCustomerCredentials(customeUser.getUsername(), customeUser.getPhone());
	}

	public static void createAdminUser(String name, String dob, String phone, String email) {
		User adminUser = new User(name, dob, phone, email);
		adminUser.setRole("ADMIN");
		Admins.add(adminUser);
		setAdminCredentials(adminUser.getUsername(), adminUser.getPhone());
	}

	public static void createAdminUser() {

		String name;
		String dob;
		String phone;
		String email;

		Scanner scnObj = new Scanner(System.in);
		System.out.println("Please Enter your name: \n");
		name = scnObj.nextLine();

		while (true) {
			System.out.println("Hi, " + name + ". Please Enter your Date of birth (DD/YY/MM format): \n");
			dob = scnObj.nextLine();
			if (Validations.validateDOB(dob)) {
				break;
			} else {
				System.out.println("\nInvalid Date of Birth");
			}
		}

		while (true) {
			System.out.println("Please Enter your Phone Number(10): \n");
			phone = scnObj.nextLine();
			if (Validations.validatePhone(phone)) {
				break;
			} else {
				System.out.println("\nInvalid phone Number");
			}
		}

		while (true) {
			System.out.println("Please Enter your Email ID: \n");
			email = scnObj.nextLine();
			if (Validations.validateMail(email)) {
				break;
			} else {
				System.out.println("Invalid mail ID");
			}
		}

		scnObj.close();
		User adminUser = new User(name, dob, phone, email);
		adminUser.setRole("ADMIN");
		Admins.add(adminUser);
		setAdminCredentials(adminUser.getUsername(), adminUser.getPhone());
		ScannerAndPrinters.RegisteredGreet();
	}

	public static String CheckLogin(String username, String password) {
		if (password.equalsIgnoreCase(CustomerCredentials.get(username))) {
			return "CUSTOMER";
		} else if (password.equalsIgnoreCase(AdminCredentials.get(username))) {
			return "ADMIN";
		} else {
			return null;
		}
	}
}
