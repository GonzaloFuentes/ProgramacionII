package implementación;

import tda.ABBTDA;
/**
 * Created by gpaez on 13/02/2016.
 */
public class ABB implements ABBTDA {
    class NodoABB{
        int info;
        ABBTDA hijoDer;
        ABBTDA hijoIzq;
    }

    NodoABB raiz;

    @Override
    public void InicializarArbol() {
        raiz = null;
    }

    @Override
    public int Raiz() {
        return raiz.info;
    }

    @Override
    public ABBTDA HijoDer() {
        return raiz.hijoDer;
    }

    @Override
    public ABBTDA HijoIzq() {
        return raiz.hijoIzq;
    }

    @Override
    public boolean ArbolVacio() {
        return raiz == null;
    }

    @Override
    public void AgregarElemento(int x) {
        if (raiz == null){
            raiz = new NodoABB();
            raiz.info = x;
            raiz.hijoIzq = new ABB();
            raiz.hijoIzq.InicializarArbol();
            raiz.hijoDer = new ABB();
            raiz.hijoDer.InicializarArbol();
        }
        else if (raiz.info > x){
            raiz.hijoIzq.AgregarElemento(x);
        }
        else {
            raiz.hijoDer.AgregarElemento(x);
        }
    }

    @Override
    public void EliminarElemento(int x) {
        if (raiz != null){
            if (raiz.info == x && raiz.hijoIzq.ArbolVacio() && raiz.hijoIzq.ArbolVacio()){
                raiz = null;
            }
            else if (raiz.info == x && !raiz.hijoIzq.ArbolVacio()){
                raiz.info = this.mayor(raiz.hijoIzq);
                raiz.hijoIzq.EliminarElemento(raiz.info);
            }
            else if (raiz.info == x && !raiz.hijoDer.ArbolVacio()){
                raiz.info = this.menor(raiz.hijoDer);
                raiz.hijoDer.EliminarElemento(raiz.info);
            }
            else if (raiz.info > x ){
                raiz.hijoIzq.EliminarElemento(x);
            }
            else{
                raiz.hijoDer.EliminarElemento(x);
            }
        }
    }

    private static  int mayor(ABBTDA a){
        return a.HijoDer().ArbolVacio()?a.Raiz():mayor(a.HijoDer());
    }

    private static  int menor(ABBTDA a){
        return a.HijoIzq().ArbolVacio()?a.Raiz():menor(a.HijoIzq());
    }
}
