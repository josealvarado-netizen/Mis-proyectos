#include <iostream>

using namespace std;

struct s_caja {
    int dato;
    s_caja* enlace;
};

void push(s_caja*& pila, int dato) {
    s_caja* nuevaCaja = new s_caja;
    nuevaCaja->dato = dato;
    nuevaCaja->enlace = pila;
    pila = nuevaCaja;
}

void imprimirEnOrden(s_caja* pila) {
    if (pila != NULL) {
        cout << pila->dato << endl;
        imprimirEnOrden(pila->enlace);
    }
}

void imprimirEnOrdenInverso(s_caja* pila) {
    if (pila != NULL) {
        imprimirEnOrdenInverso(pila->enlace);
        cout << pila->dato << endl;
    }
}

void vaciarPila(s_caja*& pila) {
    while (pila != NULL) {
        s_caja* temp = pila;
        pila = pila->enlace;
        delete temp;
    }
}

int main() {
    s_caja* pila = NULL;

    cout << "Cuando quieras terminar, introduce un numero negativo\n";

    int numero;
    do {
        cout << "Dame un numero entero: ";
        cin >> numero;

        if (numero >= 0) {
            push(pila, numero);
        }
    } while (numero >= 0);

    int opcion;
    cout << "\nComo deseas imprimir la pila?\n";
    cout << "0: en orden <LIFO>\n";
    cout << "1: en orden inverso\n";
    cin >> opcion;

    cout << "\nLos elementos de la lista LIFO son:\n";
    if (opcion == 0) {
        imprimirEnOrden(pila);
    } else if (opcion == 1) {
        imprimirEnOrdenInverso(pila);
    }

    vaciarPila(pila);

    cout << "\nPresione una tecla para continuar" << endl;
    cin.get(); // Espera a que el usuario presione una tecla antes de salir
    return 0;
}
