package ejerciciosGuiaCatedra;

import implementación.ABB;
import implementación.ConjuntoLD;
import implementación.PilaLD;
import tda.ABBTDA;
import tda.ConjuntoTDA;
import tda.PilaTDA;

/**
 * Created by gpaez on 14/02/2016.
 */
public class ProblemasABBTDA {
/**
    Trabajo Práctico 4 – TDA Árbol Binario de Búsqueda (ABB). Uso de la Recursión.
            (En todos los ejercicios siguientes calcular el costo espacial y temporal de los métodos escritos)
    TDA ABB
    1) Definir el TDA ABB, con las siguientes operaciones asociadas (según lo visto en clase):
    a) Raiz
    b) HijoIzq
    c) HijoDer
    d) ArbolVacio
    e) InicializarArbol
    f) AgregarElem
    g) EliminarElem

    Un ABB es una estructura que nos permite almacenar un conjuntos de valores enteros. Eliminarlos y recuperarlos.
    La particularidad que tiene esta estructura es que cada nodo puede o no, tener dos nodos hijos (HijoDerecho y/Hijo Izquierdo).
    Es un arbol binario.

    - InicializarArbol: permite inicializar la estructura.
    - ArbolVacio: permite conocer si el nodo contiene elementos o no, siempre que el arbol esté inicializado.
    - Raiz: permite recuperar el valor del nodo. Se supone que el arbol está inicializado y no sea vacio.
    - HijoDer: devuelve el subarbol derecho, siempre que el arbol este inicializado y no sea vacio.
    - HijoIzq: devuelve el subarbol derecho, siempre que el arbol este inicializado y no sea vacio.
    - AgregarElemento: permite agregar un elemento al arbol, manteniendo la propiedad de ABB, siempre que el arbol esté
        inicializado.
    - EliminarElemento: permite eliminar un elemento del arbol, manteniendo la propiedad de ABB. Siempre que el arbol
        este inicializado.
s */
    /**
     * 2) Implementar el TDA ABB definido en el ejercicio anterior, utilizando estructuras dinámicas.
     Utilización del TDA ABB / Uso de la Recursión.

     // OK */
    /**
     3) A partir del TDA ABB, escribir métodos externos que resuelvan los siguientes problemas.
     En caso de ser posible, escribir la versión iterativa y la versión recursiva de los métodos.




     i) Comprobar si dos ABBs tienen la misma forma.

     k) Contar la cantidad de elementos que están en un cierto nivel N.
     l) Mostrar por pantalla todos los elementos que contiene un ABB
     i.In-orden
     ii.Pre-orden
     iii.Post-orden

     n) Dado un elemento de valor v (que está presente en el ABB), obtener el elemento
     del árbol que es inmediatamente anterior (en valor).

     */

    // a) Dado un elemento, determinar si está o no en un ABB.
    public  static boolean ExisteElementoEnArbol(ABBTDA a, int x){
        if (a.ArbolVacio()){
            return false;
        }
        else if (a.Raiz() == x){
            return  true;
        }
        else if (a.Raiz() > x){
            return ExisteElementoEnArbol(a.HijoIzq(), x);
        }
        else{
            return ExisteElementoEnArbol(a.HijoDer(),x);
        }
    }
    //b) Dado un elemento, determinar si es una hoja de un ABB.
    public  static boolean EsNodoHoja(ABBTDA a, int e){
        if (a.ArbolVacio()){
            return false;
        }
        else if (a.Raiz() == e && a.HijoDer().ArbolVacio() && a.HijoIzq().ArbolVacio()){
            return true;
        }
        else if (a.Raiz() > e){
            return  EsNodoHoja(a.HijoIzq(), e);
        }
        else{
            return  EsNodoHoja(a.HijoDer(), e);
        }
    }

    //c) Dado un elemento, calcular su profundidad en el ABB.
    public static int CalcularProfundidadArbol(ABBTDA a, int e){
        if (a.ArbolVacio()){
            return -1;
        }
        else if (a.Raiz() == e){
                return 0;
        }
        else if (a.Raiz() > e){
            return (1 + CalcularProfundidadArbol(a.HijoIzq(), e));
        }
        else{
            return (1 + CalcularProfundidadArbol(a.HijoDer(), e));
        }
    }

    //d) Obtener el valor del menor elemento de un ABB.
    public static int MenorElementoArbol(ABBTDA a){
        if (!a.ArbolVacio()) {
            ABBTDA aux = a;

            while (!aux.HijoIzq().ArbolVacio()){
                aux = aux.HijoIzq();
            }
            return aux.Raiz();
        }
        return -1;
    }

    //e) Calcular la cantidad de elementos que contiene un ABB.
    public static int CantidadElementosArbol(ABBTDA a){
        if (a.ArbolVacio()){
            return 0;
        }
        else{
            return (1 + CantidadElementosArbol(a.HijoIzq())) + CantidadElementosArbol(a.HijoDer());
        }
    }

    // f) Calcular la suma de los elementos que contiene un ABB.
    public static int SumarElementosArbol(ABBTDA a){
        if (a.ArbolVacio()){
            return 0;
        }
        else{
            return (a.Raiz() + SumarElementosArbol(a.HijoIzq())) + SumarElementosArbol(a.HijoDer());
        }
    }

    //g) Calcular el cantidad de hojas de un ABB
    public static int ContarHojasArbol(ABBTDA a){
        if (a.ArbolVacio()){
            return 0;
        }
        else if (a.HijoIzq().ArbolVacio() && a.HijoDer().ArbolVacio()){
            return 1;
        }
        else {
            return ContarHojasArbol(a.HijoIzq()) + ContarHojasArbol(a.HijoDer());
        }
    }

