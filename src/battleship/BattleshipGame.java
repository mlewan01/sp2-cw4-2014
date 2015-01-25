/**
 * 
 */
package battleship;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main game's class containing the main method.
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class BattleshipGame {
	public static void main(String[] a){
		Ocean o = new Ocean();
		o.placeAllShipsRandomly();
	}
	public static void main2(String[] arg){
		Ocean o = new Ocean();
		for(int i = 0; i<10;i++){
			for(int j=0; j<10; j++){
				o.getShipArray()[i][j] = new Ship();
				//System.out.println( "dupa" );
				System.out.println(o.getShipArray()[i][j].toString());
			}
		}
		System.out.println(o.getShipArray());
	}
	
	
	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		int [] xy = new int[2];
		String s;
		boolean mustGameGoOn = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to play a Battleship game? [Y/N]");
		while (sc.hasNext() && (sc.nextLine().equalsIgnoreCase("y"))){
			System.out.println("gra w toku");
			do{
				xy = userImput("Please enter coordinates for \"x\" and \"y\" within range [0,9] separated by space or \"\\n\". \nEnter \"exit\" to exit the game.");
				
			}while(mustGameGoOn);
			System.out.println("Would you like to play the game again? [Y/N]");
		}
		sc.close();
		System.out.println("x="+xy[0]+"  y="+xy[1]);
		System.out.println("game exit...");
		
	}
	
	
	
	/**
	 * Collect user input for the coordinates for the shoot.
	 * @return int array with coordinates to perform shoot to.
	 */
	public static int[] userImput(String msg){
		int [] xy = new int[2];
		boolean inputCorrect = false;
		Scanner sc = new Scanner(System.in);
		while(!inputCorrect){
			System.out.println(msg);
			try{
				if(sc.hasNext("exit")) {
					System.out.println("exiting...");
					System.exit(0);
				}
				xy[0] =sc.nextInt(); 
				xy[1]=sc.nextInt();
			}catch(InputMismatchException e){
			 	System.out.println("wrong input, please try again...");
			 	sc.nextLine();
			 	continue;
			}catch(Exception e){
				System.out.println("some other errors... please try again !");
				sc.nextLine();
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
