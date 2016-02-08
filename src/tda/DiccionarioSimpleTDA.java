package tda;

/**
 * Created by gpaez on 08/02/2016.
 */
public interface DiccionarioSimpleTDA {
    void InicializarDiccionario();
    void Agregar(int clave, int valor);
    void Eliminar(int clave);
    int Recuperar(int clave);
    ConjuntoTDA claves();
}
