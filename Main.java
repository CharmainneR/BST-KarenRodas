/**
 * Clase principal - Demostración del Árbol Binario de Búsqueda (BST)
 * 
 * Estudiante: Karen Charmainne Rodas Equite
 * Carné: 202504327
 * Curso: Estructuras de Datos
 * Universidad Da Vinci de Guatemala
 */
public class Main {

    public static void main(String[] args) {

        separador("=", 60);
        System.out.println("  ÁRBOL BINARIO DE BÚSQUEDA (BST)");
        System.out.println("  Karen Charmainne Rodas Equite | Carné: 202504327");
        System.out.println("  Universidad Da Vinci de Guatemala");
        separador("=", 60);

        BST arbol = new BST();

        // =============================================
        // FASE 1: INSERCIÓN DE VALORES
        // =============================================
        separador("-", 60);
        System.out.println("  INSERCIÓN DE VALORES");
        separador("-", 60);

        arbol.insert(50);
        arbol.insert(30);
        arbol.insert(70);
        arbol.insert(20);
        arbol.insert(40);
        arbol.insert(60);
        arbol.insert(80);
        arbol.insert(10);
        arbol.insert(25);
        arbol.insert(35);

        // Visualizar el árbol
        arbol.imprimirArbol();

        // =============================================
        // FASE 2: RECORRIDOS
        // =============================================
        separador("-", 60);
        System.out.println("  RECORRIDOS DEL ÁRBOL");
        separador("-", 60);

        arbol.recorridoInOrder();
        arbol.recorridoPreOrder();
        arbol.recorridoPostOrder();

        // =============================================
        // FASE 3: BÚSQUEDA
        // =============================================
        separador("-", 60);
        System.out.println("  BÚSQUEDA DE VALORES");
        separador("-", 60);

        arbol.search(40);   // Existe
        arbol.search(25);   // Existe
        arbol.search(99);   // No existe
        arbol.search(10);   // Existe

        // =============================================
        // FASE 4: ELIMINACIÓN (3 casos)
        // =============================================
        separador("-", 60);
        System.out.println("  ELIMINACIÓN - CASO 1: Nodo sin hijos (hoja)");
        separador("-", 60);

        System.out.println("Eliminando nodo HOJA: 10 (sin hijos)");
        arbol.delete(10);
        arbol.imprimirArbol();
        arbol.recorridoInOrder();

        separador("-", 60);
        System.out.println("  ELIMINACIÓN - CASO 2: Nodo con un solo hijo");
        separador("-", 60);

        System.out.println("Eliminando nodo con UN HIJO: 20 (solo tiene hijo: 25)");
        arbol.delete(20);
        arbol.imprimirArbol();
        arbol.recorridoInOrder();

        separador("-", 60);
        System.out.println("  ELIMINACIÓN - CASO 3: Nodo con dos hijos");
        separador("-", 60);

        System.out.println("Eliminando nodo con DOS HIJOS: 30 (hijos: 25 y 40)");
        System.out.println("→ El sucesor in-order es 35 (reemplaza al 30)");
        arbol.delete(30);
        arbol.imprimirArbol();
        arbol.recorridoInOrder();

        // =============================================
        // RESUMEN FINAL
        // =============================================
        separador("=", 60);
        System.out.println("  RESUMEN DE COMPLEJIDAD ALGORÍTMICA (Big-O)");
        separador("=", 60);
        System.out.println("  Operación    | Caso Promedio | Peor Caso");
        System.out.println("  -------------|---------------|----------");
        System.out.println("  Búsqueda     |   O(log n)    |   O(n)  ");
        System.out.println("  Inserción    |   O(log n)    |   O(n)  ");
        System.out.println("  Eliminación  |   O(log n)    |   O(n)  ");
        System.out.println("  Recorridos   |    O(n)       |   O(n)  ");
        separador("=", 60);
        System.out.println("  El peor caso O(n) ocurre cuando el árbol");
        System.out.println("  está completamente desbalanceado (como una lista).");
        separador("=", 60);
    }

    private static void separador(String caracter, int longitud) {
        System.out.println(caracter.repeat(longitud));
    }
}
