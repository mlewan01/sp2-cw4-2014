/**
 * 
 */
package battleship;

/**
 * Describes characteristics common too all the ships.
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class Ship {
	
	private int bowRow; // which contains the bow (front) of the ship (0 to 9)
	private int bowColumn; // which contains the bow (front) of the ship (0 to 9)
	protected int length; // the number of squares occupied by the ship. 
	protected boolean horizontal; // true if the ship occupies a single row, false otherwise
	public boolean [] hit = new boolean[4]; // to indicate whether that part of the ship has been hit.
									 //only battleship uses 4 locations, see "length"
	
	/**
	 * Checks if is ok to put the ship in given location.
	 * The ship must not overlap another ship, or touch another ship (vertically, horizontally, or diagonally), 
	 * and it must not stick out beyond the array. Does not actually change either the ship or the Ocean, 
	 * just says whether it is legal to do so.
	 * @return true if ok to put a ship of this length with its bow in this location with the given orientation, false otherwise
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		if(horizontal){
			if(length+column<11){
				for(int ir=row-1; ir<=row+1;ir++){
  					if(ir<0 || ir>9){// check ir to not go out of the boundry
  						continue; 
  					}
					for(int ic=column-1; ic<=column+length; ic++){
						if(ic<0 || ic>9){ // checks ic to not go out of the boundry
							continue;
						}
						if(ocean.isOccupied(ir, ic)){
//							System.out.println("is Occupied!! "+toString()+" "+ir+" "+ic); // TODO to be removed !!
							return false;
						}
					}
				}
				System.out.println(" is Ok -- " +toString()+ " "+row+" "+column); // TODO to be removed
				return true;
			}else return false;
			
		}else{
			if(length+row<11){
				for(int ir=row-1; ir<=row+length;ir++){
  					if(ir<0 || ir>9){ // check ir to not go out of the boundry
  						continue;
  					}
					for(int ic=column-1; ic<=column+1; ic++){
						if(ic<0 || ic>9){ // checks ic to not go out of the boundry
							continue;
						}
						if(ocean.isOccupied(ir, ic)){
//							System.out.println("is Occupied!! "+toString()+" "+ir+" "+ic);  // TODO  to be removed for production !!
							return false;
						}
					}
				}
				System.out.println(" is Ok | " +toString()+ " "+row+" "+column); // TODO to be removed
				return true;
			}else return false;
		}
	}
	/**
	 * Puts the ship in the ocean. 
	 * This involves giving values to the bowRow, bowColumn and horizontal instance variables in the ship and it also involves
	 * putting a reference to the ship in each of 1 or more locations(up to 4) in the ships array in the Ocean object.
	 * (Note: This will be as many as four identical references; you can't refer to a part of a ship, only to the whole ship.)
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		this.horizontal = horizontal;
		ocean.ships[row][column] = this;
	}
	/**
	 * Checks if part of the ship occupies the given row and column and the ship hasn't been sunk, 
	 * marks that part of the ship as hit ( in the hit array, 0 indicate the bow).
	 * @return returns true if ship was hit, false otherwise 
	 */
	public boolean shootAt(int row, int column){
		if(!this.isSunk()){
			if(horizontal){
				if(bowRow==row){
					if(bowColumn==column){
						System.out.println("hit! 1");
						hit[0] = true;
						return true;
					}else if(bowColumn<column && (column-bowColumn<length)){
						System.out.println("hit! 2");
						hit[column-bowColumn] = true;
						return true;
					}else{
						return false;
					}
				}
			}else{
				if(bowColumn==column){
					if(bowRow==row){
						System.out.println("hit! 3");
						hit[0]=true;
						return true;
					}else if(bowRow<row && (row-bowRow<length)){
						System.out.println("hit! 4");
						hit[row-bowRow] = true;
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * Checks if ship is still floating an if can be still targeted.
	 * @return true if every part of the ship has been hit, false otherwise
/	 */
	public boolean isSunk(){
		int s=0;
		for(int i=0; i<length; i++){
			if(hit[i]==true){
				
				s++;
			}
		}
		System.out.println(this + " is hit: " + s + " times !!"); // TODO test output, remove for production code !!
		return s==length; 
	}
	
	// getters and setters
	/**
	 * Returns bowRow
	 * @return bowRow
	 */
	public int getBowRow(){
		return bowRow;
	}
	/**
	 * Sets the value of bowRow
	 */
	public void setBowRow(int row){
		bowRow = row;
	}
	/**
	 * Returns bowColumn
	 * @return bowColumn
	 */
	public int getBowColumn(){
		return bowColumn;
	}
	/**
	 * Sets the value of bowColumn
	 */
	public void setBowColumn(int column){
		bowColumn = column;
	}
	/**
	 * Returns is horizontal
	 * @return horizontal
	 */
	public boolean isHorizontal(){
		return horizontal;
	}
	/**
	 * Sets the value of the instance variable horizontal
	 */
	public void setHorizontal(boolean horizontal){
		this.horizontal = horizontal;
	}
	/**
	 * Returns the type of this ship. To be overridden in inheriting classes
	 * @return the ship's type
	 */
	public String getShipType(){
		return "ship generic";
	}
	/**
	 * Returns the length of this particular ship. To be overridden in inheriting classes
	 * @return the ship's length
	 */
	public int getLength(){
		return length;
	}
	/**
	 * toString method, printing the Object state
	 * @return String containing state of the object	
	 */
	public String toString(){
		//String s = isHorizontal() ? "-": "|"; // TODO to be remved
		return " sh ";
	}
}
