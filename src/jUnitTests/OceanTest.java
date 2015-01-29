package jUnitTests;

import java.util.Arrays;

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

public class OceanTest {
	
	public static Ocean o;
	public static Ship s;
	static int r = 3;
	static int c = 4;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		r = 3;
		c = 4;
		o = new Ocean();
		
		s = new Battleship();
		s.setHorizontal(true);
		s.setBowRow(r);
		s.setBowColumn(c);
//		o.setShip(r, c, s);
//		o.setShip(5, c, s);
//		o.setShip(0,3,s);
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
		o.print();
		/*for(int i = 0; i<10;i++){
			for(int j=0; j<10; j++){
				System.out.print(o.getShipArray()[i][j].toString());
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(o.getShipArray()[9]));*/
	}
//	@Test
//	public void testType(){
//		System.out.println(o.getShipArray()[1][1].getClass().getTypeName());
//		System.out.println(o.getShipArray()[2][2].getShipType());
//	}
	@Test
	public void testShootAt(){
		System.out.println("is horizontal??:  "+o.ships[r][c].isHorizontal());
		System.out.println("true??:  " + o.ships[r][c].shootAt(r, 6));
		s.isSunk();
		
	}
}

