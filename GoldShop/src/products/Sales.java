package products;

import java.util.ArrayList;
import java.util.List;

import loginSignup.ScannerAndPrinters;
import loginSignup.Actions;
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
		System.out.println(jewel.getJewelName() + " added to the Store");
	}

	public static void addJewelToStore() {
		String material = ScannerAndPrinters.getProductMaterial();
		String jewelCata = ScannerAndPrinters.getProductCata();
		String jewelName = ScannerAndPrinters.getProductName();
		double price = ScannerAndPrinters.getPrice();
		addJewelToStore(material, jewelCata, jewelName, price);
		Actions.adminActions();
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
		if (myCart.isEmpty()) {
			System.out.println("Your Cart is Empty");
			Actions.customerActions();
		} else {
			for (Jewellery jewel : myCart) {
				System.out.println(i + ".\n" + jewel);
				i++;
			}
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
			try {
				return jewels.get(productInt - 1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
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
				if (jewel.getMaterial() == Materials.valueOf(material.toUpperCase())) {
					count++;
				}
				if (count == productInt) {
					return jewel;
				}

			}
		} else if (lastshown.equals("CART")) {
			try {
				return myCart.get(productInt - 1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

	public static String removeProductFromStore(Jewellery jewel) {
		String jewelname=jewel.getJewelName();
		jewels.remove(jewel);
		return jewelname;
	}

	public static void removeAllProductFromCart() {
		myCart.clear();
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

	public static void buyAllProductCart() {
		double totalAmount=0;
		if (myCart.isEmpty()) {
			System.out.println("Your Cart is Empty");
			Actions.customerActions();
		} else {
			for (Jewellery jewel : myCart) {
				totalAmount+=jewel.getPrice();
				System.out.println("The " + jewel.getJewelName() + " has been sold for " + jewel.getPrice());
			}
			System.out.println("\nTOTAL COST: "+totalAmount);
			myCart.clear();
			Actions.customerActions();
		}
	}
}
