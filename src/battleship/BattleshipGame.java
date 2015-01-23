/**
 * 
 */
package battleship;

import java.util.Scanner;

/**
 * The main game's class containing the main method.
 * 
 * @author: mlewan01 <Mariusz Lewandowski, Student ref: 12906023>
 * class: sp2-2014
 * what: sp2-cw4-2014 Battleship game
 */
public class BattleshipGame {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x=0, y=0;
		String s;
		boolean mustGameGoOn = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to play a Battleship game? [Y/N]");
		while (sc.hasNext() && (sc.nextLine().equalsIgnoreCase("y"))){
			System.out.println("gra w toku");
			do{
				System.out.println("Please enter coordinates for \"x\" and \"y\" within range [0,9] separated by space");
				try{
					x=sc.nextInt(); 
					y=sc.nextInt();
				}catch(Exception e){
					 	System.out.println("wrong input, please try again...");
					 	sc.nextLine();
					 	continue;
				}
				if(x>9 || x<0){
					System.out.println("x not in a range..."+x);
					continue;
				}
				if(y>9 || y<0){
					System.out.println("y not in a range..."+y);
					continue;
				}
				
			}while(mustGameGoOn);
			System.out.println("Would you like to play the game again? [Y/N]");
		}
		sc.close();
		System.out.println("x="+x+"  y="+y);
		System.out.println("game exit...");
		
	}
	
	
	
	/**
	 * Collect user input for the coordinates for the shoot.
	 * @return int array with coordinates to perform shoot to.
	 */
	public String userImput(String msg){
		System.out.println(msg);
		String s="";
		
		boolean inputCorrect = false;
		Scanner sc = new Scanner(System.in);
		while(!inputCorrect){
			try{
				s = sc.nextLine();
				inputCorrect = true;
				sc.close();
	
			}catch(Exception e){
				System.out.println("Sorry, input errors detected... Please input again!");
				sc.close();
				sc = new Scanner(System.in);
				continue;
			}
		}

		return s;
	}
}
