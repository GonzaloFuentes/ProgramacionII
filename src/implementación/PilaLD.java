package implementación;

import tda.PilaTDA;

/**
 * Created by gpaez on 08/02/2016.
 */
public class PilaLD implements PilaTDA {
    Nodo primero;

    @Override
    public void InicializarPila() {
        primero = null;
    }

    @Override
    public void Apilar(int x) {
        Nodo aux = new Nodo();
        aux.info=x;
        aux.sig=primero;
        primero=aux;
    }

    @Override
    public void Desapilar() {
        primero = primero.sig;
    }

    @Override
    public int Tope() {
        return primero.info;
    }

    @Override
    public boolean PilaVacia() {
        return primero==null;
    }
}
