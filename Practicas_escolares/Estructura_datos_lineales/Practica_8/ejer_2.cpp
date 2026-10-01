#include <iostream>

using namespace std;

void pedirDatosArreglo(int *arreglo, int n);
void mezcla(int *arreglo, int ini, int med, int fin);
void merge_sort(int *arreglo, int ini, int fin);

int main() {
    int *arreglo, n;

    cout << "¿Cuántos elementos deseas agregar?";
    cin >> n;

    arreglo = new int[n];
    pedirDatosArreglo(arreglo, n);
    merge_sort(arreglo, 0, n - 1);

    cout << "Elementos ordenados del arreglo:" << endl;
    for (int i = 0; i < n; i++) {
        cout << arreglo[i] << endl;
    }

    delete[] arreglo;
}

void pedirDatosArreglo(int *arreglo, int n) {
    for (int i = 0; i < n; i++) {
        cout << "Arreglo[" << i << "]=";
        cin >> arreglo[i];
    }
}

void mezcla(int *arreglo, int ini, int med, int fin) {
    int *aux;
    aux = new int[fin - ini + 1];
    int i = ini;
    int j = med + 1;
    int k = 0;

    while (i <= med && j <= fin) {
        if (arreglo[i] < arreglo[j]) {
            aux[k] = arreglo[i];
            i++;
        } else {
            aux[k] = arreglo[j];
            j++;
        }
        k++;
    }

    while (i <= med) {
        aux[k] = arreglo[i];
        i++;
        k++;
    }

    while (j <= fin) {
        aux[k] = arreglo[j];
        j++;
        k++;
    }

    for (int m = 0; m < fin - ini + 1; m++) {
        arreglo[ini + m] = aux[m];
    }

    delete[] aux;
}

void merge_sort(int *arreglo, int ini, int fin) {
    int med;
    if (ini < fin) {
        med = (ini + fin) / 2;
        merge_sort(arreglo, ini, med);
        merge_sort(arreglo, med + 1, fin);
        mezcla(arreglo, ini, med, fin);
    }
}

