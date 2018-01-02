package ch.gmtech;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RentalTest {

	@Test
	public void test1() throws Throwable {
		Movie movie0 = new Movie("Mega", 2);
		Rental rental0 = new Rental(movie0, 1);
		assertEquals(1, rental0.getDaysRented());
	}
	
}
