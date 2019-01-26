package bubblesort;

public class MoreOptimizedBubbleSort {
    static int[] arr = {11, 25, 12, 22, 64, 3, 5, 11, 23, 26};
    static boolean swapped;
    
    public static void moreOptimizedBubbleSort()
    {
        int length = arr.length -1, n;
        while(length >= 1)
        {
            n=0;
            for(int j=0; j<length; ++j)
            {
                if(arr[j+1] < arr[j])
                {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    n = j;
                }
            }
            
            length = n;
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
        moreOptimizedBubbleSort();
        printArray();
    }
}
