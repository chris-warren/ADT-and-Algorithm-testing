/* AlgTest.java
*  Chris Warren 
*  
*  The purpose of this code is to implement and test the efficiency of sorting algorithms
*
*/


import java.util.*;
public class AlgTest{



	//bubble sort method
	public static int[] bubbleSort(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        }
        return arr;
    }

    //test method that creates a random array with distinct keyes, sorts it and tests it for correctness
    public static boolean test(){
    	boolean test = true;
		int[] arrSorted = new int[100];
    	for(int i=0; i<100; i++){
    		arrSorted[i]=i;
    	}
    	int[] arrUnsorted = arrSorted;
    	shuffleArray(arrUnsorted);

    	bubbleSort(arrUnsorted);

    	if(arrSorted==arrUnsorted){
    		return true;
    	}else{
    		return false;
    	}
    }

    //helper method that randomizes arrays
	private static void shuffleArray(int[] arr){
	    int index, temp;
	    Random random = new Random();
	    for (int i = arr.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        temp = arr[index];
	        arr[index] = arr[i];
	        arr[i] = temp;
	    }
	}


    public static void main(String args[]){
    	

    	//tests bubble sort 50 times
    	boolean test = true;
    	for(int i=0; i<50; i++){
    		if(!test()){
    			System.out.println("algorithm did not sort correctly for test +" + i);
    			test = false;
    		}
    	}
    	if(test){
    		System.out.println("All tests passed!");
    	}
    }
}