/**
 * Árbol Binario de Búsqueda (BST) - Binary Search Tree
 * 
 * Implementación completa con inserción, búsqueda, eliminación y recorridos.
 * 
 * Estudiante: Karen Charmainne Rodas Equite
 * Carné: 202504327
 * Curso: Estructuras de Datos
 * Universidad Da Vinci de Guatemala
 */
public class BST {

    private Nodo raiz;

    // Constructor
    public BST() {
        raiz = null;
    }

    // =========================================================
    //  INSERCIÓN
    //  Complejidad: O(log n) promedio | O(n) peor caso
    // =========================================================

    /**
     * Inserta un nuevo valor en el árbol.
     * Si el árbol está vacío, el nodo se convierte en la raíz.
     * Si el valor ya existe, no se duplica.
     */
    public void insert(int valor) {
        raiz = insertarRec(raiz, valor);
        System.out.println("✔ Insertado: " + valor);
    }

    private Nodo insertarRec(Nodo nodo, int valor) {
        // Caso base: posición encontrada
        if (nodo == null) {
            return new Nodo(valor);
        }
        // Recorrer izquierda si el valor es menor
        if (valor < nodo.valor) {
            nodo.izq = insertarRec(nodo.izq, valor);
        // Recorrer derecha si el valor es mayor
        } else if (valor > nodo.valor) {
            nodo.der = insertarRec(nodo.der, valor);
        }
        // Si el valor es igual, no se inserta (sin duplicados)
        return nodo;
    }

    // =========================================================
    //  BÚSQUEDA
    //  Complejidad: O(log n) promedio | O(n) peor caso
    // =========================================================

    /**
     * Busca un valor en el árbol.
     * Retorna true si el valor existe, false si no.
     */
    public boolean search(int valor) {
        boolean encontrado = buscarRec(raiz, valor);
        System.out.println("🔍 Búsqueda de " + valor + ": " + (encontrado ? "ENCONTRADO ✔" : "NO ENCONTRADO ✘"));
        return encontrado;
    }

    private boolean buscarRec(Nodo nodo, int valor) {
        // Caso base: nodo nulo = no existe
        if (nodo == null) return false;
        // Encontrado
        if (valor == nodo.valor) return true;
        // Buscar en el subárbol correspondiente
        if (valor < nodo.valor) {
            return buscarRec(nodo.izq, valor);
        } else {
            return buscarRec(nodo.der, valor);
        }
    }

    // =========================================================
    //  ELIMINACIÓN
    //  Complejidad: O(log n) promedio | O(n) peor caso
    //  Maneja los 3 casos: sin hijos, un hijo, dos hijos
    // =========================================================

    /**
     * Elimina un valor del árbol considerando los tres casos críticos:
     * CASO 1 - Nodo hoja (sin hijos): simplemente se elimina.
     * CASO 2 - Nodo con un hijo: el hijo reemplaza al nodo eliminado.
     * CASO 3 - Nodo con dos hijos: se reemplaza con el sucesor in-order
     *          (el menor valor del subárbol derecho).
     */
    public void delete(int valor) {
        if (!buscarRec(raiz, valor)) {
            System.out.println("✘ El valor " + valor + " no existe en el árbol.");
            return;
        }
        raiz = eliminarRec(raiz, valor);
        System.out.println("🗑 Eliminado: " + valor);
    }

    private Nodo eliminarRec(Nodo nodo, int valor) {
        // Caso base: árbol vacío
        if (nodo == null) return null;

        if (valor < nodo.valor) {
            // El nodo a eliminar está en el subárbol izquierdo
            nodo.izq = eliminarRec(nodo.izq, valor);

        } else if (valor > nodo.valor) {
            // El nodo a eliminar está en el subárbol derecho
            nodo.der = eliminarRec(nodo.der, valor);

        } else {
            // *** Nodo encontrado → aplicar los 3 casos ***

            // CASO 1: Nodo hoja (sin hijos)
            if (nodo.izq == null && nodo.der == null) {
                return null;
            }

            // CASO 2a: Solo tiene hijo derecho
            if (nodo.izq == null) {
                return nodo.der;
            }

            // CASO 2b: Solo tiene hijo izquierdo
            if (nodo.der == null) {
                return nodo.izq;
            }

            // CASO 3: Tiene dos hijos
            // Encontrar el sucesor in-order: el nodo más pequeño del subárbol derecho
            Nodo sucesor = encontrarMinimo(nodo.der);
            // Reemplazar el valor del nodo con el valor del sucesor
            nodo.valor = sucesor.valor;
            // Eliminar el sucesor del subárbol derecho
            nodo.der = eliminarRec(nodo.der, sucesor.valor);
        }

        return nodo;
    }

    /**
     * Encuentra el nodo con el valor mínimo en un subárbol.
     * (Usado para encontrar el sucesor in-order en la eliminación Caso 3)
     */
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izq != null) {
            nodo = nodo.izq;
        }
        return nodo;
    }

    // =========================================================
    //  RECORRIDOS
    // =========================================================

    /**
     * RECORRIDO IN-ORDER: Izquierda → Raíz → Derecha
     * Resultado: valores en orden ascendente.
     * Complejidad: O(n)
     */
    public void recorridoInOrder() {
        System.out.print("📋 In-Order    (Izq→Raíz→Der): [ ");
        inOrderRec(raiz);
        System.out.println("]");
    }

    private void inOrderRec(Nodo nodo) {
        if (nodo != null) {
            inOrderRec(nodo.izq);
            System.out.print(nodo.valor + " ");
            inOrderRec(nodo.der);
        }
    }

    /**
     * RECORRIDO PRE-ORDER: Raíz → Izquierda → Derecha
     * Útil para clonar o serializar el árbol.
     * Complejidad: O(n)
     */
    public void recorridoPreOrder() {
        System.out.print("📋 Pre-Order   (Raíz→Izq→Der): [ ");
        preOrderRec(raiz);
        System.out.println("]");
    }

    private void preOrderRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrderRec(nodo.izq);
            preOrderRec(nodo.der);
        }
    }

    /**
     * RECORRIDO POST-ORDER: Izquierda → Derecha → Raíz
     * Útil para eliminar el árbol o evaluar expresiones.
     * Complejidad: O(n)
     */
    public void recorridoPostOrder() {
        System.out.print("📋 Post-Order  (Izq→Der→Raíz): [ ");
        postOrderRec(raiz);
        System.out.println("]");
    }

    private void postOrderRec(Nodo nodo) {
        if (nodo != null) {
            postOrderRec(nodo.izq);
            postOrderRec(nodo.der);
            System.out.print(nodo.valor + " ");
        }
    }

    // =========================================================
    //  VISUALIZACIÓN DEL ÁRBOL (extra, para el video)
    // =========================================================

    /**
     * Imprime una representación visual del árbol en consola.
     */
    public void imprimirArbol() {
        System.out.println("\n🌳 Visualización del Árbol:");
        imprimirArbolRec(raiz, "", true);
    }

    private void imprimirArbolRec(Nodo nodo, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.valor);
            String nuevoPrefijo = prefijo + (esUltimo ? "    " : "│   ");
            imprimirArbolRec(nodo.izq, nuevoPrefijo, nodo.der == null);
            imprimirArbolRec(nodo.der, nuevoPrefijo, true);
        }
    }
}
