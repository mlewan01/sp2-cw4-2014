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
	
	public Ship [][] ships; // change to protected later, made public for tests
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	
	/**
	 * class constructor initialises instance variables
	 */
	public Ocean(){
		ships = new Ship[10][10];
		this.resetOcean(); // populates the ocean with fresh emptySea segments
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
/*		for(int i=0; i<10; i++){
			for(int j=0; j<10;j++){
				ships[i][j] = new Ship();
			}
		}*/
	}
	
	/**
	 * Places all ten ships randomly on the (initially empty) ocean. 
	 * Places larger ships before smaller ones, to avoid ending up with no legal place to put a large ship. 
	 * You will want to use the Random class in the java.util package, so look that up in the Java API.
	 */
	public void placeAllShipsRandomly(){
		Ship s = new Ship();
		this.resetOcean(); // populates the ocean with fresh emptySea segments // TODO maybe to be removed ??
		Random ran = new Random();
		
		for(int i=0; i<10; i++){
			//System.out.println("proba: "+ i); // TODO remove for production code !!
			int r = ran.nextInt(10);
			int c = ran.nextInt(10);
			boolean hor = ran.nextBoolean();
			if(i==0)s=new Battleship();
			if(i>=1)s=new Cruiser();
			if(i>=3)s=new Destroyer();
			if(i>=6)s=new Submarine();
			
			s.setBowRow(r);
			s.setBowColumn(c);
			s.setHorizontal(hor);
			
			if(!isOccupied(r,c)){
				if(s.okToPlaceShipAt(r, c, hor, this)){
					s.placeShipAt(r, c, hor, this);
//					System.out.println("r: "+r+" c "+c+ "ship: "+s.toString()+ "hor? "+hor); // TODO test output !!! remove for production !!
				}else{
					i--;
					continue;
				}
			}else{
				i--;
				continue;
			}
		}
		
		for(int i=0; i<10;i++){
			int m=0;
			for(int j=0; j<10; j++){
				Ship sh = this.ships[i][j];
				int l = sh.length;
				if(sh.getShipType()!="emptySea" && sh.horizontal && l>1){
					if(m==0){
						for(int k=j+1; k<j+l; k++){
							if(k<10){
								this.ships[i][k] = sh;
								m++;
							}
						}
					}else m--;
				}
			}
		}
		for(int i=0; i<10;i++){
			int n=0;
			for(int j=0; j<10; j++){
				Ship sh = this.ships[j][i];
				int l = sh.length;
				if(sh.getShipType()!="emptySea" && !sh.horizontal && l>1){
//					System.out.println("test n: " + n);  // TODO to be removed
					if(n==0){
//						System.out.println("  test2 n: " +n); // TODO to be removed
						for(int k=j+1; k<j+l; k++){
							if(k<10){
								this.ships[k][i] = sh;
								n++;
							}
						}
					}else n--;
				}
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
					c --;
					if(c>=0){
						Ship s = ships[row][c];
						if(s.getShipType()!="emptySea"){
							if(s.isHorizontal() && s.length>column-c) // TODO important might need adjustments
							return  true;
						}
					}
					
				}
			}
			r = row;
			c = column;
			if(row>0){
				for(int i=1; i<4; i++){
					r--;
					if(r>=0){
						Ship s =ships[r][column];
						if(s.getShipType()!="emptySea"){
							if(!s.isHorizontal() && s.length>row-r) // TODO important might need adjustments 
							return true;
						}
					}
				}
			}
		}
		return false; 
	}
