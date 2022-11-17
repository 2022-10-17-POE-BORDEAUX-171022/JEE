package com.m2i.modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NombreTest {
	
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Before All");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("After All");

	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before Each");

	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Each");

	}

	
	
	@Test
	public void testAdition() {
		System.out.println("testAdition");
		Nombres n1 = new Nombres(5); 
		Nombres n2 = new Nombres(9);
		
		n1.adition(n2);
		
		assertEquals(14, n1.getMonNombre());		 
	}
	
	@Test
	public void testAditionWithNegativNumbers() {
		System.out.println("testAditionWithNegativNumbers");
		Nombres n1 = new Nombres(-5);
		Nombres n2 = new Nombres(-9);
		
		
		n1.adition(n2);
		
		assertEquals(-14, n1.getMonNombre());		
	}
	
	
	@Test
	public void testSquare() {
		System.out.println("testSquare");
		Nombres n1 = new Nombres(5);

		Nombres n2 = new Nombres(-3);

		
		
		n1.square();
		n2.square();
		
		assertEquals(25 , n1.getMonNombre());		
		assertEquals(9 ,n2.getMonNombre());		
	}
	
	
	@Test
	public void testSoustraction() {
		System.out.println("testSoustraction");

		Nombres n1 = new Nombres(5);

		Nombres n2 = new Nombres(3);

		
		
		n1.soustraction(n2);
		assertEquals(2, n1.getMonNombre() );		
	}
	
	
	@Test
	public void testSetter() {
		System.out.println("testSetter");

		Nombres n1 = new Nombres(0);
		assertEquals(0, n1.getMonNombre() );		
		
		n1.setMonNombre(5);
		assertEquals(5, n1.getMonNombre() );		

		n1.setMonNombre(-5);
		assertEquals(-5, n1.getMonNombre() );		
		
	}
	
	@Test
	public void testDivision() throws Exception {
		System.out.println("testDivision");

		Nombres n1 = new Nombres(10);
		Nombres n2 = new Nombres(0);
				
		assertThrows( Exception.class, () -> {
			n1.divided(n2);
		});
		
		
		Nombres n3 = new Nombres(5);
		n1.divided(n3);
		assertEquals(2, n1.getMonNombre());
		
		
	}
	
	@Test
	public void testIsPositive() {
		System.out.println("testDivision");

		Nombres n1 = new Nombres(10);
		Nombres n2 = new Nombres(-10);

		
		assertTrue(n1.isPositive());
		assertFalse(n2.isPositive());
		
		
	}
	
	@Test
	public void testOverMaxInt() {
		

		Nombres n1 = new Nombres(Integer.MAX_VALUE);
		Nombres n2 = new Nombres(10);		
		
		assertThrows( ArithmeticException.class, () -> {
			n1.adition(n2);
		});
	}
	
	
	
	
	@Test
	public void testModulo() {
		Nombres n1 = new Nombres(10);
		Nombres n2 = new Nombres(5);
		Nombres n3 = new Nombres(8);

		
		assertEquals(0, n1.modulo(n2));
		assertEquals(2, n1.modulo(n3));
	}
	
	@Test
	public void testMultiplication() {
		Nombres n1 = new Nombres(10);
		Nombres n2 = new Nombres(5);
		Nombres n3 = new Nombres(0);
		
		assertEquals(50, n1.multiplication(n2).getMonNombre());
		assertEquals(0, n1.multiplication(n3).getMonNombre());
	}
	
	
	@Test
	public void testMaxMin() {
		Nombres n1 = new Nombres(10);
		Nombres n2 = new Nombres(5);
		
		
		
		assertEquals(n1, n1.max(n2));
		assertEquals(n2, n1.min(n2));
		assertEquals(n2, n2.min(n2));
	}
	
	
	@Test
	public void testEquals() {
		Nombres n1 = new Nombres(10);
		Nombres n2 = new Nombres(5);		
		Nombres n3 = new Nombres(10);

		assertFalse(n1.equals(n2));
		assertTrue(n1.equals(n3));
		assertTrue(n2.equals(n2));
	}
	
	
	@ParameterizedTest(name="Test Palindrome")
	@ValueSource(ints = {32123, 454, 8, 56565})
	public void testPalindrome2(int number ) {
		assertTrue( new Nombres(number).isPalindromeNumber());
	}
	
	
	@ParameterizedTest(name="Test Palindrome")
	@ValueSource(ints = {321723, 4544, 98, 12212})
	public void testisNotPalindrome(int number ) {
		assertFalse( new Nombres(number).isPalindromeNumber());
	}
}
