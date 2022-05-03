package main;

import loginSignup.ScannerAndPrinters;

import java.io.FileNotFoundException;

import loginSignup.Actions;
import loginSignup.Loader;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		ScannerAndPrinters.welcomegreet();
		
		String jewelFilePath = System.getProperty("user.dir") + "\\src\\Files\\jewels.txt";
		String userFilePath = System.getProperty("user.dir") + "\\src\\Files\\users.txt";
		
		System.out.println("Adding jewels to Store");
		//Loading some products from file
		Loader.jewelLoader(jewelFilePath);
		System.out.println("Adding some default users");
		//Loading some default user from file
		Loader.userLoader(userFilePath);
		
		Actions.mainOptions();

	}

}
