package SemaforoCorredor;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {
private int pessoa;



private Semaphore semaforo;

public ThreadCorredor(int num, Semaphore semaforo){
	this.pessoa = num;
	this.semaforo = semaforo;
}


@Override
public void run(){
	
	pessoaAnda();
	try {
		semaforo.acquire();
		pessoaPassa();
	}
	catch (InterruptedException e){
		e.printStackTrace();
	}
	finally {
		semaforo.release();
	}
}

private void pessoaAnda(){
	int distanciaPorta= 200;
	int velocidade = (int) ((Math.random()*3)+4);
	while (distanciaPorta>0){
		distanciaPorta-=velocidade;
		
		try{
			Thread.sleep(1000);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	System.out.println("#"+
		pessoa +
		"Chegou à porta"
	);
	
}


private void pessoaPassa(){
	
	int tempoPassagem = (int) (Math.random()+1*1000);
	try {
		Thread.sleep(tempoPassagem);
		System.out.println("#"+
			pessoa +
			" passou pela porta"
		);
	}
	catch(InterruptedException e){
		e.printStackTrace();
	}
	
	
}

}
