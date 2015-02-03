/**
 * 
 */
package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * The main game's class containing the main method.
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class BattleshipGame {
	Ocean o;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ocean o = new Ocean();
		o.placeAllShipsRandomly();
		
		int [] xy = new int[2];
		xy[0]=3;
		xy[1]=3;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Would you like to play a Battleship game? [Y/N]");
//		while (sc.hasNext() && (sc.nextLine().equalsIgnoreCase("y"))){
		try{

			while (br.readLine().equalsIgnoreCase("y")){
				do{
					o.printShipsConfiguration();
					xy = userImput(br, "Please enter coordinates for \"x\" and \"y\" within range [0,9] separated by space or \"\\n\". \nEnter \"exit\" to exit the game.");
					o.shootAt(xy[0], xy[1]);
					o.print();
					
				}while(o.getShipsSunk()!=20);
				System.out.println("Would you like to play the game again? [Y/N]");
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("x="+xy[0]+"  y="+xy[1]);
		System.out.println("game exit...");
		
	}	
	
	/**
	 * Collect user input for the coordinates for the shoot.
	 * @return int array with coordinates to perform shoot to.
	 */
	public static int[] userImput(BufferedReader br, String msg){
		int [] xy = new int[2];
		boolean inputCorrect = false;

		while(!inputCorrect){
			System.out.println(msg);
			try{
				String s=br.readLine();
				
				if(s.equalsIgnoreCase("exit")) {
					System.out.println("exiting...");
					System.exit(0);
				}
				StringTokenizer st = new StringTokenizer(s);
				for(int i = 0; i<2; i++){
					if(st.hasMoreTokens()){
						xy[i] = Integer.parseInt(st.nextToken()); 
					}else{
						System.out.println("please enter coordinate nr: "+(i+1));
						st = new StringTokenizer(br.readLine());
						i--;
					}
				}
				inputCorrect = true;

			}catch(NumberFormatException e){
			 	System.out.println("wrong input, please try again...");

			 	continue;
			}catch(Exception e){
				System.out.println("some other errors... please try again !");
				continue;
			}
			
			if(xy[0]>9 || xy[0]<0){
				System.out.println("x not in a range..."+xy[0]);
				continue;
			}
			if(xy[1]>9 || xy[1]<0){
				System.out.println("y not in a range..."+xy[1]);
				continue;
			}
		}
		return xy;
	}
}
