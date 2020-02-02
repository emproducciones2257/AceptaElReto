package p289;

import java.util.*;

public class loQueCuestaSumar {

	public static void main(String[] args) {
		long cantidadSumandos;
		PriorityQueue<Long> numeros = new PriorityQueue<>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		long suma;
		long esfuerzo;

		while (true) {		
			cantidadSumandos = sc.nextLong();
			
			if (cantidadSumandos==0) {
				break;
			}

			for (int i = 0; i < cantidadSumandos; i++) {
				numeros.add(sc.nextLong());
			}
			esfuerzo = 0;
			if (cantidadSumandos !=1) {
				while (!(numeros.isEmpty())) {
					suma = numeros.poll() + numeros.poll();
					if (!(numeros.isEmpty())) {
						numeros.add(suma);
					}
					esfuerzo += suma;
				}
				numeros.clear();
				}
			System.out.println(esfuerzo);
			numeros.clear();
		}
	}
}