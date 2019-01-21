/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bucketsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    
    static double[] array = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434, 0.1234, 0.656, 0.222, 0.565};
    static int length = array.length;
    private static void bucketSort()
    {
        ArrayList<Double>[] list = new ArrayList[length];
        for(int i=0; i<length; ++i)
        {
            list[i] = new ArrayList<Double>();
        }
        
        for(int i=0; i<length; ++i)
        {
            int index = (int)Math.floor(length * array[i]);
            list[index].add(array[i]);
        }
        
        for(int i=0; i<length; ++i)
        {
            Collections.sort(list[i]);
        }
        
        int index = 0;
        for(int i=0; i<length; ++i)
        {
            for(int j=0; j<list[i].size(); ++j)
            {
                array[index++] = list[i].get(j);
            }
        }
    }
    
    private static void print()
    {
        /*for(int i=0; i<length; ++i)
        {
            System.out.print(array[i] + "  ");
        }*/
        System.out.println(Arrays.toString(array));
        
        //System.out.println();
    }
    public static void main(String[] args) {
        print();
        bucketSort();
        print();
    }
}
