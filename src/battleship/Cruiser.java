/**
 * 
 */
package battleship;

/**
 * Describes a ship of length 3
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class Cruiser extends Ship{
	
	private String type; 
	
	public Cruiser(){
		hit  = new boolean[4];
		length = 3;
		type = "cruiser";
	}
	
	@Override
	public String getShipType(){
		return type;
	}
	@Override
	public String toString(){
		return "cr";
	}
}
