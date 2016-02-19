package ejerciciosGuiaCatedra;

import implementación.ConjuntoLD;
import tda.ConjuntoTDA;

/**
 * Created by gpaez on 13/02/2016.
 */
public class ProblemasConjuntoTDA {
    /** TP 3 Guia de Ejercicios
     * 3) A partir del TDA Conjunto, escribir distintos métodos externos que permitan

     b) Sin utilizar las operaciones unión, intersección y diferencia.
     c) Utilizando las operaciones unión, intersección y diferencia.

     e) Calcular la cardinalidad (cantidad de elementos) de un conjunto.
     f) Generar el conjunto de elementos que están tanto en la Pila P y en la Cola C.
     g) Determinar si los elementos de una Pila P son los mismos que los de una Cola
     C. No interesa el orden ni si están repetidos o no.*/

    //a) Calcular la diferencia simétrica entre dos conjuntos A y B (definido en clase).
    public  static ConjuntoTDA DiferenciaSimetrica(ConjuntoTDA c1, ConjuntoTDA c2){
        ConjuntoTDA diferencia = new ConjuntoLD();
        diferencia.InicializarConjunto();

        while (!c1.ConjuntoVacio()){
            int elem = c1.Elegir();

            if (!c2.Pertenece(elem)){
                diferencia.Agregar(elem);
            }
            else{
                c2.Sacar(elem);
            }
            c1.Sacar(elem);
        }

        while (!c2.ConjuntoVacio()){
            int elem = c2.Elegir();
            diferencia.Agregar(elem);
            c2.Sacar(elem);
        }

        return diferencia;
    }

    //d) Determinar si dos conjuntos son iguales.

    public static boolean ConjuntosIguales(ConjuntoTDA c1, ConjuntoTDA c2){
        boolean sonIguales = true;

        while (!c1.ConjuntoVacio() && sonIguales){
            int elem = c1.Elegir();

            if(!c2.Pertenece(elem)){
                sonIguales = false;
            }
            else{
                c1.Sacar(elem);
                c2.Sacar(elem);
            }
        }

        return (sonIguales && c1.ConjuntoVacio() && c2.ConjuntoVacio());
    }

    public static void main(String[] args) {

        //PRUEBLO DIFERENCIA
        ConjuntoTDA c1 = new ConjuntoLD();
        ConjuntoTDA c2 = new ConjuntoLD();
        ConjuntoTDA diferencia = new ConjuntoLD();

        c1.InicializarConjunto();
        c2.InicializarConjunto();
        diferencia.InicializarConjunto();

        c1.Agregar(1);
        c1.Agregar(2);
        c1.Agregar(3);

        c2.Agregar(3);
        c2.Agregar(4);
        c2.Agregar(5);

        diferencia = DiferenciaSimetrica(c1,c2);
        while (!diferencia.ConjuntoVacio()){
            int elem = diferencia.Elegir();
            System.out.println("Elemento:" + elem);
            diferencia.Sacar(elem);
        }

        // CONJUNTOS IGUALES
        c1.Agregar(1);
        c1.Agregar(2);
        c1.Agregar(3);

        c2.Agregar(1);
        c2.Agregar(2);
        c2.Agregar(3);


        System.out.println("Conjuntos Iguales: " + ConjuntosIguales(c1,c2));
    }

}
