package main;

import loginSignup.ScannerAndPrinters;

import java.io.FileNotFoundException;

import loginSignup.Actions;
import loginSignup.Loader;
import loginSignup.Login;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		ScannerAndPrinters.Welcomegreet();
		
		String filePath=System.getProperty("user.dir")+"\\src\\Files\\jewels.txt";
		System.out.println(filePath);
		Loader.JewelLoader(filePath);
		Actions.customerActions();

	}

}
