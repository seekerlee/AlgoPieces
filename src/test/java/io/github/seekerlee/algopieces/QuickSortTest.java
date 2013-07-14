package io.github.seekerlee.algopieces;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertTrue;

/**
 * User: seeker
 * Date: 7/14/13
 * Time: 11:01 AM
 */
public class QuickSortTest {
    public static QuickSort sort;
    @Before
    public void setUp() throws Exception {
        InputStream in = MergeSortUnitTest.class.getClassLoader().getResourceAsStream("QuickSort.txt");
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(isr);
        String line;
        int[] input = new int[10000];
        int index = 0;
        while ((line = br.readLine()) != null) {
            input[index] = Integer.valueOf(line);
            index ++;
        }
        br.close();
        System.out.println("init and sorting...");
        long time0 = System.currentTimeMillis();
        sort = new QuickSort(input);
        long time1 = System.currentTimeMillis();
        System.out.println("done in " + (time1 - time0) + " millisecond.");
    }

    @Test
    public void SortedCorrect() {
        int[] arr = sort.getArr();
        for(int i = 0; i < arr.length - 1; i++){
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @Test
    public void testCount() {
        System.out.println(sort.getComparison_count());
        assertTrue(sort.getComparison_count() == 164123);
    }
}
