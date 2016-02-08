package implementación;

import tda.ColaPrioridadTDA;

/**
 * Created by gpaez on 08/02/2016.
 */
public class ColaPrioridadDA implements ColaPrioridadTDA {
    int[] elementos;
    int[] prioridades;
    int indice;

    @Override
    public void InicializarCola() {
        elementos = new int[100];
        prioridades = new int[100];
        indice = 0;
    }

    @Override
    public void AcolarPrioridad(int x, int prioridad) {

        int j=indice;

        for (; j >0 && prioridades[j-1]>= prioridad ; j--) {
            elementos[j] = elementos[j-1];
            prioridades[j] = prioridades[j-1];
        }

        elementos[j]=x;
        prioridades[j]=prioridad;
        indice++;
    }

    @Override
    public void Desacolar() {
        indice--;
    }

    @Override
    public int Primero() {
        return elementos[indice-1];
    }

    @Override
    public int Prioridad() {
        return prioridades[indice-1];
    }

    @Override
    public boolean ColaVacia() {
        return (indice==0);
    }
}
