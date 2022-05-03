package loginSignup;

public abstract class Validations {

	static private String regDOB = "^[0-3][0-9]/[0-3][0-9]/(?:[0-9][0-9])?[0-9][0-9]$";
	static private String regmail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	static private String regPhone = "^[0-9]{10}$";
	static private String regPass = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";

	public static Boolean validateDOB(String dob) {
		if (dob.matches(regDOB)) {
			return true;
		} else {
			return false;
		}
			
	}

	public static boolean validatePhone(String phone) {
		if (phone.matches(regPhone)) {
			return true;
		} else {
			return false;

		}
	}

	public static boolean validateMail(String email) {
		if (email.matches(regmail)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validatePassword(String email) {
		if (email.matches(regPass)) {
			return true;
		} else {
			return false;
		}
	}

}
