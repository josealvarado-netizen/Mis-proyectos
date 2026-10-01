#include <cstdlib>
#include <iostream>
#include <conio.h>
using namespace std;

struct s_caja {
    int dato;
    s_caja *siguiente;
};

int j = 0;

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

int main()
 {
    s_caja *q;
    s_caja *inicioC1 = NULL, *inicioC2 = NULL, *finC1 = NULL, *finC2 = NULL;
    // crear y guardar elementos de la cola 1
    cout << "Proporciona los elementos de la cola 1 \n";
    while (otra_caja()) {
        q = hacer_caja();
        Formar(q, inicioC1, finC1);
        j++;
    }
    cout << " \n La longitud de la cola 1 es: " << j << endl;
    j = 0;
    // crear y guardar elementos de la cola 2
    cout << "Proporciona los elementos de la cola 2 \n";
    while (otra_caja()) {
        q = hacer_caja();
        Formar(q, inicioC2, finC2);
        j++;
    }
    cout << " \n La longitud de la cola 2 es: " << j << endl;

    // Código para concatenar las colas
    if (inicioC1 != NULL && inicioC2 != NULL) {
        finC1->siguiente = inicioC2;
    } else if (inicioC1 == NULL) {
        inicioC1 = inicioC2;
        finC1 = finC2;
    }

    // Desplegar los elementos concatenados
    q = inicioC1;
    cout << "\n Los elementos concatenados son: \n";
    while (q != NULL) {
        cout << q->dato << endl;
        q = q->siguiente;
    }

    // Liberar memoria
    while (NULL != (q = Despachar(inicioC1, finC1))) {
        delete q;
    }

    return 0;
}
