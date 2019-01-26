package bubblesort;

public class OptimizedBubbleSort {
    static int[] arr = {11, 25, 12, 22, 64, 3, 5, 11, 23, 26};
    static boolean swapped;
    
    public static void optimizedBubbleSort()
    {
        for(int i=0; i<(arr.length-1); ++i)
        {
            swapped = false;
            for(int j=0; j<arr.length - i -1; ++j)
            {
                if(arr[j+1] < arr[j])
                {
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    swapped = true;
                }
            }
            
            if(swapped == false)
            {
                break;
            }
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
        optimizedBubbleSort();
        printArray();
    }
}
