/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThreeWayQuickSort;

/**
 *
 * @author Administrator
 */
public class ThreeWayQuickSort {
    static int tempLow = 0, tempHigh = 0;
    public static void partition(int a[], int low, int high)
    {
        if(high - low <= 1)
        {
            if(a[high] < a[low])
            {
                int t = a[high];
                a[high] = a[low];
                a[low] = t;
            }
            tempLow = low;
            tempHigh = high;
            return;
        }
        int pivot = a[high];
        int i = low;
        int j = low;
        while(j<= high)
        {
            if(a[j] < pivot)
            {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j++;
            }
            else if(a[j] == pivot) j++;
            else if(a[j] > pivot)
            {
                int t = a[j];
                a[j] = a[high];
                a[high] = t;
                high--;
            }
        }
        tempLow = i-1;
        tempHigh = j;
    }
    
    public static void sort(int a[], int low, int high)
    {
        if(low < high)
        {
            partition(a, low, high);
            sort(a, low, tempLow);
            sort(a, tempHigh, high);
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
        int a[] = {4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4};
        int size = a.length, low = 0;
        ThreeWayQuickSort.print(a, low, size-1);
        ThreeWayQuickSort.sort(a, low, size-1);
        ThreeWayQuickSort.print(a, low, size-1);
    }
}
