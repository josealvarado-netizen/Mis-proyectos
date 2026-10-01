#include <cstdlib>
#include <iostream>
#include <conio.h>
using namespace std;

struct s_caja {
    char nombre[30];
    float precio;
    s_caja *siguiente;
};

s_caja *caja_inicial = NULL, *caja_final = NULL;

bool otra_caja() {
    char c;
    cout << "\n Desea introducir los datos de otra caja? ";
    c = getch();
    return c == 's' || c == 'S';
}

s_caja *hacer_caja() {
    // aloja memoria
    s_caja *q;
    char cr[2];
    q = new s_caja;
    if (q == NULL)
        return NULL;
    // pide los datos
    cout << " Nombre del producto? ";
    cin.ignore(); // para evitar problemas con getline
    cin.getline(q->nombre, 30);
    cout << " Precio? ";
    cin >> q->precio;
    cin.getline(cr, 2);
    return q;
}

void Formar(s_caja *q) {
    if (q == NULL)
        return;
    q->siguiente = NULL;
    // “forma” una caja al final
    if (caja_final == NULL)
        caja_inicial = q;
    else
        caja_final->siguiente = q;
    caja_final = q;
}

s_caja *Despachar() {
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
    // crear y guardar
    while (otra_caja()) 
    {
        Formar(hacer_caja());
    }
    
    // Calcular y desplegar la longitud de la cola
    int longitud = 0;
    s_caja *temp = caja_inicial;
    while (temp != NULL) {
        longitud++;
        temp = temp->siguiente;
    }
    cout << " \n La longitud de la cola es: " << longitud << endl;

    q = caja_inicial;
    // sacar, usar y desechar
    while (NULL != (q = Despachar())) {
        // trabajar con la caja
        cout << "\n El producto: " << q->nombre
             << " cuesta: " << q->precio << endl;
        delete q;
    }

    return 0;
}
