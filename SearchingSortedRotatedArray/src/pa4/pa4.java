/*
 *  Jordan Stein 
 *  pa4.java
 * 
 * Time Complexity: O(n) because we must iterate through every element of the array to output it back to the user.
 *                  findThePivot and binarySearch have a total time complexity of O(log n) because both of those
 *                  algorithms truncate half the array per recursive call. (log n + log n) = 2(log n) = O(log n)
 *                  
 * Space Complexity: O(n) where n is the amount of elements the user inputs into the sorted rotated array.
 */
package pa4;

import java.util.*;

public class pa4 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many integers would you like to input?");
		int numOfInts = sc.nextInt(); // number of integers user will enter
		
		System.out.println("Please enter "+numOfInts+" integers to fill a sorted, rotated array:");
		
		int[] arr = new int[numOfInts];
		
		for (int i=0; i < numOfInts; i++)
			arr[i] = sc.nextInt(); // allows user to read in numbers, filling the array
		
		System.out.println("The array you entered is: ");
		for (int i: arr) System.out.print( i + " "); // reads the array to the user O(n)
	
		System.out.print("\nPlease enter the value you wish to search for in the array: ");
		int item = sc.nextInt(); // value to be searched for
		
		sc.close(); // done with scanner now
		
		int pivot = findThePivot(arr, 0, arr.length-1); // returns pivot index in rotated sorted array O(log n)
		
		int index=0; // index of the element we find in the array
		if (arr[pivot] == item) // if the pivot is equal to the item, thats the index
			index = pivot;
		else
		{	
			if (item <= arr[arr.length-1]) // if the item is above the pivot index in the array
				index = binarySearch(arr, pivot, arr.length-1, item); // if the item is below the pivot index in the array
			else index = binarySearch(arr, 0, pivot-1, item);// if the item is below the pivot index in the array
		}
		
		System.out.println(item+" was found at index "+index+" of the array.");
	}
	
	public static int findThePivot(int [] array, int start, int end) // returns index of pivot element in sorted rotated array
	{
		
		if (start == end) return start; // if the array is size 1, that will be the pivot.
		
		if ((end - start) == 1) // if the indexes we are comparing are adjacent, we want the smaller value for the pivot.
		{
			if (array[end] > array[start]) return start;
			else return end;
		}
	 
		int mid = start + (end - start) / 2; // calculate "new pivot"
	 
		if (array[start] < array[end]) // checks if the array is rotated, if its not, the first element is the pivot
			return start;

		// if array[mid] > array[start], we must check the right side of the array for the pivot
		// otherwise, we must check the left side of the array for the pivot
		return array[mid] > array[start] ? findThePivot(array,mid,end) : findThePivot(array,start,mid);
		
	}
	
	public static int binarySearch(int arr[], int low, int high, int item)
	{
		if (arr[low] == item) return low; // if low is item, we found it
		if (arr[high] == item) return high; // if high is item, we found it
		if (arr[0] <= item) return binarySearch(arr, 0, high-1, item); // search bottom half of array
		return binarySearch(arr, low+1, high-1, item); // search top half of array
	}
}
