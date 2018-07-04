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

    //inseretion sort method
    public static int[] insertionSort(int arr[]){
        int n = arr.length;
        for (int i=1; i<n; ++i){
            int key = arr[i];
            int j = i-1;
            //bump keyes greater then arr[i] one index higher
            while (j>=0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
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
    	int[] arrUnsorted1 = arrSorted;
    	shuffleArray(arrUnsorted1);
		int[] arrUnsorted2 = arrUnsorted1;
    	bubbleSort(arrUnsorted1);
    	insertionSort(arrUnsorted2);
    	if(arrSorted==arrUnsorted1&&arrSorted==arrUnsorted2){
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
    	

    	//tests sorting methods 50 times
    	boolean test = true;
    	for(int i=0; i<50; i++){
    		if(!test()){
    			System.out.println("algorithm did not sort correctly for test +" + i);
    			test = false;
    		}
    	}
    	if(test){
    		System.out.println("All tests passed!");
    	}else{
    		System.out.println("a test failes:( individually test methods to find out which one");
    	}
    }
}
