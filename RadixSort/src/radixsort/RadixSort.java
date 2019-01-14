package radixsort;

import java.util.Arrays;

public class RadixSort {

    static int[] arr = {170, 45, 75, 90, 802, 24, 2, 66, 934, 1100, 802, 45};
    static int[] output = new int[arr.length];
    static int[] count = new int[10];
    
    public static int getMax()
    {
        int max = arr[0];
        for(int i=1; i<arr.length; ++i)
        {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }
    
    public static void countingSort(int exp)
    {
        Arrays.fill(count, 0);
        
        for(int i=0; i<arr.length; ++i)
        {
            count[(arr[i]/exp)%10]++;
        }
        
        for(int i=1; i<10; ++i)
        {
            count[i] += count[i-1];
        }
        
        // Build the output character array 
        // To make it stable we are operating in reverse order. 
        for(int i=arr.length-1; i>=0; --i)
        {
            output[count[(arr[i]/exp)%10] - 1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        
        for(int i=0; i<arr.length; ++i)
        {
            arr[i] = output[i];
        }
        
    }
    
    public static void radixSort()
    {
        int max = getMax();
        for(int exp=1; max/exp > 0; exp*=10)
        {
            countingSort(exp);
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
        radixSort();
        printArray();
    }
    
}
