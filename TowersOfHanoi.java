/****************************************************************************
 *
 * Created by: Julie Nguyen
 * Created on: Nov 2018
 * Created for: ICS4U
 * Recursive Towers of Hanoi program in java; returns instructions on how to
 * 		solve Towers of Hanoi problem for n (user input) disks in the least
 * 		amount of moves
 *
 ****************************************************************************/

import java.util.Scanner;
import java.lang.Math;

public class TowersOfHanoi {
	public static void main(String[] args) {
		// main stub for Towers of Hanoi program
		Scanner input = new Scanner(System.in);
		
		int disks;
		
		String poleA = "Pole A";
		String poleB = "Pole B";
		String poleC = "Pole C";
		
		System.out.print("Enter a positive integer for the number of disks: ");
		
		if(input.hasNextInt()) {
			disks = input.nextInt();
			
			if(disks < 0){
				System.out.println("\nError");
			}
			else {
				double min = minMoves(disks);
				System.out.println("\nMinimum number of moves: " + min);
				moves(disks, poleA, poleB, poleC);
			}
		}
		else {
			System.out.println("\nError");
		}
	}
	
	public static void moves(int num, String startPole, String endPole, String auxPole) {
		// returns instructions on how to solve Towers of Hanoi problem with n (user input) number of disks in the least moves
		if(num == 1) {
			printMoves(num, startPole, endPole);
		}
		else {
			moves(num - 1, startPole, auxPole, endPole);
			printMoves(num, startPole, endPole);
			moves(num - 1, auxPole, endPole, startPole);
		}
	}
	
	public static void printMoves (int num, String startPole, String endPole) {
		System.out.println("Move disk " + num + " from " + startPole + " to " + endPole + ".");
	}
	
	public static double minMoves(int num) {
		//method for finding number of minimum number of moves according to number user inputs
		double moves = Math.pow(2, num) - 1;
		return moves;
	}
}