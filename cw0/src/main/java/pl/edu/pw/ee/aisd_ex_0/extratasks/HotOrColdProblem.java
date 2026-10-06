package pl.edu.pw.ee.aisd_ex_0.extratasks;

import java.util.Random;

/*
Wybieram liczbę od 1 do n. Musisz zgadnąć, którą liczbę wybrałem.
Za każdym razem, gdy zgadniesz błędnie, powiem ci, czy liczba, którą wybrałem, jest większa (zwraca 1) czy mniejsza (zwracam -1) od Twojego zgadnięcia.
Wywołujesz wcześniej zdefiniowane API int guess(int num).
*/

public class HotOrColdProblem {
    private int secretNum;

    // konstruktor dla testów jednostkowych
    public HotOrColdProblem(int n) {
        secretNum = n;
    }

    public int guessNumber(int n) {
        int m = 0, l = 1;
        int p = n;
        while ( l <= p) {
            m = l - (l - p) / 2;
            if ( guess(m) > 0 ) {
                l = m + 1;
            } else if ( guess(m) < 0 ) {
                p = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    private int guess(int num) {
        if (num == secretNum) {
            return 0;
        } else if (num < secretNum) {
            return 1;
        } else {
            return -1;
        }
    }
}
