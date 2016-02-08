package implementación;

import tda.ConjuntoTDA;

/**
 * Created by gpaez on 08/02/2016.
 */
public class ConjuntoTA implements ConjuntoTDA {

    int[] a;
    int cant;

    @Override
    public void InicializarConjunto() {
        a = new int[100];
        cant = 0;
    }

    @Override
    public boolean ConjuntoVacio() {
        return (cant ==0);
    }

    @Override
    public void Agregar(int x) {
        if(!this.Pertenece(x)) {
            a[cant] = x;
            cant++;
        }
    }

    @Override
    public void Sacar(int x) {
        int i = 0;

        while (i<cant && a[i]!=x){
            i++;
        }

        if(i<cant){
            a[i] = a[cant-1];
            cant--;
        }
    }

    @Override
    public boolean Pertenece(int x){
        int i = 0;
        while(i<cant && a[i]!=x){
            i++;
        }
        return (i<cant);
    }

    @Override
    public int Elegir() {
        return a[0];
    }
}
