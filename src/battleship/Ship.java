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
	private boolean horizontal; // true if the ship occupies a single row, false otherwise
	protected boolean [] hit = new boolean[4]; // to indicate whether that part of the ship has been hit.
									 //only battleship uses 4 locations, see "length"
	
	
	/**
	 * Checks if is ok to put the ship in given location.
	 * The ship must not overlap another ship, or touch another ship (vertically, horizontally, or diagonally), 
	 * and it must not stick out beyond the array. Does not actually change either the ship or the Ocean, 
	 * just says whether it is legal to do so.
	 * @return true if ok to put a ship of this length with its bow in this location with the given orientation, false otherwise
	 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
		return false; // TODO to be implemented
	}
	/**
	 * Puts the ship in the ocean. 
	 * This involves giving values to the bowRow, bowColumn and horizontal instance variables in the ship and it also involves
	 * putting a reference to the ship in each of 1 or more locations(up to 4) in the ships array in the Ocean object.
	 * (Note: This will be as many as four identical references; you can't refer to a part of a ship, only to the whole ship.)
	 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		// TODO 
	}
	/**
	 * Checks if part of the ship occupies the given row and column and the ship hasn't been sunk, 
	 * marks that part of the ship as hit ( in the hit array, 0 indicate the bow).
	 * @return returns true if ship was hit, false otherwise 
	 */
	public boolean shootAt(int row, int column){
		return false; // TODO to be implemented
	}
	/**
	 * Checks if ship is still floating an if can be still targeted.
	 * @return true if every part of the ship has been hit, false otherwise
	 */
	public boolean isSunk(){
		return false; // TODO to be implemented
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
		return "sh ";
	}
}
