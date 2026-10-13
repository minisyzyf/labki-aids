import static java.util.Objects.isNull;

public class SelectionSort {

    public void ssort(double[] v, int n) {
        if(isNull(v)) throw new NullPointerException();
        int i, j, min;
        for(i=0; i < n; i++) {
            j = i;
            min = j;
            while(j < n) {
                if(v[j] < v[min]) {
                    min = j;
                }
                j++;
            }
            double tmp = v[i];
            v[i] = v[min];
            v[min] = tmp;
        }
    }
}
