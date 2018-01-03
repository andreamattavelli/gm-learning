package ch.gmtech;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MovieTest {

	  @Test
	  public void test0()  throws Throwable  {
	      Movie movie0 = new Movie("Mega", 1);
	      assertEquals("Mega", movie0.getTitle());
	      assertEquals(1, movie0.getPriceCode());
	  }

}
