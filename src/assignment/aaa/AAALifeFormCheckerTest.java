package assignment.aaa;

import org.junit.Test;

public class AAALifeFormCheckerTest {

	@Test
	public void invalidZip() throws InterruptedException {

		// Call with invalid zip code. TC01
		AAALifeFormChecker b = new AAALifeFormChecker("00101", "test@test.com");
		b.setUp();
		b.aaaLifeValidateQuotePage();
		b.tearDown();

	}

	@Test
	public void PassTest() throws InterruptedException {
		// call  with all valid details. TC02
		AAALifeFormChecker a = new AAALifeFormChecker("48335", "test@test.com");
		a.setUp();
		a.aaaLifeValidateQuotePage();
		a.tearDown();

	}

	@Test
	public void invalidEmail() throws InterruptedException {

		// Call with invalid email address. TC03
		AAALifeFormChecker b = new AAALifeFormChecker("48335", "test@test");
		b.setUp();
		b.aaaLifeValidateQuotePage();
		b.tearDown();

	}

}
