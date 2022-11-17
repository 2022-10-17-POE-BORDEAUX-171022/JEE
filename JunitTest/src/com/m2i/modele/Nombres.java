package com.m2i.modele;


public class Nombres extends Object{
	
	int monNombre;

	public int getMonNombre() {
		return monNombre;
	}

	public void setMonNombre(int monNombre) {
		this.monNombre = monNombre;
	}
 
	public Nombres() {
	}

	public Nombres(int monNombre) {
		super();
		this.monNombre = monNombre;
	}
	
	public Nombres adition(Nombres n) {
		 this.monNombre = Math.addExact(monNombre, n.getMonNombre());
		return this;
	}
	
	public Nombres soustraction(Nombres n) {
		 this.monNombre -= n.getMonNombre();
		return this;
	}
	
	public Nombres square() {
		this.monNombre = this.monNombre * this.monNombre;
		return this;
		
	}
	
	public Nombres divided(Nombres n) throws Exception {
		
		if (n.getMonNombre() == 0) {
			throw new Exception("Divided by 0");
		} 
		
		this.monNombre = this.monNombre / n.getMonNombre();
		return this;	
	}
	
	public boolean isPositive() {
		return this.monNombre >= 0 ? true : false;
	}
	
	
	
	
//	// a%b
	public int modulo(Nombres n) {
		return this.monNombre % n.getMonNombre();
	}
//	
//	// a*b
	public Nombres multiplication(Nombres n) {
		
		this.monNombre = this.monNombre * n.getMonNombre();
		return this;
		
	}
//	
	public Nombres max(Nombres n) {
		return this.monNombre > n.monNombre ? this : n;
	}
	
//
	public Nombres min(Nombres n) {
		return this.monNombre > n.monNombre ? n : this ;
	}
//
	public boolean equals(Nombres n) {
		return this.monNombre == n.monNombre ? true : false;
	}

	public boolean isPalindromeNumber() {
		String sNumber = String.valueOf( this.monNombre); // "12345"
		String reversedNumber = new StringBuilder(sNumber).reverse().toString(); // "54321"
		return reversedNumber.equals(sNumber);
	}
	
}
