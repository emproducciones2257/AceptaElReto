package p345;

import java.util.Scanner;

public class version3 {
	
	static boolean verificarLineas(int[][] vector) {
		 boolean [] numeros = new boolean [9];
		boolean estado = false;
		for (byte p = 0; p < 9; p ++) {
			for (byte j = 0; j < 9; j ++) {
				if(!(numeros[Integer.parseInt(vector[p][j]+"")-1])) {
					numeros[Integer.parseInt(vector[p][j]+"")-1]=true;
				}else {
					estado = true;
					return true;
				}
			}
			numeros = new boolean [9];
		}
		return estado;
	}
	
	private static boolean verificacionColumnas(int[][] vector) {
		boolean [] numeros = new boolean [9];
		boolean estado = false;
		for (byte p = 0; p < 9; p ++) {
			for (byte j = 0; j < 9; j ++) {
				if(!(numeros[Integer.parseInt(vector[j][p]+"")-1])) {
					numeros[Integer.parseInt(vector[j][p]+"")-1]=true;
				}else {
					estado = true;
					return true;
				}
			}
			numeros = new boolean [9];
		}
		return estado;
	}
	
	static void mostrarResultado(boolean estado) {
		System.out.println((estado) ? "NO" : "SI");
	}

	private static boolean verificar3X3(int[][] vector) {
		boolean estado=false;
		byte indicefila=0;
		byte indiceColumna=0;
		boolean [] numeros = new boolean [9];
		while ((indicefila<9)&&(indiceColumna<9)) {
			
			for(int i = indicefila;i<(indicefila+3);i++) {
				for (int j = indiceColumna; j < (indiceColumna+3); j++) {
					if(!(numeros[Integer.parseInt(vector[i][j]+"")-1])) {
						numeros[Integer.parseInt(vector[i][j]+"")-1]=true;
					}else {
						estado = true;
						return true;
					}
				}
			}
			numeros = new boolean [9];
			indiceColumna=(byte) (indiceColumna + 3);
			indicefila= (byte)(indicefila + 3);	
		}
		return estado;
	}
	
	public static void verificarSudokus(int [][] vector) {
		boolean estado = false;
		
		estado = verificarLineas(vector);
		if(!(estado)){
			estado = verificacionColumnas(vector);
			if(!(estado)) {
				estado=verificar3X3(vector);
				mostrarResultado(estado);
			}else {
				mostrarResultado(estado);
				}
			}
			else {
			mostrarResultado(estado);
			}
		}

	public static void main(String[] args) {
		int casos;
		int [][] vector = new int [9][9];
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		casos = sc.nextInt();
		
		for(int i= 0; i<casos;i++) {
			
			for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++) {
                	 vector[j][k] = sc.nextInt();
                }  
			}
			verificarSudokus(vector);
		}
	}
}
