/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

public class ArbolBinarioB {
     private NodoDelArbol raízPrincipal;

    public ArbolBinarioB() { //Constructor de la clase ÁrbolBinarioB
        this.raízPrincipal = null;
    }

    public void insertar(int elemento) {  //Este es el método de acceso públic que permite insertar nodos.
        NodoDelArbol actual = raízPrincipal;
        if (this.raízPrincipal == null) {
            this.raízPrincipal = new NodoDelArbol(elemento);
        } else {
            insertarAhora(actual, elemento);
        }
    }

    private void insertarAhora(NodoDelArbol aux, int nuevoDato) {   //Este es el algoritmo motor que realimente elimina los nodos.
        if (nuevoDato > aux.getValorDelNodo()) {

            if (aux.getNodoDerecho() == null) {
                NodoDelArbol nuevo = new NodoDelArbol(nuevoDato);
                aux.setNodoDerecho(nuevo);
            }
            aux = aux.getNodoDerecho();
            insertarAhora(aux, nuevoDato);

        } else if (nuevoDato < aux.getValorDelNodo()) {
            if (aux.getNodoIzquierdo() == null) {
                NodoDelArbol nuevo = new NodoDelArbol(nuevoDato);
                aux.setNodoIzquierdo(nuevo);
            }
            aux = aux.getNodoIzquierdo();
            insertarAhora(aux, nuevoDato);
        }

    }

    public boolean estarVacío() { //Este método verifica si el árbol está vacío
        return (this.raízPrincipal == null);
    }

    public void imprimePre() { //Método público que inicializa la operación recorrer en Preorden
        preOrden(this.raízPrincipal);
    }

