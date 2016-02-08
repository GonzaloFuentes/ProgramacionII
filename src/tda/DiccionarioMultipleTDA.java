package tda;

/**
 * Created by gpaez on 08/02/2016.
 */
public interface DiccionarioMultipleTDA {
    void InicializarDiccionario();
    void Agregar(int clave, int valor);
    void Eliminar(int clave);
    void EliminarValor(int clave, int valor);
    ConjuntoTDA Recuperar(int clave);
    ConjuntoTDA Claves();
}
