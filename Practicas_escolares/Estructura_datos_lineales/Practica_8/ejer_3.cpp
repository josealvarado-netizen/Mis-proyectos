#include <cstdlib>
#include <iostream>
#include <conio.h>

using namespace std;

void pedirDatosArreglo(int *A, int n);
int particion(int *a, int izq, int der);
void quick_sort(int *a, int prim, int ult);
void mezcla(int *a, int prim, int medio, int ult);
void merge_sort(int *a, int prim, int ult);
int main(int argc, char *argv[]) {

    int opcion, n, *A; 
    char c;
	A = new int [n];
    do {
        cout << "Ingresa los elementos del arreglo";
        cin >> n;

        pedirDatosArreglo(A, n);

        do {
            cout << endl
                 << "elige una opción para ordenarlos : \n"
                 << " 1 : QuickSort " << endl
                 << " 2 : MergeSort" << endl;
            cin >> opcion;
        } while ((opcion < 1) || (opcion > 2));

        switch (opcion) {
            case 1:
                quick_sort(A, 0, n - 1);
                cout << "\n Los datos con Quick Sort son: \n";
                break;
            case 2:
                merge_sort(A, 0, n - 1);
                cout << "\n Los datos con Merge Sort son: \n";
                break;
        };

        for (int i = 0; i < n; i++)
            cout << "A[" << i << "]=" << A[i] << endl;

        cout << "oprime ""Esc"" para terminar" << endl;
        c = getch();

    } while (27 != c);
    cout << " Adios! ";

	delete [] A;
    system("PAUSE");
    return EXIT_SUCCESS;
}

void pedirDatosArreglo(int *A, int n) {
    for (int i = 0; i < n; i++) {
        cout << "A[" << i << "]=?";
        cin >> A[i];
    }
}

int particion(int *a, int izq, int der) {
    int i = izq, j = der;
    int tmp;
    int pivote = a[(izq + der) / 2];

    while (i <= j) {
        while (a[i] < pivote)
            i++;
        while (a[j] > pivote)
            j--;

        if (i <= j) {
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
            j--;
        }
    }

    return i;
}

void quick_sort(int *a, int prim, int ult) {
    int pivote = particion(a, prim, ult);
    if (prim < pivote - 1)
        quick_sort(a, prim, pivote - 1);
    if (pivote < ult)
        quick_sort(a, pivote, ult);
}

void mezcla(int *a, int prim, int medio, int ult) {
    int i, j, k;
    int n1 = medio - prim + 1;
    int n2 = ult - medio;

    
    int izquierda[n1];
    int derecha[n2];

    
    for (i = 0; i < n1; i++)
        izquierda[i] = a[prim + i];
    for (j = 0; j < n2; j++)
        derecha[j] = a[medio + 1 + j];

    
    i = 0;
    j = 0;
    k = prim;
    while (i < n1 && j < n2) {
        if (izquierda[i] <= derecha[j]) {
            a[k] = izquierda[i];
            i++;
        } else {
            a[k] = derecha[j];
            j++;
        }
        k++;
    }

    
    while (i < n1) {
        a[k] = izquierda[i];
        i++;
        k++;
    }

    
    while (j < n2) {
        a[k] = derecha[j];
        j++;
        k++;
    }
}

void merge_sort(int *a, int prim, int ult) {
    if (prim < ult) {
        int medio = prim + (ult - prim) / 2;

        // Ordenar las mitades izquierda y derecha
        merge_sort(a, prim, medio);
        merge_sort(a, medio + 1, ult);

        // Mezclar las mitades ordenadas
        mezcla(a, prim, medio, ult);
    }
}
