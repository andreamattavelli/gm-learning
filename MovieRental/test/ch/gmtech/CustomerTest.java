package ch.gmtech;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTest {

	@Test
	public void test1()  throws Throwable  {
		Customer customer0 = new Customer("Name Surname");
		Movie movie0 = new Movie("Mega", 2);
		Rental rental0 = new Rental(movie0, 2);
		customer0.addRental(rental0);
		assertEquals("Rental Record for Name Surname\n\tMega\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points", customer0.statement());
	}

	@Test
	public void test2()  throws Throwable  {
		Customer customer0 = new Customer("Name Surname");
		Movie movie0 = new Movie("Mega", 0);
		Rental rental0 = new Rental(movie0, 2);
		customer0.addRental(rental0);
		assertEquals("Rental Record for Name Surname\n\tMega\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points", customer0.statement());
	}

	@Test
	public void test3()  throws Throwable  {
		Customer customer0 = new Customer("Name Surname");
		Movie movie0 = new Movie("Mega", 1);
		Rental rental0 = new Rental(movie0, 2);
		customer0.addRental(rental0);
		assertEquals("Rental Record for Name Surname\n\tMega\t6.0\nAmount owed is 6.0\nYou earned 2 frequent renter points", customer0.statement());
	}

	@Test
	public void test4()  throws Throwable  {
		Customer customer0 = new Customer("Name Surname");
		Movie movie0 = new Movie("Mega", 2);
		Rental rental0 = new Rental(movie0, 557);
		customer0.addRental(rental0);
		assertEquals("Rental Record for Name Surname\n\tMega\t832.5\nAmount owed is 832.5\nYou earned 1 frequent renter points", customer0.statement());
	}

}
