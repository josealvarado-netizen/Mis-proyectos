#include <cstdlib>
#include <iostream>
#include <conio.h>
#define TRUE 1
#define FALSE 0

using namespace std;

struct s_caja {
    int dato;
    s_caja *siguiente;
};

int i = 0, j = 0;

bool otra_caja() {
    char c;
    cout << "\n Desea introducir los datos de otra caja? \n";
    c = getch();
    return c == 's' || c == 'S';
}

s_caja *hacer_caja() {
    // aloja memoria
    s_caja *q;
    q = new s_caja;
    if (q == NULL)
        return NULL;
    // pide el dato
    cout << " Numero entero? ";
    cin >> q->dato;
    return q;
}

void Formar(s_caja *q, s_caja* &caja_inicial, s_caja* &caja_final) {
    if (q == NULL)
        return;
    q->siguiente = NULL;
    // "forma" una caja al final
    if (caja_final == NULL)
        caja_inicial = q;
    else
        caja_final->siguiente = q;
    caja_final = q;
    j++;
}

s_caja *Despachar(s_caja* &caja_inicial, s_caja* &caja_final) {
    // si ya está vacía
    if (caja_inicial == NULL)
        return NULL;
    s_caja *q;
    q = caja_inicial;
    caja_inicial = caja_inicial->siguiente;
    q->siguiente = NULL;
    // si queda vacía
    if (caja_inicial == NULL)
        caja_final = NULL;
    return q;
}

int main() {
    s_caja *q;
    s_caja *inicioC1 = NULL, *inicioC2 = NULL, *finC1 = NULL, *finC2 = NULL;

    // crear y guardar elementos de la cola 1
    cout << "Proporciona los elementos de la cola 1 \n";
    while (otra_caja()) {
        q = hacer_caja();
        Formar(q, inicioC1, finC1);
        i++;
    }
    cout << " \n La longitud de la cola 1 es: " << i << endl;

    j = 0;
    // crear y guardar elementos de la cola 2
    cout << "Proporciona los elementos de la cola 2 \n";
    while (otra_caja()) {
        q = hacer_caja();
        Formar(q, inicioC2, finC2);
    }
    cout << " \n La longitud de la cola 2 es: " << j << endl;

    q = inicioC1;
    cout << "\n Los elementos de la cola 1 son: \n";
    while (q != NULL) {
        cout << q->dato << endl;
        q = q->siguiente;
    }

    q = inicioC2;
    cout << "\n Los elementos de la cola 2 son: \n";
    while (q != NULL) {
        cout << q->dato << endl;
        q = q->siguiente;
    }

    // Determinar si el contenido de la cola 1 y la cola 2 es el mismo
    q = inicioC1;
    s_caja *q2 = inicioC2;
    bool iguales;
    if (q == NULL && q2 == NULL)
        // Las dos colas están vacías
        iguales = TRUE;
    else {
        if (q != NULL && q2 != NULL)
            // las dos colas tienen elementos
            if (i == j)
                // las dos colas tienen el mismo tamaño
                iguales = TRUE;
            else
                iguales = FALSE;
        else
            // una de las dos colas está vacía
            iguales = FALSE;
    }
    while ((iguales) && q != NULL && q2 != NULL) {
        iguales = iguales && (q->dato == q2->dato);
        q = q->siguiente;
        q2 = q2->siguiente;
    }
    if (iguales)
        cout << "Las colas son iguales." << endl;
    else
        cout << "Las colas no son iguales." << endl;

    // Liberar memoria
    while ((q = Despachar(inicioC1, finC1)) != NULL) {
        delete q;
    }

    while ((q = Despachar(inicioC2, finC2)) != NULL) {
        delete q;
    }
return 0;

}
