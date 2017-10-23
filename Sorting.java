import java.util.Arrays;
import java.util.Random;


public class Sorting 
{
	 void merge(int arr[], int l, int m, int r)
	    {
	        // Find sizes of two subarrays to be merged
	        int n1 = m - l + 1;
	        int n2 = r - m;
	 
	        // Create temp arrays 
	        int L[] = new int [n1];
	        int R[] = new int [n2];
	 
	        // Copies data into temp array
	        for (int i=0; i<n1; ++i)
	            L[i] = arr[l + i];
	        for (int j=0; j<n2; ++j)
	            R[j] = arr[m + 1+ j];
	 
	 
	        // Merges the temp arrays
	 
	        
	        int i = 0, j = 0;
	 
	        
	        int k = l;
	        while (i < n1 && j < n2)
	        {
	            if (L[i] <= R[j])
	            {
	                arr[k] = L[i];
	                i++;
	            }
	            else
	            {
	                arr[k] = R[j];
	                j++;
	            }
	            k++;
	        }
	 
	        // Copies remaining elements if there are any
	        while (i < n1)
	        {
	            arr[k] = L[i];
	            i++;
	            k++;
	        }
	 
	        
	        while (j < n2)
	        {
	            arr[k] = R[j];
	            j++;
	            k++;
	        }
	    }
	 
	  
	    void sort(int arr[], int l, int r)
	    {
	        if (l < r)
	        {
	            // Find the middle point
	            int m = (l+r)/2;
	 
	            // Sort first and second halves
	            sort(arr, l, m);
	            sort(arr , m+1, r);
	 
	            // Merge the sorted halves
	            merge(arr, l, m, r);
	        }
	    }
		public static void quickSortRight(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		
		int pivot = arr[high];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSortRight(arr, low, j);
 
		if (high > i)
			quickSortRight(arr, i, high);
     
	}
	public static void quickSort2(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		int middle = 10+(high-10)/2
		int pivot = arr[middle];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort2(arr, low, j);
 
		if (high > i)
			quickSort2(arr, i, high);
     
	}
	
    void insertionSort(int array[])
    {
        int n = array.length;
        for (int i = 1; i<n; i++)
        {
            int key = array[i];
            int j = i-1;

            //move elements greater than key to the next position
            while(j>=0 && array[j] > key)
            {
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = key;
        }
    }

    void quickInsert(int[] arr, int low, int high){
        final int cutoff = 10;

		if (arr == null || arr.length == 0)
			return;

		while(low < high){

        }

	    // pick the pivot
	
        int pivot = arr[high];

        // make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
        if (low < j)
            if (j <= cutoff){
                insertionSort(arr);
            }
			else{
                quickSort(arr, i, low);
            }
 
		if (high > i)
			quickSort(arr, i, high);
        

	}

    void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;
 
		if (low >= high)
			return;
 
		// pick the pivot
		
		int pivot = arr[high];
 
		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
 
			while (arr[j] > pivot) {
				j--;
			}
 
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);
 
		if (high > i)
			quickSort(arr, i, high);
     
	}

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i =0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    void heapSort(int array[])
    {
        int n = array.length;

        //Build Heap
        for (int i = n/2 -1; i>=0; i--)
            heapify(array, n, i);
        
        //extract elements from heap one at a time
        for (int i = n-1; i>=0; i--)
        {
            //move root to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }    
    }

    void heapify(int array[], int n, int i)
    {
        int max = i; 
        int left = 2*i + 1; 
        int right = 2*i + 2;

        //if left > max
        if (left < n && array[left] > array[max])
            max = left;
        
        //if right > max
        if (right < n && array[right] > array[max])
            max = right;

        //if max not root
        if (max != i)
        {
            int swap = array[i];
            array[i] = array[max];
            array[max] = swap;

            //heapify sub-tree
            heapify(array, n, max);
        }

    }

    public static void main(String args[])
    {
        //User input of different sizes can be entered 4 different ways.
        //1: sorted in descending order
        //2: all data is the same
        //3: sorted in ascending order
        //4: Random order
        // must run all sorting methods and compare/display run times
        System.out.println("Enter the size of your array or type random for random size: ");
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        
        try{
            int n = Integer.parseInt(type);
            int array[] = new int[n];
            System.out.println("Enter in all the data you'd like to sort");
            array[0] = sc.nextInt();
            for(int i = 1; i<array.length; i++){
                int temp = sc.nextInt();
                array[i] = temp;
            }
        } catch (NumberFormatException e)
        {
            if ("random".equals(type)){
                int array[] = new int[math.random*15];
                System.out.println("Randomly generating data...");
                array[0] = math.random*50;
                for(int i = 1; i<array.length; i++){
                    array[i] = math.random*50;
                }
            }
        }
        


        //int arr[] = {12, 11, 13, 5, 6, 7};
        //int arry[] = {12, 11, 13, 5, 6, 8};
        //int n = arr.length;

        /*
         public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int arry[] = {12, 11, 13, 5, 6, 8};
        //int n = arr.length;
        long startTime=System.currentTimeMillis();
        Sorting obj = new Sorting();
        obj.heapSort(arr);
        long endTime   = System.currentTimeMillis();
	    long totalTime = endTime - startTime;
	    System.out.println("Run Time: " +totalTime);
        startTime=System.currentTimeMillis();
        obj.insertionSort(arry);
        endTime=System.currentTimeMillis();
        totalTime=endTime-startTime
        System.out.println("Here are your sorted arrays: ");
        printArray(arr);
        printArray(arry);
    }
        */
        
    }

}
