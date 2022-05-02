package products;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import loginSignup.ScannerAndPrinters;
import loginSignup.Enums.Materials;

public abstract class Sales {
	private static List<Jewellery> jewels = new ArrayList<>();
	private static List<Jewellery> myCart = new ArrayList<>();
	private static String lastshown;
	private static int productInt;
	private static String material;
	private static String cata;

	public static void addJewelToStore(String material, String jewelCata, String jewelName, double price) {
		Jewellery jewel = new Jewellery(material, jewelCata, jewelName, price);
		jewels.add(jewel);
		System.out.println(jewel.getJewelName() + " added to the Store\n");
	}

	public static void addJewelToStore() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the Jewel Material :");
		String material = scan.nextLine();

		System.out.println("Please enter the Jewel Catagory :");
		String jewelCata = scan.nextLine();

		System.out.println("Please enter the Jewel Name :");
		String jewelName = scan.nextLine();

		System.out.println("Please enter the Jewel Price :");
		double price = scan.nextDouble();
		scan.nextLine();
		scan.close();
		addJewelToStore(material, jewelCata, jewelName, price);
	}

	public static void showAllProducts() {
		int i = 1;
		lastshown = "ALL";
		for (Jewellery jewel : jewels) {
			System.out.println(i + ".\n" + jewel);
			i++;
		}
	}

	public static void showCart() {
		int i = 1;
		lastshown = "CART";
		for (Jewellery jewel : myCart) {
			System.out.println(i + ".\n" + jewel);
			i++;
		}
	}

	public static void showJewelsByCata() {
		cata = ScannerAndPrinters.getProductCata();
		lastshown = "CATA";
		int i = 0;
		for (Jewellery jewel : jewels) {
			if (jewel.getJewelCata().equalsIgnoreCase(cata)) {
				i++;
				System.out.println(i + " : " + jewel);
			}
		}
	}

	public static void showJewelsBymaterial() {

		material = ScannerAndPrinters.getProductMaterial();
		lastshown = "MATERIAL";
		int i = 0;
		for (Jewellery jewel : jewels) {
			if (jewel.getMaterial() == Materials.valueOf(material.toUpperCase())) {
				i++;
				System.out.println(i + " : " + jewel);
			}
		}
	}

	public static Jewellery selectProduct() {
		productInt = ScannerAndPrinters.getProductInt();
		if (lastshown.equals("ALL")) {
			return jewels.get(productInt + 1);
		} else if (lastshown.equals("CATA")) {
			int count = 0;
			for (int i = 0; i < jewels.size(); i++) {
				Jewellery jewel = jewels.get(i);
				if (jewel.getJewelCata().equalsIgnoreCase(cata)) {
					count++;
				}
				if (count == productInt) {
					return jewel;
				}
			}

		} else if (lastshown.equals("MATERIAL")) {
			int count = 0;
			for (int i = 0; i < jewels.size(); i++) {
				Jewellery jewel = jewels.get(i);
				if (jewel.getMaterial() == Materials.valueOf(material)) {
					count++;
				}
				if (count == productInt) {
					return jewel;
				}

			}
		} else if (lastshown.equals("CART")) {
			return myCart.get(productInt + 1);
		}
		return null;
	}

	public static void removeProductFromStore(Jewellery jewel) {
		jewels.remove(jewel);
	}

	public static void removeProductFromCart(Jewellery jewel) {
		myCart.remove(jewel);
	}

	public static void editProduct(Jewellery jewel) {
		
	}

	public static void addToCart(Jewellery jewel) {
		myCart.add(jewel);
	}

	public static void sellProduct(Jewellery jewel) {

		System.out.println("The " + jewel.getJewelName() + " has been sold for " + jewel.getPrice());
		jewels.remove(jewel);
		ScannerAndPrinters.ExitGreet();
	}

}
