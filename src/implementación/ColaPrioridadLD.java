package implementación;

import tda.ColaPrioridadTDA;

/**
 * Created by gpaez on 08/02/2016.
 */
public class ColaPrioridadLD implements ColaPrioridadTDA {

    class NodoPrioridad{
        int info;
        int prioridad;
        NodoPrioridad sig;
    }

    NodoPrioridad mayorPrioridad;

    @Override
    public void InicializarCola() {
        mayorPrioridad = null;
    }

    @Override
    public void AcolarPrioridad(int x, int prioridad) {
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.info=x;
        nuevo.prioridad=prioridad;

        if (mayorPrioridad == null || prioridad>mayorPrioridad.prioridad){
            nuevo.sig = mayorPrioridad;
            mayorPrioridad=nuevo;
        }
        else{
            NodoPrioridad aux =  mayorPrioridad;

            while (aux.sig!= null && aux.sig.prioridad>=prioridad){
                aux = aux.sig;
            }

            nuevo.sig=aux.sig;
            aux.sig= nuevo;
        }
    }

    @Override
    public void Desacolar() {
        mayorPrioridad = mayorPrioridad.sig;
    }

    @Override
    public int Primero() {
        return mayorPrioridad.info;
    }

    @Override
    public int Prioridad() {
        return mayorPrioridad.prioridad;
    }

    @Override
    public boolean ColaVacia() {
        return mayorPrioridad==null;
    }
}
