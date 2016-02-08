package tda;

/**
 * Created by gpaez on 08/02/2016.
 */
public interface ColaPrioridadTDA {
    void InicializarCola();
    void AcolarPrioridad(int x, int prioridad);
    void Desacolar();
    int Primero();
    int Prioridad();
    boolean ColaVacia();
}
