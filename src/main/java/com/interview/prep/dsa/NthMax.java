package com.interview.prep.dsa;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * DSA-01 — Find the Nth maximum (distinct) number in an array.
 * n = 1 returns the maximum, n = 2 the second maximum, and so on.
 *
 * Approach: TreeSet auto-sorts and de-duplicates; walk it in descending order.
 * Complexity: O(m log m) time, O(m) space (m = number of elements).
 */
public class NthMax {

    public static int nthMax(int[] a, int n) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("array is empty");
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int x : a) {
            set.add(x);
        }
        if (n < 1 || n > set.size()) {
            throw new IllegalArgumentException("n out of range: " + n);
        }
        Iterator<Integer> it = set.descendingIterator();
        int val = 0;
        for (int i = 0; i < n; i++) {
            val = it.next();
        }
        return val;
    }

    /** Single-pass second maximum — the common O(n) follow-up. */
    public static int secondLargest(int[] a) {
        long max = Long.MIN_VALUE, second = Long.MIN_VALUE;
        for (int x : a) {
            if (x > max) {
                second = max;
                max = x;
            } else if (x < max && x > second) {
                second = x;
            }
        }
        if (second == Long.MIN_VALUE) {
            throw new IllegalStateException("no distinct second largest");
        }
        return (int) second;
    }

    public static void main(String[] args) {
        System.out.println(nthMax(new int[]{4, 2, 9, 9, 7, 1}, 2)); // 7
        System.out.println(secondLargest(new int[]{4, 2, 9, 9, 7, 1})); // 7
    }
}
