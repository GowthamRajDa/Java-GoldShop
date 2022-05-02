package products;

import loginSignup.Enums.Materials;

public class Jewellery {
	private Materials material;
	private String jewelCata;
	private String jewelName;
	private double price;

	public Jewellery(String material, String jewelCata, String jewelName, double price) {
		if (isMaterial(material)) {
			this.material = Materials.valueOf(material.toUpperCase());
			this.jewelName = jewelName;
			this.jewelCata = jewelCata;
			this.price = price;
		} else {
			System.out.println(material + " not found on materials lists");
		}

	}

	public Jewellery(Jewellery Source) {
		this.material = Source.material;
		this.jewelName = Source.jewelName;
		this.jewelCata = Source.jewelCata;
		this.price = Source.price;

	}

	public Materials getMaterial() {
		return material;
	}

	public String getJewelCata() {
		return jewelCata;
	}

	public double getPrice() {
		return price;
	}

	public String getJewelName() {
		return jewelName;
	}

	public void setJewelCata(String jewelCata) {
		this.jewelCata = jewelCata;
	}

	public void setJewelName(String jewelName) {
		this.jewelName = jewelName;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setMaterial(String material) {
		this.material = Materials.valueOf(material.toUpperCase());
	}

	public static boolean isMaterial(String material) {
		for (Materials m : Materials.values()) {
			if (m.name().equalsIgnoreCase(material.toUpperCase())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return ("\nMaterial : " + this.material + "\nCatagory : " + this.jewelCata + "\nName : " + jewelName
				+ "\nPrice : " + this.price);
	}

}
