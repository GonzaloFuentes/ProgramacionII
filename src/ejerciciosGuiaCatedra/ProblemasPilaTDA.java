package ejerciciosGuiaCatedra;

import implementación.ColaLD;
import implementación.PilaLD;
import tda.ColaTDA;
import tda.PilaTDA;

/**
 * Created by gpaez on 09/02/2016.
 */
public class ProblemasPilaTDA {

    /*
    * Definicion de una Pila
    *
    * -Una pila es una estructura que nos permite almacenar un conjunto de valores enteros, recuperar y eliminar el ultimo
    * valor ingresado a la pila.
    * **Metodos
    * -Apilar: permite agregar un elementos a la pila. La pila debe estar inicializada.
    *
    * -Desapilar: permite eliminar el ultimo elemento ingresado a la pila. Se supone como precondicion
    * que la pila esta inicializada y no está vacia.
    *
    * -Tope: permite recuperar el ultimo elemento ingresado a la pila. Se supone como precondicion que la pila esta
    * inicializada y no vacia.
    *
    * -PilaVacia: permite conocer si la pila tiene elementos o no. Se supone como precondicion que la pila está
    * inicializada.
    * **/

    //TP1 | 2a) Pasar una Pila a otra (dejándola en orden inverso)
    public static void PasarPilaAOtraOrdenInverso(PilaTDA origen, PilaTDA destino){
        if (!origen.PilaVacia()){
            while (!origen.PilaVacia()){
                destino.Apilar(origen.Tope());
                origen.Desapilar();
            }
        }
    }

    //2 b) Copiar una Pila en otra (dejándola en el mismo orden que la original)
    public static void PasarPilaAOtraOrden(PilaTDA origen, PilaTDA destino){
        if (!origen.PilaVacia()){
            PilaTDA aux = new PilaLD();
            aux.InicializarPila();;

            while (!origen.PilaVacia()){
                aux.Apilar(origen.Tope());
                origen.Desapilar();
            }

            while (!aux.PilaVacia()){
                destino.Apilar(aux.Tope());
                aux.Desapilar();
            }
        }
    }

    //3 c) Invertir el contenido de una Pila.
    public static void InvertirContenidoDeUnaPila(PilaTDA pila){
        ColaTDA colaAux = new ColaLD();
        colaAux.InicializarCola();

        while (!pila.PilaVacia()){
            colaAux.Acolar(pila.Tope());
            pila.Desapilar();
        }

        while (!colaAux.ColaVacia()){
            pila.Apilar(colaAux.Primero());
            colaAux.Desacolar();
        }
    }

    // 2 d) Contar los elementos de una Pila
    public static int ContarElementosPila(PilaTDA pila){
        int contador = 0;
        while (!pila.PilaVacia()){
            contador++;
            pila.Desapilar();
        }
        return contador;

    }
    // 2 e) Sumar los elementos de una Pila
    public  static int SumarElementosDeUnaPila(PilaTDA pila){
        int sumador = 0;

        while (!pila.PilaVacia()){
            sumador+= pila.Tope();
            pila.Desapilar();
        }
        return sumador;
    }

    // 2 f) Calcular el promedio de los elementos de una Pila
    public  static float PromedioElementosDeUnaPila(PilaTDA pila){
        int sumador = 0;
        int contador = 0;

        while (!pila.PilaVacia()){
            sumador+= pila.Tope();
            contador++;
            pila.Desapilar();
        }

        return contador>0 ? sumador/contador: -1;

    }

    public static void ImprimirPila(PilaTDA pila){
        while (!pila.PilaVacia()){
            System.out.println("Elemento pila = " + pila.Tope());
            pila.Desapilar();
        }

    }

    public static void main(String[] args){
        PilaTDA origen, destino;

        origen = new PilaLD();
        destino = new PilaLD();
        origen.InicializarPila();
        destino.InicializarPila();
        System.out.println("2 a) ----Pasar una pila a otra orden inverso----");

        origen.Apilar(1);
        System.out.println("Agrego Elemento 1");
        origen.Apilar(2);
        System.out.println("Agrego Elemento 2");
        origen.Apilar(3);
        System.out.println("Agrego Elemento 3");
        PasarPilaAOtraOrdenInverso(origen,destino);
        ImprimirPila(destino);

        System.out.println("2 b) ----Pasar una pila a otra manteniendo orden ----");
        origen.Apilar(1);
        System.out.println("Agrego Elemento 1");
        origen.Apilar(2);
        System.out.println("Agrego Elemento 2");
        origen.Apilar(3);
        System.out.println("Agrego Elemento 3");
        PasarPilaAOtraOrden(origen,destino);
        ImprimirPila(destino);

        System.out.println("2 c) ----Invertir el contenido de una pila ----");
        origen.Apilar(4);
        System.out.println("Agrego Elemento 4");
        origen.Apilar(5);
        System.out.println("Agrego Elemento 5");
        origen.Apilar(6);
        InvertirContenidoDeUnaPila(origen);
        ImprimirPila(origen);

        System.out.println("2 d) ----Contar los elementos de una pila ----");
        origen.Apilar(7);
        System.out.println("Agrego Elemento 7");
        origen.Apilar(8);
        System.out.println("Agrego Elemento 8");
        origen.Apilar(9);
        System.out.println("Agrego Elemento 9");
        System.out.println("Elementos de una pila:"+ContarElementosPila(origen));

        System.out.println("2 e) ----Sumar los elementos de una pila ----");
        origen.Apilar(10);
        System.out.println("Agrego Elemento 10");
        origen.Apilar(11);
        System.out.println("Agrego Elemento 11");
        origen.Apilar(12);
        System.out.println("Agrego Elemento 12");
        System.out.println("Promedio de los elementos:"+SumarElementosDeUnaPila(origen));

        System.out.println("2 e) ----Promedio de los elementos de una pila ----");
        origen.Apilar(10);
        System.out.println("Agrego Elemento 10");
        origen.Apilar(11);
        System.out.println("Agrego Elemento 11");
        origen.Apilar(12);
        System.out.println("Agrego Elemento 12");
        System.out.println("Promedio de los elementos:"+PromedioElementosDeUnaPila(origen));

    }

}
