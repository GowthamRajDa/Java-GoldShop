package loginSignup;

public abstract class Login {
	private static String username;
	private static String password;
	private static String role;

	public static void MainOptions() {

		int mainResponse = ScannerAndPrinters.GetMainOptions();
		if (mainResponse == 1) {
			LoginUser();
		} else if (mainResponse == 2) {
			Registeration.createUser();
		} else {
			ScannerAndPrinters.ExitGreet();
		}

	}

	public static String LoginUser() {

		int times = 0;
		while (true) {
			if (times == 3) {
				ScannerAndPrinters.PasswordLimitReached();
				MainOptions();
			}
			username = ScannerAndPrinters.getUserName();
			password = ScannerAndPrinters.getPassword();

			role = Registeration.CheckLogin(username, password);
			if (role != null) {
				return role;
			} else {
				ScannerAndPrinters.WrongPassword();
				times++;
			}
		}
	}

}
