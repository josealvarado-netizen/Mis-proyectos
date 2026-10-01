import java.util.*;
public class ArbolExpr {
private NodoArbol raiz;

public ArbolExpr() {
	raiz = null;
}

//Operaciones para manipular un árbol de expresión
// (los métodos recursivos que deben invocar estos métodos están descritos más abajo)
public void construye(StringTokenizer expr) {
    raiz = construyeSub(expr); // Construye el árbol recursivamente a partir de la expresión
}
private NodoArbol construyeSub(StringTokenizer expre) {
    // Método recursivo a ser invocado por construye
    // Construye de forma recursiva un subárbol y regresa una referencia a su raíz
    if (expre.hasMoreTokens()) {
        String token = expre.nextToken();
        NodoArbol temp = new NodoArbol(token.charAt(0), null, null); // Define un nodo temp y lo pone en nulo
        if (!Character.isDigit(token.charAt(0))) { // Si el token no es un dígito (es un operador)
            temp.setIzq(construyeSub(expre)); // Invocar construyeSub en el resto de la expresión y asignar su resultado al árbol subizquierdo de temp
            temp.setDer(construyeSub(expre)); // Invocar construyeSub en la expresión restante y asignar su resultado al árbol subderecho de temp
        }
        return temp; // Retorna el nodo temp
    }
    return null; // Si no hay más tokens, retorna nulo
}

public void expresion() {
    expresion(raiz); // Imprime la expresión en forma infija
    System.out.println();
}

private void expresion(NodoArbol nodo) {
    // Método recursivo para imprimir la expresión en forma infija
    if (nodo != null) {
        expresion(nodo.getIzq());
        System.out.print(nodo.getElemento() + " ");
        expresion(nodo.getDer());
    }
}

public double evaluar() {
    return evaluar(raiz); // Evaluar la expresión
}
private double evaluar(NodoArbol nodo) {
    // Método recursivo para evaluar la expresión
    if (nodo == null)
        return 0;

    // Si es un nodo hoja (operando), convertir el carácter a double y devolverlo
    if (Character.isDigit(nodo.getElemento())) {
        return Double.parseDouble(nodo.getElemento().toString());
    } else {
        // Si es un nodo de operador, evaluar recursivamente sus hijos y aplicar la operación
        double izquierda = evaluar(nodo.getIzq());
        double derecha = evaluar(nodo.getDer());
        char operador = nodo.getElemento();

        // Realizar la operación correspondiente y devolver el resultado
        switch (operador) {
            case '+':
                return izquierda + derecha;
            case '-':
                return izquierda - derecha;
            case '*':
                return izquierda * derecha;
            case '/':
                if (derecha != 0)
                    return izquierda / derecha;
                else
                    throw new ArithmeticException("Error: división por cero");
            case '%':
                // Operación de módulo
                return izquierda % derecha;
            default:
                throw new IllegalArgumentException("Error: operador inválido");
        }
    }
}


public void muestraEstructura() {
    // Imprime el árbol de expresiones.El árbol está rotado contra reloj 90 grados.
    // Se usa un informen "inverso"
    // Solo para un propósito de pruebas
    if (raiz == null) {
        System.out.println("Árbol vacío");
    } else {
        System.out.println();
        muestraEstruct(raiz, 1);
        System.out.println();
    }
}
private void muestraEstruct(NodoArbol p, int nivel) {
    // Método recursivo a ser invocado por muestraEstructura(). Imprime el subárbol cuyo nodo es apuntado por p
    // El parámetro de nivel es el nivel del nodo con respecto al árbol de expresión
    if (p != null) {
        NodoArbol right = p.getDer(); // Por eficiencia se calcula derecha e izquierda sólo una vez
        NodoArbol left = p.getIzq();

        muestraEstruct(right, nivel + 1); // Imprime subárbol derecho
        for (int j = 0; j < nivel; j++) // Hace tabuladores para el nivel
            System.out.print("\t");
        System.out.print(" " + p.getElemento()); // Imprime el elemento
        if ((left != null) && (right != null))
            System.out.print("<"); // Imprime el  "conector"
        else if (right != null)
            System.out.print("/");
        else if (left != null)
            System.out.print("\\");
        System.out.println();
        muestraEstruct(left, nivel + 1); // Imprime el subárbol izquierdo
    }
}

}
