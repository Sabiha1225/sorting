/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

/**
 *
 * @author Administrator
 */
public class SelectionSort {

    static int[] arr = {11, 25, 12, 22, 64, 3, 5, 11, 23, 26};
    
    public static void selectionSort()
    {
        for(int i=0; i<(arr.length-1); ++i)
        {
            int min = i;
            for(int j=i+1; j<arr.length; ++j)
            {
                if(arr[j] < arr[min])
                    min = j;
            }
            
            if(min != i)
            {
                int t = arr[i];
                arr[i] = arr[min];
                arr[min] = t;
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
        selectionSort();
        printArray();
    }
    
}
