import static java.util.Objects.isNull;

public class QuickSort {

    public int rodziel(double[] v, int p, int k) {
        int i = p + 1, j = k;
        while(i < j) {
            while(i < j && v[i] <= v[p]) {
                i++;
            }
            while(i < j && v[j] > v[p]) {
                j--;
            }
            if(i != j) {
                double tmp = v[i];
                v[i] = v[j];
                v[j] = tmp;
            }
        }
        if(v[i] > v[p]) {
            i--;
        }
        double tmp = v[i];
        v[i] = v[p];
        v[p] = tmp;
        return i;
    }

    public void qsortRek(double[] v, int p, int k) {
        if(p < k) {
            int s = rodziel(v, p, k);
            qsortRek(v, p, s - 1);
            qsortRek(v, s + 1, k);
        }
    }

    public void qsort(double[] v, int n) {
        if(isNull(v)) throw new NullPointerException();
        qsortRek(v, 0, n - 1);
    }
}
