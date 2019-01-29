package insertionsort;

public class InsertionSort {

    static int[] arr = {11, 25, 12, 22, 64, 3, 5, 11, 23, 26};
    
    public static void insertionSort()
    {
        for(int i=1; i<arr.length; ++i)
        {
            int temp = arr[i];
            int j = i;
            while(j>0 && arr[j-1] > temp)
            {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
    }
    
    public static void printArray()
    {
        for(int i=0; i<arr.length; ++i)
        {
            System.out.print(arr[i] + "  ");
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) {
        insertionSort();
        printArray();
    }
    
}
