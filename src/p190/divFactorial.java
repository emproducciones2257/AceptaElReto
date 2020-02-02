package p190;

import java.math.BigInteger;
import java.util.Scanner;

public class divFactorial {

	public static void main(String[] args) {
		BigInteger numerador, denominador;
		int comparacion;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		numerador=sc.nextBigInteger();
		denominador=sc.nextBigInteger();
		
		comparacion = numerador.compareTo(denominador);
		
		while ((comparacion==1)||(comparacion==0)) {
			
			if(numerador.equals(denominador)){
				
				System.out.println(1);
				numerador=sc.nextBigInteger();
				denominador=sc.nextBigInteger();
				comparacion = numerador.compareTo(denominador);
			}else {
				
				System.out.println(calculaFactorial(denominador, numerador));
				numerador=sc.nextBigInteger();
				denominador=sc.nextBigInteger();
				
				comparacion = numerador.compareTo(denominador);
			}
		}
	}
	
	public static BigInteger calculaFactorial(BigInteger denominador, BigInteger numerador ) {
		
		denominador= denominador.add(BigInteger.valueOf(1));
		
		BigInteger resultado = denominador;
		
		if (resultado.equals(numerador)) {
						
			return numerador;
			
		}else {
			
			denominador= denominador.add(BigInteger.valueOf(1));
			
			resultado = resultado.multiply(denominador);
			
			denominador= denominador.add(BigInteger.valueOf(1));
			
			for (int i = denominador.intValue() ; i < numerador.intValue()+1; i++) {
				
				resultado = resultado.multiply(BigInteger.valueOf(i));
			}
		}
		return resultado;
	}
}
