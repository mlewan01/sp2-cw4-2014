package jUnitTests;

import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import battleship.Battleship;
import battleship.Destroyer;
import battleship.Ocean;
import battleship.Ship;
import battleship.Submarine;
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
	public static Ship s;
	static int r = 3;
	static int c = 4;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		o = new Ocean();
		o.placeAllShipsRandomly();
		r = 3;
		c = 4;
		
		s = new Battleship();
		s.setHorizontal(true);
		s.setBowRow(r);
		s.setBowColumn(c);
//		o.setShip(r, c, s);
//		o.setShip(5, c, s);
//		o.setShip(0,3,s);

//		o.setShip(9, 9, new Destroyer());
//		o.setShip(9, 4, new Submarine());
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

//	@Test
//	public void testRandom(){
//		Random r = new Random();
//		for(int i=0; i<100;i++){System.out.print(r.nextInt(10)+"  ");
//		if(i==50)System.out.println();}
//	}
	@Test
	public void testOkToPlaceShip(){
		o.print();
		System.out.println(o.isOccupied(2, 3));
		System.out.println(o.isOccupied(3, 3));
		System.out.println(o.isOccupied(r, c));
		System.out.println(o.isOccupied(r, 6));
		System.out.println(o.isOccupied(r, 7));
		System.out.println(o.isOccupied(r, 8));
		s.okToPlaceShipAt(2,3,true,o);
	}
}