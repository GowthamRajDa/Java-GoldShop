package loginSignup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Registeration {

	public static List<User> Customers = new ArrayList<User>();
	public static List<User> Admins = new ArrayList<User>();
	public static Map<String, String> CustomerCredentials = new HashMap<>();
	public static Map<String, String> AdminCredentials = new HashMap<>();

	private static void setAdminCredentials(String username, String password) {
		AdminCredentials.put(username, password);
	}

	private static void setCustomerCredentials(String username, String password) {
		CustomerCredentials.put(username, password);
	}

	private static void createCustomerUser() {

		String name;
		String dob;
		String phone;
		String email;

		name = ScannerAndPrinters.getName();

		while (true) {

			dob = ScannerAndPrinters.getDOB(name);
			if (Validations.validateDOB(dob)) {
				break;
			} else {
				System.out.println("\nInvalid Date of Birth");
			}
		}

		while (true) {

			phone = ScannerAndPrinters.getPhone();
			if (Validations.validatePhone(phone)) {
				break;
			} else {
				System.out.println("\nInvalid phone Number");
			}
		}

		while (true) {
			email = ScannerAndPrinters.getEmail();
			if (Validations.validateMail(email)) {
				break;
			} else {
				System.out.println("Invalid mail ID");
			}
		}

		User customeUser = new User(name, dob, phone, email);
		customeUser.setRole("CUSTOMER");
		Customers.add(customeUser);
		setCustomerCredentials(customeUser.getUsername(), getPassword());

		ScannerAndPrinters.registeredGreet();
		Actions.mainOptions();
	}

	private static void createAdminUser() {

		String name;
		String dob;
		String phone;
		String email;

		name = ScannerAndPrinters.getName();

		while (true) {

			dob = ScannerAndPrinters.getDOB(name);
			if (Validations.validateDOB(dob)) {
				break;
			} else {
				System.out.println("\nInvalid Date of Birth");
			}
		}

		while (true) {
			phone = ScannerAndPrinters.getPhone();
			if (Validations.validatePhone(phone)) {
				break;
			} else {
				System.out.println("\nInvalid phone Number");
			}
		}

		while (true) {
			email = ScannerAndPrinters.getEmail();
			if (Validations.validateMail(email)) {
				break;
			} else {
				System.out.println("Invalid mail ID");
			}
		}

		User adminUser = new User(name, dob, phone, email);
		adminUser.setRole("ADMIN");
		Admins.add(adminUser);
		setAdminCredentials(adminUser.getUsername(), getPassword());
		ScannerAndPrinters.registeredGreet();
		Actions.mainOptions();
	}

	public static String getPassword() {
		while (true) {
			System.out.println("*****New Password*****");
			String pass1 = ScannerAndPrinters.getNewPassword();
			System.out.println("*****Confirm Password*****");
			String pass2 = ScannerAndPrinters.getNewPassword();
			if (pass1.equals(pass2)) {
				return pass1;
			} else {
				System.out.println("\nPassword Not Matching!! Please try again");
			}
		}
	}

	public static void createCustomerUser(String name, String dob, String phone, String email) {
		User customeUser = new User(name, dob, phone, email);
		customeUser.setRole("CUSTOMER");
		Customers.add(customeUser);
		setCustomerCredentials(customeUser.getUsername(), customeUser.getPhone());
		ScannerAndPrinters.registeredGreet();
	}

	public static void createAdminUser(String name, String dob, String phone, String email) {
		User adminUser = new User(name, dob, phone, email);
		adminUser.setRole("ADMIN");
		Admins.add(adminUser);
		setAdminCredentials(adminUser.getUsername(), adminUser.getPhone());
		ScannerAndPrinters.registeredGreet();
	}

	public static void createUser() {
		System.out.println("**********CREATE USER*********");
		int response = ScannerAndPrinters.getUserCreationOptions();
		if (response == 1) {
			createAdminUser();
		} else if (response == 2) {
			createCustomerUser();
		} else if (response == 3) {
			Actions.mainOptions();
		} else {
			ScannerAndPrinters.ExitGreet();
		}
	}

	public static void editNameofUser(String role, String username) {
		if (role.equalsIgnoreCase("ADMIN")) {
			for (User admin : Admins) {
				if (admin.getUsername().equalsIgnoreCase(username)) {
					admin.setName(ScannerAndPrinters.getName());
					System.out.println(admin.getName() + " updated.");
					Actions.adminActions();
				}
			}

		} else if (role.equalsIgnoreCase("CUSTOMER")) {
			for (User customer : Customers) {
				if (customer.getUsername().equalsIgnoreCase(username)) {
					customer.setName(ScannerAndPrinters.getName());
					System.out.println(customer.getName() + " updated.");
					Actions.customerActions();
				}
			}
		}
	}

	public static void editDOBofUser(String role, String username) {
		if (role.equalsIgnoreCase("ADMIN")) {
			for (User admin : Admins) {
				if (admin.getUsername().equalsIgnoreCase(username)) {
					admin.setDob(ScannerAndPrinters.getDOB(username));
					System.out.println(admin.getDob() + " updated.");
					Actions.adminActions();
				}
			}

		} else if (role.equalsIgnoreCase("CUSTOMER")) {
			for (User customer : Customers) {
				if (customer.getUsername().equalsIgnoreCase(username)) {
					customer.setDob(ScannerAndPrinters.getDOB(username));
					System.out.println(customer.getDob() + " updated.");
					Actions.customerActions();
				}
			}
		}
	}

	public static void editemailUser(String role, String username) {
		if (role.equalsIgnoreCase("ADMIN")) {
			for (User admin : Admins) {
				if (admin.getUsername().equalsIgnoreCase(username)) {
					admin.setEmail(ScannerAndPrinters.getEmail());
					System.out.println(admin.getEmail() + " updated.");
					Actions.adminActions();
				}
			}

		} else if (role.equalsIgnoreCase("CUSTOMER")) {
			for (User customer : Customers) {
				if (customer.getUsername().equalsIgnoreCase(username)) {
					customer.setEmail(ScannerAndPrinters.getEmail());
					System.out.println(customer.getEmail() + " updated.");
					Actions.customerActions();
				}
			}
		}
	}

	public static void editphone(String role, String username) {
		if (role.equalsIgnoreCase("ADMIN")) {
			for (User admin : Admins) {
				if (admin.getUsername().equalsIgnoreCase(username)) {
					admin.setPhone(ScannerAndPrinters.getPhone());
					System.out.println(admin.getPhone() + " updated.");
					Actions.adminActions();
				}
			}

		} else if (role.equalsIgnoreCase("CUSTOMER")) {
			for (User customer : Customers) {
				if (customer.getUsername().equalsIgnoreCase(username)) {
					customer.setPhone(ScannerAndPrinters.getPhone());
					System.out.println(customer.getPhone() + " updated.");
					Actions.customerActions();
				}
			}
		}
	}

	public static void editPassword(String role, String username) {
		if (role.equalsIgnoreCase("ADMIN")) {
			if (AdminCredentials.containsKey(username))
				AdminCredentials.put(username, getPassword());
			System.out.println("Password Updated");
			Actions.adminActions();
		} else if (role.equalsIgnoreCase("CUSTOMER")) {
			if (CustomerCredentials.containsKey(username))
				CustomerCredentials.put(username, getPassword());
			System.out.println("Password Updated");
			Actions.customerActions();
		}
	}

	public static String checkLogin(String username, String password) {
		if (password.equalsIgnoreCase(CustomerCredentials.get(username))) {
			return "CUSTOMER";
		} else if (password.equalsIgnoreCase(AdminCredentials.get(username))) {
			return "ADMIN";
		} else {
			return null;
		}
	}

	public static void showAdmins() {
		int i = 1;
		for (User admin : Admins) {
			System.out.println(i + ". \n" + admin);
			i++;
		}
		Actions.adminActions();
	}

	public static void showCustomers() {
		int i = 1;
		for (User customer : Customers) {
			System.out.println(i + ". \n" + customer);
			i++;
		}
		Actions.adminActions();
	}
}
