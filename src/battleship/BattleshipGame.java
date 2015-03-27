/**
 * 
 */
package battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
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
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Would you like to play a Battleship game? [Y/N]");
		try{
			while (br.readLine().equalsIgnoreCase("y")){
				
				Ocean o = new Ocean();
				o.placeAllShipsRandomly();
				int [] xy = new int[2];
				
				//o.printShipsConfiguration();   // TODO for testing only!!!  To be removed for production. 
												 //it will print initial state of the ocean after randomly populating it with warships
				
				do{
					
					xy = userImput(br, "Please enter coordinates for \"x\" and \"y\" within range [0,9] separated by space or \"\\n\". \nEnter \"exit\" to exit the game.");
					//xy = autoInput(br, "computer plays !"); // TODO for simulation only, to be removed for production, game will play by itself, for testing usualy
					o.shootAt(xy[0], xy[1]);
//					o.print();    // TODO  ---------------------------remove for production code !!!
//					System.out.println("Hit count:    "+o.getHitCount());TODO  ---------------------------remove for production code !!!
//					System.out.println("Shots fired: "+o.getShotsFired());TODO  ---------------------------remove for production code !!!
//					System.out.println("Ships sunk:   "+o.getShipsSunk());TODO  ---------------------------remove for production code !!!
				}while(o.getShipsSunk()!=10);
				o.print();
				System.out.println("Hit count:    "+o.getHitCount());
				System.out.println("Shots fired: "+o.getShotsFired());
				System.out.println("Ships sunk:   "+o.getShipsSunk());
				System.out.println("Would you like to play the game again? [Y/N]");
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("game exit...");
		
	}	
	
	/**
	 * Collect user input for the coordinates for the shoot.
	 * @return int array with values range 0 to 9.
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
	/**
	 * Returns a random coordinates to play a Battleship game automaticly
	 * @param int array with coordinates values from 0 to 9
	 */
	public static int[] autoInput(BufferedReader br, String msg){
		int [] xy = new int[2];
		
		Random random = new Random();
		xy[0] = random.nextInt(10);
		xy[1] = random.nextInt(10);
		
		return xy;
	}
}
