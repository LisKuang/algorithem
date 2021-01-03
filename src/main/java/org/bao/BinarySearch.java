package org.bao;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearch {
    /**
     * 1.get the middle value
     * 2.compare the key with the value
     * 2.1 equal then end and return
     * 2.2 confirm the new array
     * 3 recurse
     * @param key target
     * @param arrs ordering array
     * @return index of key in array
     */
    public static int search(int key,int[] arrs, int from, int to){
        int midIndex=(to+from)/2;
        System.out.println("having the mid : "+arrs[midIndex]);

        if(arrs[midIndex]==key) {
            System.out.println("having the target : "+midIndex);
            return midIndex;
        }else if(arrs[midIndex]<key){
            return search(key, arrs,midIndex+1,to);
        }else if(arrs[midIndex]>key){
            return search(key, arrs,from,midIndex-1);
        }
        return 0;
    }

    public static void main(String[] args){
        int[] arrs=new int[]{2,12,22,32,37,44,50,55,66,77};
        int result=BinarySearch.search(55,arrs,0,arrs.length-1);
        System.out.println(result);
    }
}
