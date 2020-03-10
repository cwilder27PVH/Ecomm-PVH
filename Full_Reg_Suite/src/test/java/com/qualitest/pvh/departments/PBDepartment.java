package com.qualitest.pvh.departments;

public enum PBDepartment {
	MEN("MEN"), WOMEN("WOMEN"), BIGANDTALL("BIG & TALL"), SALE("SALE"),
	BRANDS("Brands"), DRESSSHIRTS("Dress Shirts"), TIES("Ties"), SUITSANDPANTS("Suits & Pants"), SHOESANDACCESSORIES("Shoes & Accessories");

	public final String name;

	private PBDepartment(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return name;
	}
	
}