    private void preOrden(NodoDelArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValorDelNodo() + ",");
            preOrden(nodo.getNodoIzquierdo());
            preOrden(nodo.getNodoDerecho());
            System.out.print("\b");
        }
    }

    public void imprimeIno() { //Método público que inicializa la operación recorrer en Inorden
        inorden(this.raízPrincipal);
        System.out.print("\b");
    }

    private void inorden(NodoDelArbol nodo) {
        if (nodo != null) {
            inorden(nodo.getNodoIzquierdo());
            System.out.print(nodo.getValorDelNodo() + ",");
            inorden(nodo.getNodoDerecho());
        }
    }

    public void imprimePos() { //Método público que inicializa la operación recorrer en Postorden
        postorden(this.raízPrincipal);
        System.out.print("\b");
    }

    private void postorden(NodoDelArbol nodo) {
        if (nodo != null) {
            postorden(nodo.getNodoIzquierdo());
            postorden(nodo.getNodoDerecho());
            System.out.print(nodo.getValorDelNodo() + ",");
        }
    }

    public void buscaHijoDer(int valorDelNodo) { //Método que busca y muestra el hijo o nodo derecho de un nodo específico
        NodoDelArbol recorrido = this.raízPrincipal;
        int valorHijoDerecho = 0;
        boolean encontrado = false;
        if (recorrido != null && existe(valorDelNodo) == true) {
            while (recorrido != null) {
                if (valorDelNodo == recorrido.getValorDelNodo()) {
                    if (recorrido.getNodoDerecho() == null) {
                        System.out.println("na");
                        encontrado = true;
                        break;
                    } else {
                        valorHijoDerecho = recorrido.getNodoDerecho().getValorDelNodo();
                        System.out.println(valorHijoDerecho);
                        encontrado = true;
                        break;
                    }
                } else if (valorDelNodo > recorrido.getValorDelNodo()) {
                    recorrido = recorrido.getNodoDerecho();
                } else if (valorDelNodo < recorrido.getValorDelNodo()) {
                    recorrido = recorrido.getNodoIzquierdo();
                } else {
                    break;
                }
            }
            if (encontrado == false) {
                System.out.println("na");
            }
        } else {
            System.out.println("na");
        }
    }

    public void buscaHijoIzq(int valorDelNodo) { //Método que busca y muestra el hijo o nodo izquierdo de un nodo específico
        NodoDelArbol recorrido = this.raízPrincipal;
        int valorHijoIzquierdo = 0;
        boolean encontrado = false;
        if (recorrido != null && existe(valorDelNodo) == true) {
            while (recorrido != null) {
                if (valorDelNodo == recorrido.getValorDelNodo()) {
                    if (recorrido.getNodoIzquierdo() == null) {
                        System.out.println("na");
                        encontrado = true;
                        break;
                    } else {
                        valorHijoIzquierdo = recorrido.getNodoIzquierdo().getValorDelNodo();
                        System.out.println(valorHijoIzquierdo);
                        encontrado = true;
                        break;
                    }
                } else if (valorDelNodo > recorrido.getValorDelNodo()) {
                    recorrido = recorrido.getNodoDerecho();
                } else if (valorDelNodo < recorrido.getValorDelNodo()) {
                    recorrido = recorrido.getNodoIzquierdo();
                } else {
                    break;
                }
            }
            if (encontrado == false) {
                System.out.println("na");
            }
        } else {
            System.out.println("na");
        }
    }

    public void elimina(int valor) {  //Este método iniciliaza el proceso de eliminación de un nodo específico
        NodoDelArbol recorrido = this.raízPrincipal;
        if (recorrido != null && existe(valor) == true) {
            eliminador(recorrido, valor);
        }
    }

    private void eliminador(NodoDelArbol nodo, int valor) {
        if (esHoja(valor) == true) {  // Se verifica primero si el nodo es hoja para simplemente establecer el apuntador de su padre a null
            NodoDelArbol padre = obtenerPadre(valor);
            if (padre == null) {
                this.raízPrincipal = null;
            } else {
                if (padre.getNodoDerecho()!=null && padre.getNodoDerecho().getValorDelNodo() == valor) {
                    padre.setNodoDerecho(null);
                } else if (padre.getNodoIzquierdo()!=null && padre.getNodoIzquierdo().getValorDelNodo() == valor) {
                    padre.setNodoIzquierdo(null);
                }
            }
        } else {

            if (nodo.getValorDelNodo() == valor) {
                if (nodo.getNodoIzquierdo() == null && nodo.getNodoDerecho() != null) { //Verificamos si contiene un sólo hijo (Derecho)
                    NodoDelArbol padre = obtenerPadre(valor);
                    if (padre == null) {
                        this.raízPrincipal = nodo.getNodoDerecho();
                    } else {
                        if (padre.getNodoDerecho().getValorDelNodo() == valor) {
                            padre.setNodoDerecho(nodo.getNodoDerecho());
                            nodo.setNodoDerecho(null);
                        } else if (padre.getNodoIzquierdo().getValorDelNodo() == valor) {
                            padre.setNodoIzquierdo(nodo.getNodoDerecho());
                            nodo.setNodoDerecho(null);
                        }
                    }
                } else if (nodo.getNodoDerecho() == null && nodo.getNodoIzquierdo() != null) {//Verificamos si contiene un sólo hijo (Izquierdo)
                    NodoDelArbol padre = obtenerPadre(valor);
                    if (padre == null) {
                        this.raízPrincipal = nodo.getNodoIzquierdo();
                    } else {
                        if (padre.getNodoDerecho().getValorDelNodo() == valor) {
                            padre.setNodoDerecho(nodo.getNodoIzquierdo());
                            nodo.setNodoIzquierdo(null);
                        } else if (padre.getNodoIzquierdo().getValorDelNodo() == valor) {
                            padre.setNodoIzquierdo(nodo.getNodoIzquierdo());
                            nodo.setNodoIzquierdo(null);
                        }
                    }
                } else if (nodo.getNodoIzquierdo() != null && nodo.getNodoIzquierdo() != null) { //Aquí verificamos si el nodo contiene dos subárboles o nodos hijos
                    NodoDelArbol mayor = recorrerSubIzq(nodo.getNodoDerecho());
                    int valorAuxiliar = mayor.getValorDelNodo();
                    eliminador(nodo.getNodoDerecho(), mayor.getValorDelNodo());
                    nodo.setValorDelNodo(valorAuxiliar);
                }
            } else if (valor > nodo.getValorDelNodo() && nodo.getNodoDerecho()!=null) {
                eliminador(nodo.getNodoDerecho(), valor);
            } else if (valor < nodo.getValorDelNodo() && nodo.getNodoIzquierdo()!=null) {
                eliminador(nodo.getNodoIzquierdo(), valor);
            }
        }

    }

    private NodoDelArbol recorrerSubIzq(NodoDelArbol nodo) { //Método privado que permite obtener el nodo superior inmediato del subárbol derecho de un nodo
        if (nodo.getNodoIzquierdo() != null) {
            return recorrerSubIzq(nodo.getNodoIzquierdo());
        }
        return nodo;
    }

    public boolean existe(int valorDelNodo) { //Método que inicializa la operación de búsqueda de un nodo para verificar si existe
        NodoDelArbol recorrido = this.raízPrincipal;
        if (recorrido != null){
        return (existe(valorDelNodo, recorrido));
        }else {
        return false;
        }
    }

    private boolean existe(int valorNodo, NodoDelArbol nodo) {
        boolean respuesta = false;

        while (nodo != null) {
            if (valorNodo == nodo.getValorDelNodo()) {
                respuesta = true;
                break;
            } else if ((valorNodo > nodo.getValorDelNodo() || valorNodo < nodo.getValorDelNodo()) && esHoja(nodo.getValorDelNodo()) == true) {
                break;
            } else if (valorNodo > nodo.getValorDelNodo() && nodo.getNodoDerecho() != null) {
                nodo = nodo.getNodoDerecho();
            } else if (valorNodo < nodo.getValorDelNodo() && nodo.getNodoIzquierdo() != null) {
                nodo = nodo.getNodoIzquierdo();
            }
        }
        return respuesta;
    }

    /* El método obtenerPadre permite obtener el nodo padre de un nodo específico
     Este algoritmo es utilizado en el método de eliminación para modificar los punteros
     en caso fuere necesario.
     */
    private NodoDelArbol obtenerPadre(int valor) {
        NodoDelArbol auxiliar = this.raízPrincipal;
        NodoDelArbol padre = auxiliar;

        if (this.raízPrincipal.getValorDelNodo() == valor) {
            padre = null;
        } else {
            while (auxiliar != null) {
                if (auxiliar.getNodoDerecho() != null && auxiliar.getNodoDerecho().getValorDelNodo() == valor) {
                    padre = auxiliar;
                    break;
                } else if (auxiliar.getNodoIzquierdo() != null && auxiliar.getNodoIzquierdo().getValorDelNodo() == valor) {
                    padre = auxiliar;
                    break;
                } else {
                    if (valor > auxiliar.getValorDelNodo() && auxiliar.getNodoDerecho() != null) {
                        auxiliar = auxiliar.getNodoDerecho();
                    } else if (valor < auxiliar.getValorDelNodo() && auxiliar.getNodoIzquierdo() != null) {
                        auxiliar = auxiliar.getNodoIzquierdo();
                    }
                }

            }
        }
        return padre;
    }
    /*Con el método esHoja comprobamos si el nodo no contiene subárboles o nodos hijos*/

    private boolean esHoja(int dato) {
        NodoDelArbol recorrido = this.raízPrincipal;
        boolean respuesta = false;
        while (recorrido != null) {

            if (recorrido.getValorDelNodo() == dato) {
                if (recorrido.getNodoIzquierdo() == null && recorrido.getNodoDerecho() == null) {
                    respuesta = true;
                    break;
                } else {
                    respuesta = false;
                    break;
                }
            } else if (dato > recorrido.getValorDelNodo() && recorrido.getNodoDerecho()!=null) {
                recorrido = recorrido.getNodoDerecho();
            } else if (dato < recorrido.getValorDelNodo() && recorrido.getNodoIzquierdo()!=null) {
                recorrido = recorrido.getNodoIzquierdo();
            }
        }
        return respuesta;
    }
    
}
