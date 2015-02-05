/**
 * 
 */
package battleship;

/**
 * Describes a part of the ocean that doesn't have a ship in it.
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class EmptySea extends Ship{
	
	private String type;
	
	public EmptySea() {
		super.hit  = new boolean[4];
		super.length = 1;
		type = "emptySea";
		super.horizontal = true;
	}
	
	@Override
	public String getShipType() {
		return type;
	};
	@Override
	public boolean shootAt(int row, int column){
		super.hit[0]=true;
		return false; // Always returns false to indicate that nothing was hit !!
	}
	
	@Override
	public boolean isSunk(){
		return false; // Always returns false to indicate that nothing was sunk !!
	}
	
	@Override
	public String toString(){
		return " . ";
	}
}
