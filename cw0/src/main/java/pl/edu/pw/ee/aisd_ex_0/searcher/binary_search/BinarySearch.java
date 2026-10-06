package pl.edu.pw.ee.aisd_ex_0.searcher.binary_search;

import pl.edu.pw.ee.aisd_ex_0.searcher.service.Searching;
import static java.util.Objects.isNull;

public class BinarySearch implements Searching {

    @Override
    public int search(int[] nums, int toFind) {
        if (isNull(nums)) throw new NullPointerException("Tablica nie może być nullem.");
        else if (nums.length == 0) return -1;
        int l = 0, m = 0;
        int p = nums.length - 1;
        while ( l <= p ) {
            m = l - (l - p) / 2;
            if (nums[m] < toFind) {
                l = m + 1;
            } else if (nums[m] > toFind) {
                p = m - 1;
            } else return m;
        }
        return -1;
    }

}
