/**
 * 
 */
package battleship;

/**
 * Describes a part of the ocean that doesn't have a ship in it.
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 */
public class EmptySea extends Ship{
	
	public EmptySea() {
		super.length = 1;
	}
	
	@Override
	public boolean shootAt(int row, int column){
		return false; // Always returns false to indicate that nothing was hit !!
	}
	
	@Override
	public boolean isSunk(){
		return false; // Always returns false to indicate that nothing was sunk !!
	}
	
	@Override
	public String toString(){
		return "some string"; // TODO !!
	}
}
