package loginSignup;

import products.Sales;

public abstract class Actions {

	public static void getRoleLogin() {
		String Role=Login.LoginUser();
		if(Role.equalsIgnoreCase("ADMIN")) {
			adminActions();
		}else if(Role.equalsIgnoreCase("CUSTOMER")){
			customerActions();
		}
	}
	
	public static void customerActions() {
		int response=ScannerAndPrinters.getCustomerActions();
//1.View All Products 2.View Products by Category 3.View Products by Materials 4.Back 5.Exit"
		if(response==1) {
			Sales.showAllProducts();
		}else if(response==2) {
			Sales.showJewelsByCata();
		}else if(response==3) {
			Sales.showJewelsBymaterial();
		}else if(response==4) {
			getRoleLogin();
		}else {
			System.exit(0);
		}
	}

	public static void adminActions() {
		int response=ScannerAndPrinters.getAdminActions();	
//1.Add product to Store 2.Remove product 3.Edit Product 4.Back 5.Exit
		if(response==1) {
			Sales.addJewelToStore();
		}else if(response==2) {
			removeProductfromstore();
		}else if(response==3) {
			editProduct();
		}else if(response==4) {
			getRoleLogin();
		}else {
			System.exit(0);
		}
		
	}
	
	public static void removeProductfromstore() {
		
	}
	
	public static void editProduct() {
		
	}
	
}
