package io.github.seekerlee.algopieces;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: seeker
 * Date: 7/7/13
 * Time: 10:06 PM
 */
public class MergeSortUnitTest {
    private static MergeSort ms;
    @Before
    public void setUp() throws Exception {

        InputStream in = MergeSortUnitTest.class.getClassLoader().getResourceAsStream("IntegerArray.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String line;
        int[] input = new int[100000];
        int index = 0;
        while ((line = br.readLine()) != null) {
            input[index] = Integer.valueOf(line);
            index ++;
        }
        br.close();
        System.out.println("init and sorting...");
        long time0 = System.currentTimeMillis();
        ms = new MergeSort(input);
        long time1 = System.currentTimeMillis();
        System.out.println("done in " + (time1 - time0) + " millisecond.");
        //System.out.println(Arrays.toString(ms.getArr()));
    }

    @Test
    public void InversionCorrect(){
        assertEquals(ms.getInversions(), 2407905288L);
    }

    @Test
    public void SortedCorrect(){
        int[] arr = ms.getArr();
        for(int i = 0; i < arr.length - 1; i++){
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }
}
