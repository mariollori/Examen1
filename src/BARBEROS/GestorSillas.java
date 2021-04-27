package BARBEROS;

public class GestorSillas {
    private int MAX_SILLAS;
    private boolean[] estaSillaLibre;
    private boolean[] clienteEstaAtendido;
    private int siguienteClienteParaAtender=0;
    GestorSillas(int num){
            MAX_SILLAS=num;
            estaSillaLibre=new boolean[MAX_SILLAS];
            clienteEstaAtendido=new boolean[MAX_SILLAS];
            for (int i=0; i<MAX_SILLAS; i++){
                    estaSillaLibre[i]       = true;
                    clienteEstaAtendido[i]  = false;
            }
    }
    /**
     * Nos dice el numero de silla que est� libre
     * @return Devuelve una posici�n o -1 si est�
     * todo ocupado
     */
    public synchronized int getPosSillaLibre(){
            int posSilla=-1;
            for (int pos=0; pos<MAX_SILLAS;pos++){
                    if (estaSillaLibre[pos]==true){
                            estaSillaLibre[pos]=false;
                            return pos;
                    }
            }
            return posSilla;
    }

    public void liberarSilla(int pos){
            estaSillaLibre[pos]=true;
            clienteEstaAtendido[pos]=false;
    }
    public synchronized int getSiguienteCliente(){
            int pos=-1;
            boolean salir;
            int i;
            salir=false;
            i=this.siguienteClienteParaAtender;
            while(!salir){
                    if (
                                    (this.estaSillaLibre[i]==false) &&
                                    (this.clienteEstaAtendido[i]==false)
                    )
                    {
                            this.clienteEstaAtendido[i]=true;
                            this.siguienteClienteParaAtender= (i+1) % MAX_SILLAS;
                            return i;

                    }
                    i++;
                    if (i==this.MAX_SILLAS){
                            i=0;
                    }
                    if (i==this.siguienteClienteParaAtender) salir=true;

            }

            return pos;
    }
}