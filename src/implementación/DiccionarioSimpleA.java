package implementación;

import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;

/**
 * Created by gpaez on 08/02/2016.
 */
public class DiccionarioSimpleA implements DiccionarioSimpleTDA {

    class Elemento{
        int clave;
        int valor;
    }

    Elemento[] elementos;
    int cant;

    @Override
    public void InicializarDiccionario() {
        elementos = new Elemento[100];
        cant = 0;
    }


    @Override
    public void Agregar(int clave, int valor) {
        int pos=this.Clave2Indice(clave);

        if(pos==-1){
            pos=cant;
            elementos[pos]= new Elemento();
            elementos[pos].clave=clave;
            cant++;
        }
        elementos[pos].valor=valor;
    }

    @Override
    public void Eliminar(int clave) {
        int pos = this.Clave2Indice(clave);

        if (pos!=-1){
            elementos[pos]= elementos[cant-1];
            cant--;
        }
    }

    @Override
    public int Recuperar(int clave) {
        int pos = this.Clave2Indice(clave);
        return elementos[pos].valor;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new ConjuntoTA();
        claves.InicializarConjunto();

        for (int i = 0; i < cant ; i++) {
            claves.Agregar(elementos[i].clave);
        }

        return  claves;
    }

    private int Clave2Indice(int clave){
        int i=cant-1;
        while(i>=0 && elementos[i].clave!= clave)
             i--;
        return i;
    }
}
