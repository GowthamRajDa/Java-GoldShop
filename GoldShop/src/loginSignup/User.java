package loginSignup;

import loginSignup.Enums.UserRole;

public class User {

	private String name;		//<String> ex:user
	private String dob;			// date as dd/mm/yyyy ex: 21/10/1998
	private String phone;		// any 10 digits int
	private String email;		// <string>@<string>.<string>	
	private String username;	// <name>+<ddmm> ex: user2110
	private UserRole userRole;

	public User(String name, String dob, String phone, String email) {
		this.name = name;
		
		if (Validations.validateDOB(dob)) {
			this.dob = dob;
		} else {
			System.out.println("\nInvalid Date of Birth");
		}
		
		if (Validations.validatePhone(phone)) {
			this.phone = phone;
		} else {
			System.out.println("\nInvalid phone Number");
		}
		
		if (Validations.validateMail(email)) {
			this.email = email;
		} else {
			System.out.println("Invalid mail ID");
		}
		
		this.setUsername();

	}

	public User(User Source) {
		this.dob = Source.dob;
		this.email = Source.email;
		this.name = Source.name;
		this.phone = Source.phone;
		this.setUsername();
	}

	public UserRole getRole() {
		return userRole;
	}

	public String getName() {
		return name;
	}

	public String getDob() {
		return dob;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setDob(String dob) {
		if (Validations.validateDOB(dob)) {
			this.dob = dob;
			setUsername();
		} else {
			System.out.println("\nInvalid Date of Birth");
		}
	}

	public void setName(String name) {
		this.name = name;
		setUsername();
	}

	public void setEmail(String email) {
		if (Validations.validateMail(email)) {
			this.email = email;
		} else {
			System.out.println("Invalid mail ID");
		}
	}

	public void setPhone(String phone) {
		if (Validations.validatePhone(phone)) {
			this.phone = phone;
		} else {
			System.out.println("\nInvalid phone Number");
		}
	}

	public void setRole(String role) {
		userRole = UserRole.valueOf(role);
	}

	private void setUsername() {
		this.username = this.name + this.dob.charAt(0) + this.dob.charAt(1) + this.dob.charAt(3) + this.dob.charAt(4);
	}
	
	@Override
	public String toString() {
		return "Username: " + this.username + "\nName: " + this.name + "\nDOB: " + this.dob + "\nPhone: " + this.phone
				+ "\nEmail: " + this.email + "\nRole: " + this.userRole;

	}

}
