
package NegativeElements;

public class CountingSortNegative {
    static int[] arr = {-5, -10, 0, -3, 8, 5, -1, 10, -1, -5, 9};
    static int[] output = new int[arr.length];
    static int[] count;
    
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
    
    public static int getMin()
    {
        int min = arr[0];
        for(int i=1; i<arr.length; ++i)
        {
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }
    
    public static void countingSort()
    {
        int max = getMax();
        int min = getMin();
        int range = max - min + 1;
        count = new int[range];
        
        for(int i=0; i<count.length; ++i)
        {
            count[i] = 0;
        }
        
        for(int i=0; i<arr.length; ++i)
        {
            count[arr[i]-min]++;
        }
        
        for(int i=1; i<count.length; ++i)
        {
            count[i] += count[i-1];
        }
        
        // Build the output character array 
        // To make it stable we are operating in reverse order. 
        for(int i=arr.length-1; i>=0; --i)
        {
            output[count[arr[i]-min] - 1] = arr[i];
            count[arr[i]-min]--;
        }
        
        for(int i=0; i<arr.length; ++i)
        {
            arr[i] = output[i];
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
        countingSort();
        printArray();
    }
}
