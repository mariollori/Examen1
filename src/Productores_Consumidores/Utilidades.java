package Productores_Consumidores;

public class Utilidades {

	  public void esperarTiempoAzar(int max){
          /* Se calculan unos milisegundos al azar*/
          int msgs=(1+generador.nextInt(max))*1000;
          try {
                  Thread.currentThread().sleep(msgs);
          } catch (InterruptedException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
          }
  }
}
