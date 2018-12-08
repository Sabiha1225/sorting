/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IterativeQuickSort;

/**
 *
 * @author Administrator
 */
public class IterativeQuickSort {
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
        int[] stack = new int[high - low + 1];
        int top = -1;
        stack[++top] = low;
        stack[++top] = high;
        
        while(top >= 1)
        {
            high = stack[top--];
            low = stack[top--];
            int pivotIndex = partition(a, low, high);
            
            // If there are elements on left side of pivot, 
            // then push left side to stack 
            if(pivotIndex - 1 > low)
            {
                stack[++top] = low;
                stack[++top] = pivotIndex - 1;
            }
            
            // If there are elements on right side of pivot, 
            // then push right side to stack 
            if(pivotIndex + 1 < high)
            {
                stack[++top] = pivotIndex + 1;
                stack[++top] = high;
            }
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
        int a[] = {4, 3, 5, 2, 1, 3, 2, 3};
        int size = a.length, low = 0;
        IterativeQuickSort.sort(a, low, size-1);
        IterativeQuickSort.print(a, low, size-1);
    }
}
