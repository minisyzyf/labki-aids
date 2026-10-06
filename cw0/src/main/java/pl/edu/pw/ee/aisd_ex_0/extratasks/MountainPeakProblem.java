package pl.edu.pw.ee.aisd_ex_0.extratasks;

import static java.util.Objects.isNull;
/*

Dany jest całkowity ciąg liczb arr o długości n, w którym wartości rosną do elementu szczytowego, a następnie maleją.

Zwróć indeks elementu szczytowego.


Przykład 1:

Wejście: arr = [2, 5, 2]
Wyjście: 1

Przykład 2:

Wejście: arr = [0, 3, 2, 1]
Wyjście: 1

Przykład 3:

Wejście: arr = [0, 12, 7, 4]
Wyjście: 1

*/
public class MountainPeakProblem {

    public int peakIndexInMountainArray(int[] arr) {
        if ( isNull(arr) ) throw new NullPointerException("Tablica niezainicjowana.");
        if ( arr.length == 0 ) return -1;
        if ( arr.length == 1 ) return 0;
        int i = 0;
        while ( i < arr.length - 1 ) {
            if ( arr[i] < arr[i + 1]) i++;
            else return i;
        }
        return i;
    }
    
}
