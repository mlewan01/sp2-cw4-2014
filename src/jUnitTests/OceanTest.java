package jUnitTests;

import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import battleship.Battleship;
import battleship.BattleshipGame;
import battleship.Destroyer;
import battleship.Ocean;
import battleship.Ship;
import battleship.Submarine;

/**
 * The main game's class containing the main method.
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */

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
		
//		s = new Battleship();
//		s.setHorizontal(true);
//		s.setBowRow(r);
//		s.setBowColumn(c);
//		o.setShip(r, c, s);
//		o.setShip(r, 5, s);
//		o.setShip(r, 6, s);
//		o.setShip(r, 7, s);
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
		//o.setShip(9, 9,( new Destroyer().setBowColumn(9)).setBowRow(9););
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
		o.printShipsConfiguration();
		System.out.println();
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
		System.out.println();
		System.out.println("is horizontal??:  "+o.ships[r][c].isHorizontal());
		for(boolean b:o.ships[r][c].hit){System.out.println(b);}
		System.out.println("true??:  " + o.ships[r][c].shootAt(r, 6));
		System.out.println("true??:  " + o.ships[r][c].shootAt(r, 7));
		//s.isSunk();
		for(boolean b:o.ships[r][c].hit){System.out.println(b);}
	}
	@Test
	public void testUserInput(){
		boolean test = true;
		BattleshipGame bg = new BattleshipGame();
		
//			int[]xy = bg.userImput("insert some coordinates...");
			o.shootAt(2, 1);
			o.shootAt(2, 2);
			o.shootAt(3, 2);
			o.shootAt(4, 0);
			o.shootAt(5, 2);
			o.shootAt(6, 4);
			o.shootAt(7, 6);
			o.shootAt(8, 8);
			o.shootAt(9, 0);
			o.shootAt(2, 1);
			o.shootAt(3, 3);
			o.shootAt(4, 5);
			o.shootAt(5, 7);
			o.shootAt(1, 0);
			o.shootAt(1, 2);
			o.shootAt(2, 0);
			o.shootAt(2, 2);
			o.shootAt(3, 4);
			o.shootAt(3, 6);
			o.shootAt(4, 8);
			o.shootAt(4, 0);
			o.shootAt(5, 1);
			o.shootAt(5, 3);
			o.shootAt(6, 5);
			o.shootAt(6, 5);
			o.shootAt(6, 5);
			o.shootAt(9, 9);
			o.print();
			
	}
}

