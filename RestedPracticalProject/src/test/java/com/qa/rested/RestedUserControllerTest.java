package com.qa.rested;

import java.io.File;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.rested.domain.RestedUser;
import com.qa.rested.rest.RestedUserController;
import com.qa.rested.rest.SleepController;

//Junit 5 - Junit 4
	// @BeforeAll - @BeforeClass : Needs to be a static method, this will run before
	// everything else; here we might set up DB connections, etc.
	// @BeforeEach - @Before : Method to run before every test, this best to setup
	// our prereqs before testing, e.g. create an object.
	// @AfterAll - @AfterClass : A static method, ran at the end of everything; used
	// to disconnect or close down our components e.g. DB.close();/scanner.close();
	// @AfterEach - @After : Method to run after every test, best used to tear-down
	// any allocated resource post test. e.g. clearing a list, etc.
	// @Test - @Test : A method that Junit will run, typically containing an
	// assertion.
	// @Disable - @Ignore : Prevents a test by running

	// Failures notify an invalid test result
	// Errors indicate an unexpected test execution

public class RestedUserControllerTest {
	
	File fileIn;
	
	@BeforeAll
	public static void beginTest() {
		System.out.println("The test starts now");
		System.out.println("=========================================");
	}
	
	@BeforeEach
	public void setup() {
		RestedUser restedUser = new RestedUser();;
		System.out.println("Run before every test");
		fileIn = new File("users-data.sql");
		
	}

	@Test
	@Ignore
	public void someTest() {
		boolean something = false;
		System.out.println("This is a test");
		assertEquals(1, 1);
		assertFalse("This will print if our conditions don't match", something);
		assertTrue("This will print if our conditions don't match", false);
	}

	@Test
	public void someOtherTest() {
		System.out.println("This is a test");
	}

	@After
	public void close() {
		System.out.println("Ran after each test");
		fileIn.delete();
	}

	@AfterClass
	public static void tearDown() {
		// scanner.close();
		System.out.println("End of test");
		System.out.println("=========================================");
	}
	
	@Test
	public void shouldCreateNewUser() {
	    RestedUser restedUser = new RestedUser();
	    restedUser.addUser(1, "1999-01-01", 22, 1, "test.user@domain", "password", "test", "user");
	}
	
	@Test
	public void shouldCreateNewSleep() {
		 SleepController sleepController = new SleepController();
		 SleepController.addSleep(1, 1999-01-01, 22, 1, "test.user@domain", "password", "test", "user");
	}
	
	@Test
	public void shouldCreateNewDream() {
	    fail("Fail");
	}
	
	@Test
	public void shouldCreateNewScreen() {
	    fail("Fail");
	}
	
	@Test
	public void shouldCreateNewWater() {
	    fail("Fail");
	}
	
	@Test
	public void shouldCreateNewWaterConsumed() {
	    fail("Fail");
	}
	
	@Test
	public void shouldCreateNewReport() {
	    fail("Fail");
	}
	
	@Test
	public void shouldGetUser() {
	    fail("Fail");
	}
	
	@Test
	public void shouldGetSleep() {
	    fail("Fail");
	}
	
	@Test
	public void shouldGetDream() {
	    fail("Fail");
	}
	
	@Test
	public void shouldGetScreen() {
	    fail("Fail");
	}
	
	@Test
	public void shouldGetWater() {
	    fail("Fail");
	}
	
	@Test
	public void shouldGetWaterConsumed() {
	    fail("Fail");
	}
	
	@Test
	public void shouldGetReport() {
	    fail("Fail");
	}
	
	@Test
	public void shouldReplaceSleep() {
	    fail("Fail");
	}
	
	@Test
	public void shouldReplaceDream() {
	    fail("Fail");
	}
	
	@Test
	public void shouldReplaceScreen() {
	    fail("Fail");
	}
	
	@Test
	public void shouldReplaceWater() {
	    fail("Fail");
	}
	
	@Test
	public void shouldReplaceWaterConsumed() {
	    fail("Fail");
	}
	
	@Test
	public void shouldReplaceReport() {
	    fail("Fail");
	}
	
	//
	
	@Test
	public void shouldDeleteUser() {
	    fail("Fail");
	}
	
	@Test
	public void shouldDeleteSleep() {
	    fail("Fail");
	}
	
	@Test
	public void shouldDeleteDream() {
	    fail("Fail");
	}
	
	@Test
	public void shouldDeleteScreen() {
	    fail("Fail");
	}
	
	@Test
	public void shouldDeleteWater() {
	    fail("Fail");
	}
	
	@Test
	public void shouldDeleteWaterConsumed() {
	    fail("Fail");
	}
	
	@Test
	public void shouldDeleteReport() {
	    fail("Fail");
	}

}
