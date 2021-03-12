package org.bao;

import org.junit.Test;

public class TestRoundSix {

    private RoundSix rs=new RoundSix();

    @Test
    public void singleNumberTest(){
        System.out.println("a ox b:"+(117^66));
        rs.singleNumber(new int[]{1,3,4,3,1});
    }
}
