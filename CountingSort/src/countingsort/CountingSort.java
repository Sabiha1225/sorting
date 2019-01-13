/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingsort;

public class CountingSort {
 
    static int[] arr = {1, 4, 1, 2, 7, 5, 2, 32, 12, 4, 7, 9, 10, 9};
    static int[] output = new int[arr.length];
    static int[] count = new int[256];
    
    public static void countingSort()
    {
        for(int i=0; i<256; ++i)
        {
            count[i] = 0;
        }
        
        for(int i=0; i<arr.length; ++i)
        {
            count[arr[i]]++;
        }
        
        for(int i=1; i<256; ++i)
        {
            count[i] += count[i-1];
        }
        
        // Build the output character array 
        // To make it stable we are operating in reverse order. 
        for(int i=arr.length-1; i>=0; --i)
        {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
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
