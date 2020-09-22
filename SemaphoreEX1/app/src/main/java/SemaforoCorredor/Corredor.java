package SemaforoCorredor;

import SemaforoCorredor.ThreadCorredor;
import java.util.concurrent.Semaphore;


public class Corredor {

public static Semaphore semaforo;

public static void main(){
	int pessoas = 4;
	int portas  = 1;
	
	semaforo = new Semaphore(portas);
	for (int i=0; i<= pessoas; i++){
		ThreadCorredor corredor = new ThreadCorredor(i,semaforo);
		corredor.start();
	}
}


}
