package org.bao.component;

public class Utils {

    public static String printArray(int[] nums){
        StringBuffer sb=new StringBuffer();
        sb.append(nums[0]);
        for(int i=1;i<nums.length;i++){
            sb.append(",");
            sb.append(nums[i]);
        }
        return sb.toString();
    }
}
