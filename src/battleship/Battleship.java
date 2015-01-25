/**
 * 
 */
package battleship;

/**
 * Describes a ship of length 4
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class Battleship extends Ship{
	
	private String type; 
	
	public Battleship(){
		hit  = new boolean[4];
		length = 4;
		type = "battleship";
	}
	
	@Override
	public String getShipType(){
		return type;
	}
	@Override
	public String toString(){
		return "ba";
	}
}
