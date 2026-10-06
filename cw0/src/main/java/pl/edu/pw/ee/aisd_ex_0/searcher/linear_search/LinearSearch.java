package pl.edu.pw.ee.aisd_ex_0.searcher.linear_search;

import pl.edu.pw.ee.aisd_ex_0.searcher.service.Searching;
import static java.util.Objects.isNull;

public class LinearSearch implements Searching {

    @Override
    public int search(int[] nums, int toFind) {
        if (isNull(nums)) throw new NullPointerException("Tablica nie może być nullem.");
        int i = 0;
        int n = nums.length;
        while ( i < n ) {
            if ( nums[i] == toFind ) {
                return i;
            }
            i++;
        }
        return -1;
    }

}