    //h) Calcular la altura de un ABB.

    public static int CalcularAlturaArbol(ABBTDA a) {
        if (a.ArbolVacio()){
            return 0;
        }
        else {
            return 1 + (Math.max(CalcularAlturaArbol(a.HijoIzq()),CalcularAlturaArbol(a.HijoDer())));
        }
    }

    //i) Comprobar si dos ABBs tienen la misma forma.
    private  static  void FormaArbol(ABBTDA a, PilaTDA p){
        if (!a.ArbolVacio()){
            FormaArbol(a.HijoIzq(),p);
            p.Apilar(0);
            FormaArbol(a.HijoDer(),p);
            p.Apilar(1);
        }
    }

    public static boolean IgualFormaArbol(ABBTDA a, ABBTDA b){
        PilaTDA pa = new PilaLD();
        PilaTDA pb = new PilaLD();
        pa.InicializarPila();
        pb.InicializarPila();

        FormaArbol(a,pa);
        FormaArbol(b,pb);

        while (!pa.PilaVacia() && !pb.PilaVacia()){
            if (pa.Tope() != pb.Tope()){
                return false;
            }
            if (!pb.PilaVacia()){
                pb.Desapilar();
            }
            pa.Desapilar();
        }
        return (pa.PilaVacia() && pb.PilaVacia());
    }

   // j) Comprobar si dos ABBs son iguales.
    public static boolean ArbolesIguales(ABBTDA a, ABBTDA b){
        if (a.ArbolVacio() && b.ArbolVacio()){
            return true;
        }
        else if (a.ArbolVacio() || b.ArbolVacio()){
            return  false;
        }
        else if (a.Raiz() == b.Raiz()){
            return ArbolesIguales(a.HijoIzq(), b.HijoIzq()) && ArbolesIguales(a.HijoDer(),b.HijoDer());
        }
        else{
            return  false;
        }
    }

    //m) Dado un valor k, arme un conjunto con todos los elementos del ABB que son
    //mayores que k.
    public static ConjuntoTDA valoresMayoresQueK(ABBTDA a, int k) {
        ConjuntoTDA conjuntoTDA = new ConjuntoLD();
        conjuntoTDA.InicializarConjunto();

        if (!a.ArbolVacio()) {
            if (a.Raiz() > k)
                conjuntoTDA.Agregar(a.Raiz());

            ConjuntoTDA ri = valoresMayoresQueK(a.HijoIzq(), k);
            ConjuntoTDA rd = valoresMayoresQueK(a.HijoDer(), k);

            while (!ri.ConjuntoVacio()){
                int x = ri.Elegir();
                conjuntoTDA.Agregar(x);
                ri.Sacar(x);
            }

            while (!rd.ConjuntoVacio()){
                int x = rd.Elegir();
                conjuntoTDA.Agregar(x);
                rd.Sacar(x);
            }
        }
        return conjuntoTDA;
    }




    public static void main(String[] args) {
        ABBTDA arbol = new ABB();
        arbol.InicializarArbol();
        arbol.AgregarElemento(20);
        arbol.AgregarElemento(10);
        arbol.AgregarElemento(35);
        arbol.AgregarElemento(1);
        arbol.AgregarElemento(18);
        arbol.AgregarElemento(26);
        arbol.AgregarElemento(40);
        arbol.AgregarElemento(14);
        arbol.AgregarElemento(23);
        arbol.AgregarElemento(30);
        arbol.AgregarElemento(12);
        arbol.AgregarElemento(15);

        ABBTDA arbol2 = new ABB();
        arbol2.InicializarArbol();
        arbol2.AgregarElemento(20);
        arbol2.AgregarElemento(10);
        arbol2.AgregarElemento(35);
        arbol2.AgregarElemento(1);
        arbol2.AgregarElemento(18);
        arbol2.AgregarElemento(26);
        arbol2.AgregarElemento(40);
        arbol2.AgregarElemento(14);
        arbol2.AgregarElemento(23);
        arbol2.AgregarElemento(30);
        arbol2.AgregarElemento(12);
        arbol2.AgregarElemento(15);

        System.out.println("Existe elemento 30 en el arbol?");
        if (ExisteElementoEnArbol(arbol, 30))
            System.out.println("Existe");
        else
            System.out.println("No Existe");

        System.out.println("Es elemento 30 nodo hoja?");
        if (EsNodoHoja(arbol, 30))
            System.out.println("Hoja");
        else
            System.out.println("No Hoja");

        System.out.println("\nMenor elemento del arbol");
        System.out.println("El menor elemento es:" + MenorElementoArbol(arbol));

        System.out.println("\nCantidad Elementos arbol");
        System.out.println("Cantidad de elemento:" + CantidadElementosArbol(arbol));

        System.out.println("\nSuma Elementos arbol");
        System.out.println("Suma de elemento:" + SumarElementosArbol(arbol));

        System.out.println("\nCantidad de hojas arbol");
        System.out.println("Cantidad de hojas:" + ContarHojasArbol(arbol));

        System.out.println("\nAltura Arbol");
        System.out.println("Altura:" + CalcularAlturaArbol(arbol));

        System.out.println("\nIgualdad de Arboles");
        System.out.println("Son iguales?:" + ArbolesIguales(arbol, arbol2));

        System.out.println("\nValores Mayores que K");
        ConjuntoTDA c = valoresMayoresQueK(arbol,30);

        while ( !c.ConjuntoVacio()){
            int x = c.Elegir();
            System.out.print(x + ", ");
            c.Sacar(x);
        }
    }
}

