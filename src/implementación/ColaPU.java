package implementación;

import tda.ColaTDA;

/**
 * Created by gpaez on 08/02/2016.
 */
public class ColaPU implements ColaTDA {
    int[] a;
    int indice;

    @Override
    public void InicializarCola() {
        a = new int[100];
        indice = 0;
    }

    @Override
    public void Acolar(int x) {
        for (int i = indice-1; i>=0; i--){
            a[i+1]=a[i];
        }
        a[0]=x;
        indice++;
    }

    @Override
    public void Desacolar() {
        indice--;
    }

    @Override
    public int Primero() {
        return a[indice-1];
    }

    @Override
    public boolean ColaVacia() {
        return (indice==0);
    }
}
