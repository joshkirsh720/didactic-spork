package usefulClasses;

import java.util.Scanner;

public class ArrayMethods {
	public static Scanner scan = new Scanner(System.in);
	public static void printArray(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int x = 0; x < arr[0].length; x++) {
				System.out.print(arr[i][x] + " ");
			}
			System.out.println();
		}
	}
	public static void printArray(double[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int x = 0; x < arr[0].length; x++) {
				System.out.print(arr[i][x] + " ");
			}
			System.out.println();
		}
	}
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void printArray(double[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void printArray(Object[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void printArray(Object[][] arr) { 
		for(int i = 0; i < arr.length; i++) {
			for(int x = 0; x < arr[0].length; x++) {
				System.out.print(arr[i][x] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Bubble sorts an array from least to greatest
	 * @param arr array to be sorted from least to greatest
	 */
	public static void sortLeastToGreatest(int[] arr) {
		int count = -1;
		
		while(count != 0) {
			count = 0;
			
			for(int i = 0; i < arr.length; i++) {
				if(i+1 == arr.length) break;
				
				//change < to > for greatest to least sort
				if(arr[i+1] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					count++;
				}
			}
		}
	}
	public static void sortLeastToGreatest(double[] arr) {
		int count = -1;
		
		while(count != 0) {
			count = 0;
			
			for(int i = 0; i < arr.length; i++) {
				if(i+1 == arr.length) break;
				
				//change < to > for greatest to least sort
				if(arr[i+1] < arr[i]) {
					double temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					count++;
				}
			}
		}
	}
	public static void sortGreatestToLeast(int[] arr) {
		int count = -1;
		
		while(count != 0) {
			count = 0;
			
			for(int i = 0; i < arr.length; i++) {
				if(i+1 == arr.length) break;
				
				//change < to > for greatest to least sort
				if(arr[i+1] > arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					count++;
				}
			}
		}
	}
	public static void sortGreatestToLeast(double[] arr) {
		int count = -1;
		
		while(count != 0) {
			count = 0;
			
			for(int i = 0; i < arr.length; i++) {
				if(i+1 == arr.length) break;
				
				//change < to > for greatest to least sort
				if(arr[i+1] > arr[i]) {
					double temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					count++;
				}
			}
		}
	}
	
	/**
	 * Sorts arr alphabetically
	 * @param arr array to be sorted alphabetically
	 */
	public static void sortAlphabetically(String[] arr) {
		int count = -1;
		
		while(count != 0) {
			
			count = 0;
			for(int i = 0; i < arr.length; i++) {
				if(i+1 == arr.length) break;
				
				if(arr[i+1].compareTo(arr[i]) < 0) {
					String temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					count++;
				}
			}
		}
	}
	public static void sortReverseAlphabetically(String[] arr) {
		int count = -1;
		
		while(count != 0) {
			
			count = 0;
			for(int i = 0; i < arr.length; i++) {
				if(i+1 == arr.length) break;
				
				if(arr[i+1].compareTo(arr[i]) > 0) {
					String temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					count++;
				}
			}
		}
	}
	
	/**
	 *Gathers input for both regular and 2D arrays
	 *@param arr array to be filled by user
	 *@return count how many values were inputted before the sentinel was inputted
	*/
	public static int getInput(int[][] arr) {
		final int SENTINAL = -999;
		int count = 0;
		boolean skip = false;
		int input;
		System.out.println("Enter integers until the array fills up or enter \"-999\" to exit early");
		
		for(int i = 0; i < arr.length; i++) {
			for(int x = 0; x < arr[0].length; x++) {
				System.out.print("Index [" + i + "][" + x + "] = ");
				input = scan.nextInt();
				if(input == SENTINAL) {
					skip = true;
					break;
				}
				arr[i][x] = input;
				count++;
			}
			
			if(skip) break;
		}
		return count;
	}
	public static int getInput(double[][] arr) {
		final int SENTINAL = -999;
		int count = 0;
		boolean skip = false;
		double input;
		System.out.println("Enter doubles until the array fills up or enter \"-999\" to exit early");
		
		for(int i = 0; i < arr.length; i++) {
			for(int x = 0; x < arr[0].length; x++) {
				System.out.print("Index [" + i + "][" + x + "] = ");
				input = scan.nextDouble();
				if(input == SENTINAL) {
					skip = true;
					break;
				}
				arr[i][x] = input;
				count++;
			}
			
			if(skip) break;
		}
		return count;
	}
	public static int getInput(int[] arr) {
		final int SENTINAL = -999;
		int count = 0;
		int input;
		System.out.println("Enter integers until the array fills up or enter \"-999\" to exit early");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print("Index [" + i + "] = ");
			input = scan.nextInt();
			if(input == SENTINAL) break;
			else {
				arr[i] = input;
				count++;
			}
		}
		return count;
	
	}
	public static int getInput(double[] arr) {
		final int SENTINAL = -999;
		int count = 0;
		double input;
		System.out.println("Enter doubles until the array fills up or enter \"-999\" to exit early");
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print("Index [" + i + "] = ");
			input = scan.nextDouble();
			if(input == SENTINAL) break;
			else {
				arr[i] = input;
				count++;
			}
		}
		return count;
	}
}
