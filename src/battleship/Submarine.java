/**
 * 
 */
package battleship;

/**
 * Describes a ship of length 1
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class Submarine extends Ship{
	
	private String type; 
	
	public Submarine(){
		hit  = new boolean[4];
		length = 1;
		type = "submarine";
	}
	
	@Override
	public String getShipType(){
		return "type";
	}
	@Override
	public String toString(){
		return "some string";
	}
	
}
