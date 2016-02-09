package implementación;

import tda.ConjuntoTDA;
import tda.DiccionarioMultipleTDA;

/**
 * Created by gpaez on 08/02/2016.
 */
public class DiccionarioMultipleLD implements DiccionarioMultipleTDA {

    class NodoClave{
        int clave;
        NodoValor valores;
        NodoClave sigClave;
    }

    class NodoValor{
        int valor;
        NodoValor sigValor;
    }

    NodoClave origen;

    @Override
    public void InicializarDiccionario() {
        origen = null;
    }

    @Override
    public void Agregar(int clave, int valor) {
        NodoClave nc = this.Clave2NodoClave(clave);

        if(nc == null){
            nc = new NodoClave();
            nc.clave=clave;
            nc.sigClave=origen;
            origen=nc;
        }

        NodoValor aux=nc.valores;

        while (aux!=null && aux.valor!=valor){
            aux =aux.sigValor;
        }

        if(aux == null){
            NodoValor nv = new NodoValor();
            nv.valor=valor;
            nv.sigValor=nc.valores;
            nc.valores=nv;
        }
    }

    @Override
    public void Eliminar(int clave) {
        if (origen.clave==clave){
            origen = origen.sigClave;
        }
        else{
            NodoClave aux = origen;
            while (aux.sigClave != null && aux.sigClave.clave!=clave){
                aux = aux.sigClave;
            }
            if (aux.sigClave!=null){
                aux.sigClave = aux.sigClave.sigClave;
            }
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) {
        if (origen.clave==clave){
            this.EliminarValorEnNodo(origen,valor);
            if (origen.valores == null){
                origen = origen.sigClave;
            }
        }
        else{
            NodoClave aux = origen;

            while (aux.sigClave != null && aux.sigClave.clave != clave){
                aux = aux.sigClave;
            }
            if (aux.sigClave != null){
                EliminarValorEnNodo(aux.sigClave, valor);
                if (aux.sigClave.valores == null){
                    aux.sigClave = aux.sigClave.sigClave;
                }
            }
        }
    }

    private void EliminarValorEnNodo(NodoClave nodo, int valor){
        if (nodo.valores != null){
            if (nodo.valores.valor == valor){
                nodo.valores = nodo.valores.sigValor;
            }
            else{
                NodoValor aux = nodo.valores;
                while (aux.sigValor!=null && aux.sigValor.valor != valor){
                    aux = aux.sigValor;
                }
                if (aux.sigValor != null){
                    aux.sigValor = aux.sigValor.sigValor;
                }
            }
        }
    }

    @Override
    public ConjuntoTDA Recuperar(int clave) {
        NodoClave nodo = this.Clave2NodoClave(clave);
        ConjuntoTDA c = new ConjuntoLD();
        c.InicializarConjunto();

        if (nodo != null){
            NodoValor aux = nodo.valores;
            while(aux != null){
                c.Agregar(aux.valor);
                aux = aux.sigValor;
            }
        }
        return c;
    }

    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA claves = new ConjuntoLD();
        claves.InicializarConjunto();

        NodoClave aux = origen;
        while (aux != null) {
            claves.Agregar(aux.clave);
            aux = aux.sigClave;
        }
        return claves;
    }

    public NodoClave Clave2NodoClave(int clave){
        NodoClave aux =origen;

        while (aux != null && aux.clave != clave){
            aux = aux.sigClave;
        }
        return aux;
    }
}
