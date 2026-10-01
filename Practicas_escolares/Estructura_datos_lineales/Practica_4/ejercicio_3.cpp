#include <cstdlib>
#include <iostream>
#include <conio.h>
using namespace std;

int main(int argc, char *argv[]) {
    struct s_caja {
        int elemento;
        s_caja *enlace;
    };

    s_caja *pilaA, *pilaB, *q1, *q2;
    int elem;
    char c;

    pilaA = pilaB = NULL;

    do {
        cout << "Oprime \"S\" si deseas agregar otro elemento \n";
        c = getch();

        if (c == 's' || c == 'S') {
            cout << "dame un número entero: ";
            cin >> elem;

            q1 = new s_caja; // Crear un nuevo nodo

            q1->elemento = elem;
            q1->enlace = pilaA;
            pilaA = q1;
        }
    } while (c == 's' || c == 'S');

    // Copiar los elementos de la pilaA a la pilaB
    q1 = pilaA;
    q2 = NULL;

    while (q1 != NULL) {
        q2 = new s_caja; // Crear un nuevo nodo para pilaB

        q2->elemento = q1->elemento;
        q2->enlace = pilaB;
        pilaB = q2;

        q1 = q1->enlace;
    }

    // Desplegar los elementos de ambas pilas
    int j = 1;
    q1 = pilaA;
    while (q1 != NULL) {
        cout << "El elemento " << j << " de la pila A es: " << q1->elemento << endl;
        q1 = q1->enlace;
        j++;
    }
    cout<<endl;
    j = 1;
    q2 = pilaB;
    while (q2 != NULL) {
        cout << "El elemento " << j << " de la pila B es: " << q2->elemento << endl;
        q2 = q2->enlace;
        j++;
    }

    // Desalojar las listas
    while (pilaA != NULL) {
        q1 = pilaA->enlace;
        delete pilaA;
        pilaA = q1;
    }

    while (pilaB != NULL) {
        q2 = pilaB->enlace;
        delete pilaB;
        pilaB = q2;
    }

    system("PAUSE");
    return EXIT_SUCCESS;
}
