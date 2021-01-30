package Principal;

import java.util.Scanner;

public class EjercicioTaller01 extends Thread{

	private int limiteSuperior;
	private boolean par;

	public EjercicioTaller01(int limiteSuperior, boolean par){
		System.out.println("Extendiendo la clase Thread");
		this.limiteSuperior = limiteSuperior;	
		this.par = par;
	}

	public void run(){

		try{
			if(par){
				for(int i = 1; i<=limiteSuperior; i++){
					if(i%2==0){
						System.out.println(i);
						Thread.sleep(50);
					}
				}
			}
			else{
				for(int i = 1; i<=limiteSuperior; i++){
					if(i%2!=0){
						System.out.println(i);
						Thread.sleep(50);
					}
				}


			}
		}
		catch (Exception e) {

		}

	}

	public static void main(String[] args){

		System.out.println("Ingrese el n�mero que ser� el l�mite superior: ");
		Scanner in = new Scanner(System.in); 		  
		String s = in.nextLine(); 
		int limiteSup = Integer.parseInt(s);

		EjercicioTaller01 t0 = new EjercicioTaller01(limiteSup, true);
		EjercicioTaller01 t1 = new EjercicioTaller01(limiteSup, false);

		t0.start();
		t1.start();

		in.close();

		//		el resultado evidentemente no nuestra los numeros en orden (aunque esto podria ocurrir), puesto 
		//		que como ambos threads se est�n ejecutando al tiempo y no de manera secuencial (como antes soliamos 
		//		trabajar) en algunos casos el numero par correspondiente se imprimir� primero y en otros casos ser� 
		//		al rev�s y el n�mero impar ser� el que primero se imprima.

	}

}
