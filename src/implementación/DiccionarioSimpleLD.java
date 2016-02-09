package implementación;

import tda.ConjuntoTDA;
import tda.DiccionarioSimpleTDA;

/**
 * Created by gpaez on 08/02/2016.
 */
public class DiccionarioSimpleLD implements DiccionarioSimpleTDA{

    class NodoClave{
        int valor;
        int clave;
        NodoClave sigClave;
    }

    NodoClave origen;

    @Override
    public void InicializarDiccionario() {
        origen=null;
    }

    @Override
    public void Agregar(int clave, int valor) {
        NodoClave  nc = this.Clave2NodoClave(clave);

        if(nc == null){
            nc = new NodoClave();
            nc.clave=clave;
            nc.sigClave=origen;
            origen=nc;
        }
        nc.valor=valor;
    }

    @Override
    public void Eliminar(int clave) {
        if (origen.clave==clave){
            origen=origen.sigClave;
        }
        else{
            NodoClave aux = origen;

            while(aux.sigClave!=null && aux.sigClave.clave != clave){
                aux = aux.sigClave;
            }

            if(aux.sigClave != null){
                aux.sigClave = aux.sigClave.sigClave;
            }
        }
    }

    @Override
    public int Recuperar(int clave) {
        NodoClave nc = this.Clave2NodoClave(clave);
        return nc.valor;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new ConjuntoLD();
        claves.InicializarConjunto();

        NodoClave aux = origen;

        while(aux != null){
            claves.Agregar(aux.clave);
            aux = aux.sigClave;
        }
        return claves;
    }

    private NodoClave Clave2NodoClave(int clave){
        NodoClave aux = origen;
        while(aux.sigClave != null && aux.sigClave.clave != clave){
            aux = aux.sigClave;
        }
        return aux;
    }
}
