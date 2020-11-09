package com.chunppo.streams;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsTest {
    int[] arange = new int[40];
    int[] myBingo = new int[20];

    List<List<Integer>> myCount = new ArrayList<>();

    @Before
    public void init() {
        for (int i = 1; i < 40; i++) {
            int r = i;
            if (i > 30 && i < 40) {
                r = i - 20;
            }
            arange[i - 1] = r;
        }
    }
    @Test
    public void steams() {
        arange = shuffle(arange);
        for (int i : arange)
            System.out.print(i + ",");

        System.out.println("\nR : " + arange[0]);

        myBingo = Arrays.copyOf(arange, 20);


        List<Integer> aa = new ArrayList<>();
        for (int i = 0; i < arange.length; i++) {
            int z = i + 1;
            if (z >= arange.length) break;

            if (arange[z] == 0) {
                System.out.println(arange[i] + " -> " + arange[z]);
                i++;
                z++;
            }
            if (arange[z] > arange[i]) {
                System.out.println(arange[i] + " -> " + arange[z]);
            } else {
                System.out.println("Empty");
            }
        }


//        System.out.println(myCount);
    }

    private static int execute() {
        return 0;
    }

    // 배열섞기
    private static int[] shuffle(int[] numberList) {
        for (int i = 0; i < numberList.length; i++) {
            int a = (int) (Math.random() * numberList.length);
            int tmp = numberList[a];
            numberList[a] = numberList[i];
            numberList[i] = tmp;
        }

        return numberList;
    }

}
