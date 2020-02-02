package p325;

import java.util.*;

public class otrointen {

    public static String[] swap(String data[], int left, int right) 
    { 
        String temp = data[left]; 
        data[left] = data[right]; 
        data[right] = temp; 

        return data; 
    } 
  
    public static String[] reverse(String data[], int left, int right) 
    { 
        while (left < right) { 
            String temp = data[left]; 
            data[left++] = data[right]; 
            data[right--] = temp; 
        } 
  
        return data; 
    } 
    public static boolean findNextPermutation(String[] data) 
    { 
 
        if (data.length <= 1) 
            return false; 
  
        int last = data.length - 2; 
 
        while (last >= 0) { 
            if (data[last].compareTo(data[last + 1])<0 ) { 
                break; 
            } 
            last--; 
        } 

        if (last < 0) 
            return false; 
  
        int nextGreater = data.length - 1; 
  
        for (int i = data.length - 1; i > last; i--) { 
            if (data[i].compareTo(data[last])>0 ) { 
                nextGreater = i; 
                break; 
            } 
        } 
  
        data = swap(data, nextGreater, last); 
  
        data = reverse(data, last + 1, data.length - 1); 
  
        return true; 
    } 
   
    public static void main(String args[]) {
    	int casos;
		int bolasChoco;
		int bolasVainilla;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		casos = sc.nextInt();
        for (int i = 0; i < casos; i++) {
			bolasChoco=sc.nextInt();
			bolasVainilla= sc.nextInt();
			procesar(bolasChoco,bolasVainilla);	
	        System.out.println();
        }
    }
    private static void procesar(int choco,int vaini) {
    	String temp;
        int repeticion = choco + vaini;   //Tipos para escoger
		TreeSet<String> combina = new TreeSet<String>();	
		String[] perm = new String[repeticion];
			
		for (int i = 0; i < choco; i++) {
				perm[i] = "C";
		}
	    	
	    for (int j = choco; j < repeticion; j++) {
	    		perm[j] = "V";
		}
	    	
	    temp = Arrays.toString(perm);
        temp= temp.replace("[", "");
        temp= temp.replaceAll("]", "");
        temp= temp.replaceAll(" ", "");
        temp= temp.replaceAll(",", "");

        combina.add(temp);

        do {
        	temp = Arrays.toString(perm);
            temp= temp.replace("[", "");
        	temp= temp.replaceAll("]", "");
        	temp= temp.replaceAll(" ", "");
        	temp= temp.replaceAll(",", "");
        	
        	combina.add(temp);
        	
        }while(findNextPermutation(perm));
        
        Iterator<String> it = combina.iterator();
        int dimen = combina.size();
        
        for (int j = 0; j < dimen; j++) {
        	int temp2 = dimen -1;
        	
        	if (j==temp2) {
        		System.out.print(it.next());	
        	}else System.out.print(it.next() + " ");
		}
    }
} 