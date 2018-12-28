/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author Administrator
 */
public class MergeSort {

    public static void merge(int[] arr, int low, int mid, int high)
    {
        int n1 = mid - low + 1, n2 = high - mid; 
        int[] arr1 = new int[n1 + 1];
        int[] arr2 = new int[n2 + 1];
        
        for(int i=0; i<n1; ++i)
        {
            arr1[i] = arr[low+i];
        }
        
        for(int i=0; i<n2; ++i)
        {
            arr2[i] = arr[mid+1+i];
        }
        
        int i = 0, j = 0, k = low;
        while(i<n1 && j<n2)
        {
            if(arr1[i] < arr2[j])
            {
                arr[k] = arr1[i];
                k++;
                i++;
            }
            else
            {
                arr[k] = arr2[j];
                k++;
                j++;
            }
        }
        
        while(i<n1)
        {
            arr[k] = arr1[i];
            k++;
            i++;
        }
            
        while(j<n2)
        {
            arr[k] = arr2[j];
            k++;
            j++;
        }
    }
    
    public static void sort(int[] arr, int low, int high)
    {
        if(low < high)
        {
            int mid = (low + high) /2; 
            sort(arr, low, mid);
            sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    
    public static void print(int[] arr)
    {
        for(int i=0; i<arr.length; ++i)
        {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] arr = {39, 50, 2 , 13, 7, 23, 16, 1, 40, 2, 13, 39};
        
        print(arr);
        
        sort(arr, 0, arr.length - 1);
        
        print(arr);
    }
}
