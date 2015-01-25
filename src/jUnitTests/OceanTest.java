package jUnitTests;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import battleship.Destroyer;
import battleship.Ocean;
import battleship.Ship;
import battleship.Submarine;

public class OceanTest {
	
	public static Ocean o;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		o = new Ocean();
		o.placeAllShipsRandomly();
		//o.setShip(9, 9, new Destroyer());
		//o.setShip(9, 4, new Submarine());
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
	public void testIsOccupied() {
		o.setShip(9, 9, new Destroyer());
		for(int i = 0; i<10;i++){
			for(int j=0; j<10; j++){
				System.out.print(o.isOccupied(i, j));
			}
			System.out.println();
		}
		for(Ship s: o.getShipArray()[1]){
			
		}
		//fail("Not yet implemented");
	}
	@Test
	public void testToString() {
		
		for(int i = 0; i<10;i++){
			for(int j=0; j<10; j++){
				System.out.print(o.getShipArray()[i][j].toString());
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(o.getShipArray()[9]));
	}
	@Test
	public void testType(){
		System.out.println(o.getShipArray()[1][1].getClass().getTypeName());
		System.out.println(o.getShipArray()[2][2].getShipType());
	}
}

