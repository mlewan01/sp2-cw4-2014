/**
 * 
 */
package battleship;

/**
 * Describes a ship of length 2
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class Destroyer extends Ship{
	
	private String type; 
	
	public Destroyer(){
		super.hit  = new boolean[4];
		super.length = 2;
		type = "destroyer";
		super.ts = "d";
	}
	
	@Override
	public String getShipType(){
		return type;
	}
}
