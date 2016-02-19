package tda;

/**
 * Created by gpaez on 13/02/2016.
 */
public interface ABBTDA {
    void InicializarArbol();
    int Raiz();
    ABBTDA HijoDer();
    ABBTDA HijoIzq();
    boolean ArbolVacio();
    void AgregarElemento(int x);
    void EliminarElemento(int x);
}
