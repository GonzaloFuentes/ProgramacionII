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

        NodoValor aux = nc.valores;

        while (aux!= null && aux.valor!=valor){
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

    }

    @Override
    public void EliminarValor(int clave, int valor) {

    }

    @Override
    public ConjuntoTDA Recuperar(int clave) {
        return null;
    }

    @Override
    public ConjuntoTDA Claves() {
        return null;
    }

    public NodoClave Clave2NodoClave(int clave){
        NodoClave aux =origen;

        while (aux != null && aux.clave != clave){
            aux = aux.sigClave;
        }
        return aux;
    }


}
