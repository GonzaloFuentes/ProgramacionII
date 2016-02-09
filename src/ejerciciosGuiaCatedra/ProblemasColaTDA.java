package ejerciciosGuiaCatedra;

import implementación.ColaLD;
import implementación.DiccionarioSimpleLD;
import implementación.PilaLD;
import tda.ColaTDA;
import tda.DiccionarioSimpleTDA;
import tda.PilaTDA;

/**
 * Created by gpaez on 09/02/2016.
 */
public class ProblemasColaTDA {
    /* Ej 3) Definir el TDA Cola, listando las operaciones asociadas y establecer sus precondiciones.
     *
     * Una cola es una estructura que nos permite almacenar elementos del tipo entero, recuperar y eliminar el primer
     * elemento que fue ingresado en la cola. Tambien nos permite saber si la cola contiene o no elementos.
     *Los siguientes operaciones describen el comportamiendo de una Cola:
     * -InicializarCola: permite inicilizar la estructura de Cola.
     *
     * -Acolar: permite agregar un elemento a la cola. Se supone como precondición que la cola esta inicializada.
     *
     * -Desacolar: permite eliminar el primer elemento agregado a la cola. Se supone como precondición que la cola está
     * inicializada y la cola no está vacia.
     *
     * -Primero: permite recuperar el primer elementos ingresado a la cola. Se supone como precondición que la cola no
     * esta vacia.
     *
     * -ColaVacia: permite saber si la cola tiene elementos o no. Se supone que la cola está inicializada.
     *
     * -InicializarCola: permite inicializar la estructura de la Cola.
     **/


    //4) A partir del TDA Cola definido, escribir distintos métodos que permitan

    // 4 a) Pasar una Cola a otra
    public static void PasarCola(ColaTDA origen, ColaTDA destino){
        while (!origen.ColaVacia()){
            destino.Acolar(origen.Primero());
            origen.Desacolar();
        }
    }

    //4 b) Invertir el contenido de una Cola (pueden usarse Pilas auxiliares)
    public static void InvertirContenidoColaAuxPila(ColaTDA origen){
        PilaTDA aux = new PilaLD();
        aux.InicializarPila();

        while (!origen.ColaVacia()){
            aux.Apilar(origen.Primero());
            origen.Desacolar();
        }
        while (!aux.PilaVacia()){
            origen.Acolar(aux.Tope());
            aux.Desapilar();
        }
    }
    //4 c) Invertir el contenido de una Cola (NO pueden usarse Pilas auxiliares)
    public  static void InvertirContenidoColaNoAuxPila(ColaTDA cola){
        DiccionarioSimpleTDA auxDic = new DiccionarioSimpleLD();
        auxDic.InicializarDiccionario();
        int p = 0;
        int[] pos = new int[100];

        while (!cola.ColaVacia()){
            auxDic.Agregar(p,cola.Primero());
            cola.Desacolar();
            p++;
        }

        for (int i = p-1; i>=0; i--)
        {
           cola.Acolar(auxDic.Recuperar(i));
        }
    }

    //4 d) Determinar si el final de la Cola C1 coincide o no con la Cola C2.
    public static boolean CoincideFinal(ColaTDA c1, ColaTDA c2){
        PilaTDA aux1 = new PilaLD();
        PilaTDA aux2 = new PilaLD();

        aux1.InicializarPila();;
        aux2.InicializarPila();

        while (!c1.ColaVacia()){
            aux1.Apilar(c1.Primero());
            c1.Desacolar();
        }

        while (!c2.ColaVacia()){
            aux2.Apilar(c2.Primero());
            c2.Desacolar();
        }
        return (!aux1.PilaVacia()&&!aux2.PilaVacia()&&aux1.Tope()==aux2.Tope())? true:false;
    }

    /*4 e) Determinar si una Cola es capicúa o no. Para ser capicúa debe cumplir
    que el primer elemento es igual al último, el segundo igual al penúltimo, etc.*/

    //4 f) Determinar si la Cola C1 es la inversa de la Cola C2. Dos Colas serán


    private static void MostrarCola(ColaTDA cola){
        int i = 1;
        System.out.println("*****");
        while (!cola.ColaVacia()){
            System.out.println("Posición:" + i + " \t - Valor: " + cola.Primero());
            cola.Desacolar();
        }
        System.out.println("*****\n");
    }

    public static void main(String[] args){
        ColaTDA origen = new ColaLD();
        ColaTDA destino = new ColaLD();
        origen.InicializarCola();
        destino.InicializarCola();


        origen.Acolar(1);
        origen.Acolar(2);
        origen.Acolar(3);
        System.out.println("Pasar cola\nIngreso: 1,2,3");

        PasarCola(origen,destino);
        MostrarCola(destino);

        System.out.println("Invertir Cola con estructura Pila auxiliar\nIngreso: 4,5,6");
        origen.Acolar(4);
        origen.Acolar(5);
        origen.Acolar(6);
        InvertirContenidoColaAuxPila(origen);
        MostrarCola(origen);

        System.out.println("Invertir Cola sin estructura Pila auxiliar\nIngreso: 7,8,9");
        origen.Acolar(7);
        origen.Acolar(8);
        origen.Acolar(9);
        InvertirContenidoColaNoAuxPila(origen);
        MostrarCola(origen);

        System.out.println("Saber si el final de dos colas coinciden\nIngresoCola1: 10,11,12" +
                "\nIngresoCola2: 10,11,12,12,13");
        origen.Acolar(10);
        origen.Acolar(11);
        origen.Acolar(12);

        destino.Acolar(10);
        destino.Acolar(11);
        destino.Acolar(12);
        destino.Acolar(12);
        destino.Acolar(13);

        if (CoincideFinal(origen, destino))
            System.out.println("Coinciden");
        else
            System.out.println("No Coinciden");

    }

}
