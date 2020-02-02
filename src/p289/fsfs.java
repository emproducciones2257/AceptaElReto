package p289;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Rubén Saiz
 */

class Esfuerzo implements Comparable<Esfuerzo> {

    long esfuerzo;

    public Esfuerzo(long e) {
        this.esfuerzo = e;
    }

    @Override
    public int compareTo(Esfuerzo o) {
        return (this.esfuerzo >= o.esfuerzo) ? 1 : -1;
    }

   
}

public class fsfs {

    public static void main(String[] args) {

        final Scanner s = new Scanner(System.in);
        PriorityQueue<Esfuerzo> listaPrioridad = new PriorityQueue<>();

        int n;
        long sum, res;

        while (true) {

            n = s.nextInt();
            if (n == 0) break;

            for (int i = 0; i < n; i++)
                listaPrioridad.add(new Esfuerzo(s.nextLong()));

            res = 0;
            if (n != 1) {
                while (!listaPrioridad.isEmpty()) {
                    sum = listaPrioridad.poll().esfuerzo + listaPrioridad.poll().esfuerzo;
                    if (!listaPrioridad.isEmpty())
                        listaPrioridad.add(new Esfuerzo(sum));
                    res += sum;
                }
            }

            System.out.println( res );
            listaPrioridad.clear();
        }

    }

}