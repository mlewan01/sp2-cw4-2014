/**
 * 
 */
package battleship;

import java.util.Random;

/**
 * Represents "ocean" the battlefield for ships.
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class Ocean {
	
	private Ship [][] ships;
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	
	/**
	 * class constructor initialises instance variables
	 */
	public Ocean(){
		ships = new Ship[10][10];
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		
	}
	
	/**
	 * Places all ten ships randomly on the (initially empty) ocean. 
	 * Places larger ships before smaller ones, to avoid ending up with no legal place to put a large ship. 
	 * You will want to use the Random class in the java.util package, so look that up in the Java API.
	 */
	public void placeAllShipsRandomly(){
		Ship s = new Ship();
		resetOcean();
		Random ran = new Random();
		
		for(int i=0; i<10; i++){
			int r = ran.nextInt(10);
			int c = ran.nextInt(10);
			boolean hor = ran.nextBoolean();
			if(i==0)s=new Battleship();
			if(i==1)s=new Cruiser();
			if(i==3)s=new Destroyer();
			if(i==6)s=new Submarine();
			System.out.println("r: "+r+" c "+c);
			if(!isOccupied(r,c)){
				if(s.okToPlaceShipAt(r, c, hor, this)){
					
				}else{
					i--;
					continue;
				}
			}else{
				i--;
				continue;
			}
		}
	}
	/**
	 * Returns true if the given location contains a ship, false if it does not.
	 * @return true if the location is is occupied, false otherwise
	 */
	public boolean isOccupied(int row, int column){
		int r = row;
		int c = column;
		if(ships[row][column].getShipType()!="emptySea"){
			return true;
		}else{
			if(column>0){
				for(int i=1; i<4; i++){
					c -=1;
					if(c>0){
						if(ships[row][c].getShipType()!="emptySea"){
							if(ships[row][c].isHorizontal())
							return  true;
						}
					}
					
				}
			}
			r = row;
			c = column;
			if(row>0){
				for(int i=1; i<4; i++){
					r-=1;
					if(r>0){
						if(ships[r][column].getShipType()!="emptySea"){
							if(!ships[r][column].isHorizontal())
							return true;
						}
					}
				}
			}
		}
		return false; 
	}
	/**
	 * Returns true if the given location contains a real ship, still afloat, (not an EmptySea), false if it does not. 
	 * In addition, this method updates the number of shots that have been fired, and the number of hits. 
	 * Note: If a location contains a real ship, shootAt should return true every time the user shoots at that same location. 
	 * Once a ship has been sunk, additional shots at its location should return false.
	 * @return true if the ship is still floating, false otherwise
	 */
	boolean shootAt(int row, int column){
		return false; // TODO !!
	}
	/**
	 * Prints the state of the Ocean. 
	 * Prints row numbers along the left edge of the array (0 to 9) and column numbers along the top. Left corner will be 0,0 position
	 * 'S' to indicate a location fired upon and hit a ship, '-' to indicate fired and missed location, 'x' to indicate sunken ship, 
	 * '.' to indicate a location never fired upon.
	 */
	public void print(){
		System.out.println("Ocean !!"); // TODO !!!
	}
	
	// getters and setters
	/**
	 * setting a Ship at given location
	 * @param row and column where to set the ship in ShipsArray
	 */
	public void setShip(int row, int column, Ship s){
		this.ships[row][column] = s;
	}
	/**
	 * Returns the number of shots fired (in this game).
	 * @return shotsFired field 
	 */
	public int getShotsFired(){
		return shotsFired;
	}
	/**
	 * Returns the number of hits recorded (in this game). All hits are counted, not just the first time a given square is hit.
	 * @return hitCount field
	 */
	public int getHitCount(){
		return hitCount;
	}
	/**
	 * Returns the number of ships sunk (in this game)
	 * @return shipsSunk field
	 */
	public int getShipsSunk(){
		return shipsSunk;
	}
	/**
	 * Checks if all the ships have been sunk
	 * @return true if number of sunken ships is greater than 9, false otherwise 
	 */
	public boolean isGameOver(){
		return shipsSunk > 9;
	}
	/**
	 * mainly for testing 
	 * Returns the 10x10 array of ships. (You will probably need this method for testing. However, 
	 * since it returns the actual array of actual ships, and could therefore be modified by some class that has no right to do so, 
	 * use this method only in your unit testing.) The methods in the Ship class that take an Ocean parameter really 
	 * need to be able to look at the contents of this array; the placeShipAt method even needs to modify it. 
	 * While it is undesirable to allow methods in one class to directly access instance variables in another class 
	 * (hence my earlier restriction, now crossed out), sometimes there is just no good alternative.
	 * @return ships the array with ships 
	 */
	public Ship[][] getShipArray(){ // ukryta wskazowka w opisie zadania, byc moze do ulatwienia napisania programu
		return ships;
	}
	/**
	 * populates Ocean with the fresh empty sea objects !
	 */
	public void resetOcean(){
		for(int i=0; i<10;i++){
			for(int j=0; j<10;j++){
				ships[i][j]=new EmptySea();
			}
		}
	}
}
