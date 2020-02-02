package p345;

import java.util.Scanner;

public class ver2 {
	public static void main(String[] args) {
		
		while(true) {
			procesos p = new procesos();
			
			p.cargarSudoku();
			
			//p.verificarSudokus();
		}
	}
}

class procesos {
	
	int nrosSudoku;
	private boolean [] numeros = new boolean [10];
	int [][] vector = new int [9][9];
	
	public void cargarSudoku() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		nrosSudoku = sc.nextInt();
		
		for(int j = 0;j<nrosSudoku;j++) {
			for (int i = 0; i < 9; i++) {
				for (int k = 0; k < 9; k++) {
					vector[i][k]=sc.nextInt();
				}
			}
			verificarSudokus();
		}
	}
	void iniciarNumeros() {
		for(int i = 0;i<numeros.length;i++) {
			numeros[i]=true;
		}
	}

	boolean verificarLineas(int[][] vector2) {
		boolean estado = true;
		for (byte p = 0; p < 9; p ++) {
			for (byte j = 0; j < 9; j ++) {
				if(numeros[Integer.parseInt(vector2[p][j]+"")-1]) {
					numeros[Integer.parseInt(vector2[p][j]+"")-1]=false;
				}else {
					estado = false;
					return false;
				}
			}
			iniciarNumeros();
		}
		return estado;
	}
	
	private boolean verificacionColumnas(int[][] vector2) {
		boolean estado = true;
		for (byte p = 0; p < 9; p ++) {
			for (byte j = 0; j < 9; j ++) {
				if(numeros[Integer.parseInt(vector2[j][p]+"")-1]) {
					numeros[Integer.parseInt(vector2[j][p]+"")-1]=false;
				}else {
					estado = false;
					return false;
				}
			}
			iniciarNumeros();
		}
		return estado;
	}
	
	void mostrarResultado(boolean estado) {
		System.out.println((estado) ? "SI" : "NO");
	}

	private boolean verificar3X3(int[][] vector2) {
		boolean estado=true;
		byte indicefila=0;
		byte indiceColumna=0;
		
		while ((indicefila<9)&&(indiceColumna<9)) {
			
			for(int i = indicefila;i<(indicefila+3);i++) {
				for (int j = indiceColumna; j < (indiceColumna+3); j++) {
					if(numeros[Integer.parseInt(vector2[i][j]+"")-1]) {
						numeros[Integer.parseInt(vector2[i][j]+"")-1]=false;
					}else {
						estado = false;
						return false;
					}
				}
			}
			iniciarNumeros();
			indiceColumna=(byte) (indiceColumna + 3);
			indicefila= (byte)(indicefila + 3);	
		}
		return estado;
	}
	
	public void verificarSudokus() {
		boolean estado = false;
		iniciarNumeros();
		
		estado = verificarLineas(vector);
		if(estado) {
			iniciarNumeros();
			estado = verificacionColumnas(vector);
			if(estado) {
				iniciarNumeros();
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
}
	
