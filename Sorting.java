public class Sorting 
{
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

}
