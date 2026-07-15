package com.interview.prep.dsa;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/** Tests for DSA-01. Mirrors the hidden-test edge cases graders use. */
public class NthMaxTest {

    @DataProvider(name = "cases")
    public Object[][] cases() {
        return new Object[][]{
                {new int[]{4, 2, 9, 9, 7, 1}, 1, 9},
                {new int[]{4, 2, 9, 9, 7, 1}, 2, 7},
                {new int[]{4, 2, 9, 9, 7, 1}, 3, 4},
                {new int[]{5, 5, 5, 3}, 2, 3},
                {new int[]{-1, -5, -3}, 1, -1},
        };
    }

    @Test(dataProvider = "cases")
    public void returnsNthDistinctMax(int[] arr, int n, int expected) {
        Assert.assertEquals(NthMax.nthMax(arr, n), expected);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void throwsOnEmptyArray() {
        NthMax.nthMax(new int[]{}, 1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void throwsWhenNExceedsDistinctCount() {
        NthMax.nthMax(new int[]{1, 1, 2}, 3); // only 2 distinct values
    }

    @Test
    public void singlePassSecondLargest() {
        Assert.assertEquals(NthMax.secondLargest(new int[]{4, 2, 9, 9, 7, 1}), 7);
    }
}
