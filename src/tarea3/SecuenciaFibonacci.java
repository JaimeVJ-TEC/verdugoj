package tarea3;

public class SecuenciaFibonacci {
    
    public static void main(String[] args) {
        int limite = 0;
        int valor1 = 0;
        int valor2 = 1;
        int a = 0;

        do{
            valor1 = valor2;
            valor2 = a; 
            a = valor2 + valor1;
            System.out.println(a);

            limite++;
        }while(limite < 10);
    }
}