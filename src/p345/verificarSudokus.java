package p345;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class verificarSudokus {
	
	public static void main(String[] args) {

		proceso p = new proceso();
		
		p.cargarSudokus();
		
		p.verificarSudokus();
	}
}

class proceso {
	String nrosSudoku;
	private ArrayList<char [][]> casos = new ArrayList<>();
	private int indice = 0;
	private boolean [] numeros = new boolean [10];
	
	void cargarSudokus () {
		try {
			Scanner archivo = new Scanner(new File("C:\\aceptaeldesafio\\sample345\\sample.in"));
			while (archivo.hasNext()) {
				String linea = archivo.nextLine();
				if(procesarLinea(linea)==1) {
					nrosSudoku = archivo.nextLine();
					for(int i = 1;i<9;i++) {
						nrosSudoku = nrosSudoku + archivo.nextLine();	
					}
					cargarSudoku(nrosSudoku);
				}	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cargarSudoku(String nros) {
		char [][] sudoku = new char [9][9];
		byte contador = 0;
		byte total = 0;
		byte indiceMatriz=0;
		String sudoSinEspacios = nros.replace(" ", "");
		
		while (total<81) {
			while (contador<9) {
				sudoku[indiceMatriz][contador]=sudoSinEspacios.charAt(total);
				contador++;
				total++;
			}
			contador=0;
			indiceMatriz++;
		}
	
		casos.add(indice,sudoku);
		indice++;
	}
	
	private int procesarLinea(String linea) {
		int contador = 0;
		contador += linea.split("\\s+").length;
		return contador;
	}
	
	void iniciarNumeros() {
		for(int i = 0;i<numeros.length;i++) {
			numeros[i]=true;
		}
	}

	boolean verificarLineas(char[][] cs) {
		boolean estado = true;
		for (byte p = 0; p < 9; p ++) {
			for (byte j = 0; j < 9; j ++) {
				if(numeros[Integer.parseInt(cs[p][j]+"")-1]) {
					numeros[Integer.parseInt(cs[p][j]+"")-1]=false;
				}else {
					estado = false;
					return false;
				}
			}
			iniciarNumeros();
		}
		return estado;
	}
	
	private boolean verificacionColumnas(char[][] cs) {
		boolean estado = true;
		for (byte p = 0; p < 9; p ++) {
			for (byte j = 0; j < 9; j ++) {
				if(numeros[Integer.parseInt(cs[j][p]+"")-1]) {
					numeros[Integer.parseInt(cs[j][p]+"")-1]=false;
				}else {
					estado = false;
					return false;
				}
			}
			iniciarNumeros();
		}
		return estado;
	}
	
	void mostrarResultado(boolean estado, int cantidad) {
		if(estado) System.out.println("SI");
		else  System.out.println("NO");
	}

	private boolean verificar3X3(char[][] cs) {
		boolean estado=true;
		byte indicefila=0;
		byte indiceColumna=0;
		
		while ((indicefila<9)&&(indiceColumna<9)) {
			
			for(int i = indicefila;i<(indicefila+3);i++) {
				for (int j = indiceColumna; j < (indiceColumna+3); j++) {
					if(numeros[Integer.parseInt(cs[i][j]+"")-1]) {
						numeros[Integer.parseInt(cs[i][j]+"")-1]=false;
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
		byte cantidad = 0;
		
		for (char[][] cs : casos) {
			cantidad++;
			estado = verificarLineas(cs);
			if(estado) {
				iniciarNumeros();
				estado = verificacionColumnas(cs);
				}
			else {
				mostrarResultado(estado, cantidad);
				break;
			}
			
			if(estado) {
				iniciarNumeros();
				estado=verificar3X3(cs);
				mostrarResultado(estado, cantidad);
			}else {
				mostrarResultado(estado, cantidad);
			}
		}	
	}
}