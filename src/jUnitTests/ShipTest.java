package jUnitTests;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import battleship.Ocean;
import battleship.Ship;
/**
 * This is  a JUnit test for Ocean. Test every required method for Ocean, including the constructor, 
 * but not including the print() method.
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class ShipTest {
	
	private static Ocean o; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		o = new Ocean();
		//o.placeAllShipsRandomly();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRandom(){
		Random r = new Random();
		for(int i=0; i<100;i++){System.out.print(r.nextInt(10)+"  ");
		if(i==50)System.out.println();}
	}
}