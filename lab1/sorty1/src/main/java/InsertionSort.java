import static java.util.Objects.isNull;

public class InsertionSort {
    public void insort(double[] v, int n) {
        if(isNull(v)) throw new NullPointerException();
        int i, j;
        for(i = 1; i < n; i++) {
            double tmp = v[i];
            j = i;
            while(j > 0 && v[j-1] > tmp) {
                v[j] = v[j-1];
                j--;
            }
            v[j] = tmp;
        }
    }
}
