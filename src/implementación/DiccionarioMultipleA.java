package implementación;

import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

/**
 * Created by gpaez on 08/02/2016.
 */
public class DiccionarioMultipleA implements DiccionarioMultipleTDA {

    class Elemento{
        int clave;
        int[] valores;
        int cantValores;
    }

    Elemento[] elementos;
    int cantClaves;

    @Override
    public void InicializarDiccionario() {
        elementos = new Elemento[100];
        cantClaves=0;
    }

    @Override
    public void Agregar(int clave, int valor) {
        int posC = this.Clave2Indice(clave);

        if (posC==-1){
            posC=cantClaves;
            elementos[posC]= new Elemento();
            elementos[posC].clave=clave;
            elementos[posC].cantValores=0;
            elementos[posC].valores = new int[100];
            cantClaves++;
        }

        Elemento e = elementos[posC];
        int posV = this.Valor2indice(e,valor);

        if(posV == -1){
            e.valores[e.cantValores] = valor;
            e.cantValores++;
        }

    }

    @Override
    public void Eliminar(int clave) {
        int pos = this.Clave2Indice(clave);

        if (pos!=-1){
            elementos[pos]=elementos[cantClaves];
            cantClaves--;
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) {
        int posC = this.Clave2Indice(clave);

        if (posC != -1){
            Elemento e = elementos[posC];
            int posV = this.Valor2indice(e,valor);

            if (posV!=-1){
                e.valores[posV]=e.valores[e.cantValores-1];
                e.cantValores--;
                if (e.cantValores==0){
                    this.Eliminar(clave);
                }
            }
        }
    }

    @Override
    public ConjuntoTDA Recuperar(int clave) {
        ConjuntoTDA c = new ConjuntoTA();
        c.InicializarConjunto();

        int pos = this.Clave2Indice(clave);
        if (pos!=-1){
            Elemento e = elementos[pos];
            for (int i = 0; i <e.cantValores ; i++) {
                c.Agregar(e.valores[i]);
            }
        }
        return c;
    }

    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA claves = new ConjuntoTA();
        claves.InicializarConjunto();

        for (int i = 0; i < cantClaves ; i++) {
            claves.Agregar(elementos[i].clave);
        }

        return claves;
    }

    private int Clave2Indice(int clave){
        int i = cantClaves-1;
        while(i>=0 && elementos[i].clave!=clave){
            i++;
        }
        return i;
    }

    private int Valor2indice(Elemento e, int valor){
        int i = e.cantValores-1;
        while(i>=0 && e.valores[i]!=valor){
            i--;
        }
        return i;
    }
}
