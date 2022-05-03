package loginSignup;

public abstract class Login {
	private static String username;
	private static String password;
	private static String role;

	public static String loginUser() {

		int times = 0;
		while (true) {
			if (times == 3) {
				ScannerAndPrinters.passwordLimitReached();
				ScannerAndPrinters.ExitGreet();
			}
			username = ScannerAndPrinters.getUserName();
			password = ScannerAndPrinters.getPassword();

			role = Registeration.checkLogin(username, password);
			if (role != null) {
				return role;
			} else {
				ScannerAndPrinters.wrongPassword();
				times++;
			}
		}
	}

	public static String getLoggedInUser() {
		return username;
	}

	public static String getLoggedInRole() {
		return role;
	}

}
