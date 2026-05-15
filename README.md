# 🌳 Árbol Binario de Búsqueda (BST) — Estructuras de Datos

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Universidad](https://img.shields.io/badge/Universidad-Da%20Vinci%20de%20Guatemala-blue?style=for-the-badge)
![Estado](https://img.shields.io/badge/Estado-Completo-brightgreen?style=for-the-badge)

</div>

---

## 👩‍💻 Información del Estudiante

| Campo | Detalle |
|---|---|
| **Nombre** | Karen Charmainne Rodas Equite |
| **Carné** | 202504327 |
| **Facultad** | Ingeniería en Sistemas y Ciencias de la Computación |
| **Curso** | Estructuras de Datos |
| **Universidad** | Universidad Da Vinci de Guatemala |

---

## 🎯 Descripción del Proyecto

Implementación **desde cero** de un **Árbol Binario de Búsqueda (BST)** en Java, sin uso de librerías nativas de árboles. El programa demuestra inserción, búsqueda, eliminación (los 3 casos críticos) y los tres tipos de recorridos.

---

## 🎬 Video de Defensa

> 🔗 **[Ver video en YouTube →](https://www.youtube.com/watch?v=TU_ENLACE_AQUI)**
>
> *(Sustituye este enlace por el tuyo después de subir el video)*

El video cubre:
- ✅ Ejecución en tiempo real insertando y eliminando valores
- ✅ Explicación del método `delete()` y sus 3 casos
- ✅ Justificación de la complejidad Big-O de `search()`

---

## 📁 Estructura del Proyecto

```
BST-KarenRodas/
├── src/
│   ├── Nodo.java      → Clase nodo (valor, izq, der)
│   ├── BST.java       → Lógica completa del árbol
│   └── Main.java      → Demostración y pruebas
└── README.md
```

---

## ⚙️ Métodos Implementados

| Método | Firma | Descripción |
|---|---|---|
| **Inserción** | `insert(int valor)` | Inserta un nodo en la posición correcta del BST |
| **Búsqueda** | `search(int valor) : boolean` | Retorna `true`/`false` si el valor existe |
| **Eliminación** | `delete(int valor)` | Elimina considerando los 3 casos críticos |
| **In-Order** | `recorridoInOrder()` | Imprime: Izquierda → Raíz → Derecha |
| **Pre-Order** | `recorridoPreOrder()` | Imprime: Raíz → Izquierda → Derecha |
| **Post-Order** | `recorridoPostOrder()` | Imprime: Izquierda → Derecha → Raíz |

---

## 🗑️ Los 3 Casos de Eliminación

```
CASO 1 — Nodo hoja (sin hijos):
  Antes: [30] → hijo: ninguno
  Acción: simplemente se elimina el nodo.
  Resultado: null

CASO 2 — Nodo con un solo hijo:
  Antes: [20] → hijo derecho: [25]
  Acción: el hijo sube y reemplaza al nodo eliminado.
  Resultado: [25]

CASO 3 — Nodo con dos hijos:
  Antes: [30] → hijos: [25] y [40]
  Acción: se busca el sucesor in-order (menor del subárbol derecho = 35).
          El valor 35 reemplaza al 30. Luego se elimina el 35 original.
  Resultado: [35] con hijos [25] y [40]
```

---

## 📊 Complejidad Algorítmica (Big-O)

| Operación | Caso Promedio | Peor Caso |
|---|---|---|
| Búsqueda | O(log n) | O(n) |
| Inserción | O(log n) | O(n) |
| Eliminación | O(log n) | O(n) |
| Recorridos | O(n) | O(n) |

> **¿Por qué O(log n) en promedio?**
> En un árbol balanceado, cada comparación descarta la mitad del árbol restante, similar a una búsqueda binaria. Con `n` nodos y altura `h ≈ log₂(n)`, se necesitan a lo sumo `log n` pasos.
>
> **¿Por qué O(n) en el peor caso?**
> Si se insertan valores en orden estrictamente ascendente o descendente (ej: 10, 20, 30, 40...), el árbol degenera en una lista enlazada, y hay que recorrer todos los nodos.

---

## 🚀 Cómo Ejecutar el Proyecto

### Requisitos Previos
- ✅ **Java JDK 11 o superior** instalado
- ✅ Verificar instalación: `java -version`

### Opción A — Desde la Terminal (Manual)

```bash
# 1. Clonar el repositorio
git clone https://github.com/TU_USUARIO/BST-KarenRodas.git

# 2. Entrar a la carpeta del proyecto
cd BST-KarenRodas/src

# 3. Compilar los 3 archivos Java
javac Nodo.java BST.java Main.java

# 4. Ejecutar el programa
java Main
```

### Opción B — Con VS Code

1. Instalar la extensión **"Extension Pack for Java"** de Microsoft
2. Abrir la carpeta `BST-KarenRodas/src` en VS Code
3. Abrir `Main.java`
4. Presionar el botón ▶ **Run** en la esquina superior derecha

### Opción C — Con IntelliJ IDEA

1. `File → Open` → seleccionar la carpeta `BST-KarenRodas`
2. Marcar `src/` como Sources Root (clic derecho → Mark Directory as → Sources Root)
3. Abrir `Main.java` y presionar ▶ **Run 'Main'**

---

## 📤 Cómo Subir a GitHub (Paso a Paso)

### Paso 1 — Crear cuenta y repositorio en GitHub
1. Ir a [github.com](https://github.com) y crear cuenta (si no tienes)
2. Clic en **"New repository"** (botón verde `+`)
3. Nombre: `BST-KarenRodas`
4. Seleccionar **Public**
5. ✅ Marcar **"Add a README file"** → Clic en **"Create repository"**

### Paso 2 — Subir los archivos
```bash
# En tu computadora, abre la terminal y navega a la carpeta del proyecto
cd BST-KarenRodas

# Inicializar Git
git init

# Agregar todos los archivos
git add .

# Hacer el primer commit
git commit -m "feat: implementación completa del BST - Karen Rodas 202504327"

# Conectar con el repositorio de GitHub (cambia TU_USUARIO por tu usuario)
git remote add origin https://github.com/TU_USUARIO/BST-KarenRodas.git

# Subir el código
git push -u origin main
```

### Paso 3 — Verificar
- Ve a `https://github.com/TU_USUARIO/BST-KarenRodas`
- Deberías ver los 3 archivos `.java` y el `README.md`

---

## 🎥 Cómo Subir el Video a YouTube

1. Grabar el video (máximo 5 minutos) mostrando:
   - El programa corriendo con las inserciones y eliminaciones
   - Explicación del método `delete()` (los 3 casos)
   - Justificación verbal de la complejidad del `search()`

2. Ir a [youtube.com](https://youtube.com) → clic en **"+"** → **"Subir video"**

3. Configurar visibilidad como **"No listado"** (oculto pero accesible con enlace) o **"Público"**

4. Una vez subido, copiar el enlace y pegarlo en la sección **"Video de Defensa"** de este README

5. Para editar el README en GitHub:
   - Abrir `README.md` en GitHub
   - Clic en el ✏️ (lápiz)
   - Reemplazar `https://www.youtube.com/watch?v=TU_ENLACE_AQUI` con tu enlace real
   - Clic en **"Commit changes"**

---

## 🖥️ Salida Esperada del Programa

```
============================================================
  ÁRBOL BINARIO DE BÚSQUEDA (BST)
  Karen Charmainne Rodas Equite | Carné: 202504327
  Universidad Da Vinci de Guatemala
============================================================
------------------------------------------------------------
  INSERCIÓN DE VALORES
------------------------------------------------------------
✔ Insertado: 50
✔ Insertado: 30
✔ Insertado: 70
...
🌳 Visualización del Árbol:
└── 50
    ├── 30
    │   ├── 20
    │   │   ├── 10
    │   │   └── 25
    │   └── 40
    │       └── 35
    └── 70
        ├── 60
        └── 80
------------------------------------------------------------
  RECORRIDOS DEL ÁRBOL
------------------------------------------------------------
📋 In-Order    (Izq→Raíz→Der): [ 10 20 25 30 35 40 50 60 70 80 ]
📋 Pre-Order   (Raíz→Izq→Der): [ 50 30 20 10 25 40 35 70 60 80 ]
📋 Post-Order  (Izq→Der→Raíz): [ 10 25 20 35 40 30 60 80 70 50 ]
...
```

---

<div align="center">

**Universidad Da Vinci de Guatemala** | Estructuras de Datos | 2025

</div>
