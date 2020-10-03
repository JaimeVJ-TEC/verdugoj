package tarea4;

public class SecuenciaFibonacci {
	
	public int[] CalcularSecuencia(int valor1, int valor2, int limite) {
		
		int[] secuencia = new int[limite];
		
		int a = 0, i = 0;

        do{
            valor1 = valor2;
            valor2 = a; 
            a = valor2 + valor1;
            secuencia[i] = a;

            i++;
        }while(i < limite);
        
        return secuencia;
	}

}