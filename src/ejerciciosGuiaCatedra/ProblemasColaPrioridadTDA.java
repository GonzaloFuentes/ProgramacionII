package ejerciciosGuiaCatedra;

import implementación.ColaPrioridadLD;
import tda.ColaPrioridadTDA;

/**
 * Created by gpaez on 09/02/2016.
 */
public class ProblemasColaPrioridadTDA {

    /**
     * 5) Definir el TDA Cola con prioridades, listando las operaciones asociadas y establecer sus
     precondiciones.

     Una Cola Prioridad es una estructura que nos permite almacenar valores enteros asociado a una prioridad,
     recuperar y eliminar un elemento por su prioridad. Es decir, el elemento que se recupera o se elimina es aquel
     que tiene mayor prioridad.
     Los operaciones con su comportamientos son las siguientes:
     -InicializarCola: permite inicializar la estructura.

     - ColaVacia: indica si la estructura contiene o no elementos. Se supone como precondición que la estructura
     está inicializada.

     -AcolarPrioridad: permite agregar un elemento con su respectiva prioridad. Se supone como precondición que la
     ColaPrioridad está inicializada.

     -Desacolar: Permite eleminar el elemento que tiene mayor prioridad. Se supone como precondición que la estructura
     no está vacia.

     -Prioridad: permite conocer la prioridad del elemento con mayor prioridad. Se supone como precondición que la
     ColaPrioridad no está vacia.

     -Primero: permite conocer el elemento que tiene mayor prioridad. Se supone como precondición que la ColaPrioridad
     no está vacia.
     */


    /**
     6) A partir del TDA Cola con prioridades definido, escribir un método que permita
            a) Combinar dos colas con prioridades CP1 y CP2, generando una nueva
            cola con prioridades. Considerar que a igual prioridad, los elementos de la CP1
            son más prioritarios que los de la CP2.*/

    public static ColaPrioridadTDA CombinarColas(ColaPrioridadTDA c1, ColaPrioridadTDA c2){
        ColaPrioridadTDA nueva = new ColaPrioridadLD();
        nueva.InicializarCola();

        while (!c1.ColaVacia()){
            nueva.AcolarPrioridad(c1.Primero(),c1.Prioridad());
            c1.Desacolar();
        }

        while (!c2.ColaVacia()){
            nueva.AcolarPrioridad(c2.Primero(),c2.Prioridad());
            c2.Desacolar();
        }
        return nueva;
    }
    /**
     b) Determinar si dos Colas con prioridad son idénticas.*/
    public static boolean SonColasIdenticas(ColaPrioridadTDA c1, ColaPrioridadTDA c2){
        boolean sonIdenticas = true;
        while (!c1.ColaVacia() && !c2.ColaVacia() && sonIdenticas){
            if (c1.Primero() != c2.Primero() || c1.Prioridad()!=c2.Prioridad()){
                sonIdenticas=false;
            }
            else{
                c1.Desacolar();
                c2.Desacolar();
            }
        }
        return (c1.ColaVacia() && c2.ColaVacia() && sonIdenticas);
    }



    public static void main(String[] args) {
        ColaPrioridadTDA c1 = new ColaPrioridadLD();
        ColaPrioridadTDA c2 = new ColaPrioridadLD();
        c1.InicializarCola();;
        c2.InicializarCola();


        c1.AcolarPrioridad(10,5);
        c1.AcolarPrioridad(10,4);
        c1.AcolarPrioridad(10,3);

        c2.AcolarPrioridad(11,5);
        c2.AcolarPrioridad(11,4);
        c2.AcolarPrioridad(11,3);

       ColaPrioridadTDA nueva = CombinarColas(c1,c2);
        Imprimir(nueva);

        System.out.println("Compruebo si son colas Identicas");
        c1.AcolarPrioridad(10,5);
        c1.AcolarPrioridad(10,4);
        c1.AcolarPrioridad(10,3);

        c2.AcolarPrioridad(10,5);
        c2.AcolarPrioridad(10,4);
        c2.AcolarPrioridad(10,2);

        if (SonColasIdenticas(c1,c2))
            System.out.println("Son Identicas");
        else
            System.out.println("No son Identicas");

    }

    private static void Imprimir(ColaPrioridadTDA cola){
        while (!cola.ColaVacia()){
            System.out.println("Prioridad: " +cola.Prioridad() + "\tValor: " + cola.Primero());
            cola.Desacolar();
        }
    }
}