//	public Ship adjecentShipUp(int row, int column, boolean horizontal){ // TODO to be removed
//		int r = row;
//		int c = column;
//		Ship s = ships[row][column];
//		if(s.getShipType()!="emptySea"){
//			return s;
//		}else{
//			if(column>0 && horizontal){
//				for(int i=1; i<4; i++){
//					c --;
//					if(c>=0){
//						s = ships[row][c];
//						if(s.getShipType()!="emptySea"){
//							if(s.isHorizontal() && s.length>column-c) // TODO important might need adjustments
//							return  s;
//						}
//					}
//					
//				}
//			}
//			r = row;
//			c = column;
//			if(row>0 && !horizontal){
//				for(int i=1; i<4; i++){
//					r--;
//					if(r>=0){
//						s =ships[r][column];
//						if(s.getShipType()!="emptySea"){
//							if(!s.isHorizontal() && s.length>row-r) // TODO important might need adjustments 
//							return s;
//						}
//					}
//				}
//			}
//		}
//		return null;
//	}
	/**
	 * Returns true if the given location contains a real ship, still afloat, (not an EmptySea), false if it does not. 
	 * In addition, this method updates the number of shots that have been fired, and the number of hits. 
	 * Note: If a location contains a real ship, shootAt should return true every time the user shoots at that same location. 
	 * Once a ship has been sunk, additional shots at its location should return false.
	 * @return true if the ship is still floating, false otherwise
	 */
	public boolean shootAt(int row, int column){
		this.shotsFired++;
		Ship s = ships[row][column];
		
		if(s.getShipType() == "emptySea"){
			s.hit[0]=true;
			System.out.println("miss...");
			return false;
		}else {
			System.out.println("hit ! ");
			if(s.isHorizontal()){
				int h = column-s.getBowColumn(); // to determine the right segment of the ship
				if(s.isSunk()){
					return false;
				}else {
					this.hitCount++;
					if(s.hit[h]) {
						return true;
					}else {
						s.hit[h] = true;
						if(s.isSunk()) {
							this.shipsSunk++;
							System.out.println("you just sunk: "+s.getShipType());
						}
						return true;
					}
				}
			}else{
				int h = row-s.getBowRow();
				if(s.isSunk()){
					return false;
				}else {
					this.hitCount++;
					if(s.hit[h]){
						return true;
					}else{
						s.hit[h] = true;
						if(s.isSunk()) {
							this.shipsSunk++;
							System.out.println("you just sunk: "+s.getShipType());
						}
						return true;
					}
				}
			}
		}
	}
	/**
	 * Prints the state of the Ocean. 
	 * Prints row numbers along the left edge of the array (0 to 9) and column numbers along the top. Left corner will be 0,0 position
	 * 'S' to indicate a location fired upon and hit a ship, '-' to indicate fired and missed location, 'x' to indicate sunken ship, 
	 * '.' to indicate a location never fired upon.
	 */
	public void print(){// TODO !!!
		System.out.print("  ");
		for(int i = 0; i<10; i++){System.out.print(" "+i+" ");}
		System.out.println();
		for(int i = 0; i<10;i++){
			System.out.print(i+" ");
			for(int j=0; j<10; j++){
				Ship s = this.ships[i][j];
				if(s.isHorizontal()){
					int h = j-s.getBowColumn(); // to determine the right segment of the ship
					if(s.isSunk()){
						System.out.print(" x ");
					}else if(s.hit[h]){
						if(s.getShipType() == "emptySea"){
							System.out.print(" - ");
						}else System.out.print(" S ");
					}else System.out.print(" . ");
					
				}else{
					int h = i-s.getBowRow();
					if(s.isSunk()){
						System.out.print(" x ");
					}else if(s.hit[h]){
						if(s.getShipType() == "emptySea"){
							System.out.print(" - ");
						}else System.out.print(" S ");
					}else System.out.print(" . ");
				}
			}
			System.out.println();
		}
	}
	/**
	 * TODO 
	 */
	public void printShipsConfiguration(){
		System.out.print("  ");
		for(int i = 0; i<10; i++){System.out.print(" "+i+" ");}
		System.out.println();
		for(int i = 0; i<10;i++){
			System.out.print(i+" ");
			for(int j=0; j<10; j++){
				Ship s = this.getShipArray()[i][j];
				System.out.print(s.toString());
			}
			System.out.println();
		}
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
				Ship s = new EmptySea();
				s.setBowRow(i);
				s.setBowColumn(j);
				ships[i][j]=s;
			}
		}
	}
}
