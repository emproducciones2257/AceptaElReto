package p239;

import java.util.Scanner;

public class atropodos {

	public static void main(String[] args) {
		int casos;
		int insectos;
		int aracnidos;
		int crusta;
		int escolopendras;
		int anilloEscolopendras ;
		int totalPatas;
		Scanner sc = new Scanner(System.in);
		
		casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			insectos = sc.nextInt();
			aracnidos = sc.nextInt();
			crusta = sc.nextInt();
			escolopendras = sc.nextInt();
			anilloEscolopendras = sc.nextInt();
			totalPatas = insectos*6;
			totalPatas +=aracnidos*8;
			totalPatas +=crusta*10;
			totalPatas += escolopendras*(anilloEscolopendras*2);
			System.out.println(totalPatas);
			
		}
	}

}
