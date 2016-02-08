package tda;

/**
 * Created by gpaez on 08/02/2016.
 */
public interface ConjuntoTDA {
    void InicializarConjunto();
    boolean ConjuntoVacio();
    void Agregar(int x);
    void Sacar(int x);
    boolean Pertenece(int x);
    int Elegir();
}
