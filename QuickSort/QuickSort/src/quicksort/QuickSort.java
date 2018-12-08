/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 *
 * @author Administrator
 */
public class QuickSort {

    /**
     * @param args the command line arguments
     */
    public static int partition(int a[], int low, int high)
    {
        int pivot = a[high];
        int i = low-1;
        for(int j=low; j<high; ++j)
        {
            if(a[j] <= pivot)
            {
                i++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        
        int t = a[i+1];
        a[i+1] = a[high];
        a[high] = t;
        
        return i+1;
    }
    
    public static void sort(int a[], int low, int high)
    {
        if(low<high)
        {
            int pivotIndex = partition(a, low, high);
            sort(a, low, pivotIndex-1);
            sort(a, pivotIndex+1, high);
        }
    }
    
    public static void print(int a[], int low, int high)
    {
        for(int i=low; i<= high; ++i)
        {
            System.out.print(a[i] + "  ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int a[] = {10, 7, 8, 9, 1, 5};
        int size = a.length, low = 0;
        QuickSort.sort(a, low, size-1);
        QuickSort.print(a, low, size-1);
    }  
}
