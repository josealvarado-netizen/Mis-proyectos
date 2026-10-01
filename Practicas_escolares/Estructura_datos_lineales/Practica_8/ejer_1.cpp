#include <iostream>

using namespace std;

void introducir_datos_arreglo(int *arreglo, int n);
void quickSort(int *arreglo, int prim, int ult);
int particion(int *arreglo, int prim, int ult);

int main() {

    int *arreglo, n;

    cout << "Ingresa el tamaño del arreglo\n";
    cin >> n;

    arreglo = new int[n];
    int ult = n - 1;
    int prim = 0;
    introducir_datos_arreglo(arreglo, n);
    quickSort(arreglo, prim, ult);

    cout << endl;
    cout << endl;
    cout << "Los elementos ordenados del arreglo son:" << endl;
    for (int i = 0; i < n; i++) {
        cout << "Elemento " << i + 1 << ": " << arreglo[i] << endl;
    }
    delete[] arreglo;
}

void introducir_datos_arreglo(int *arreglo, int n) {
    for (int i = 0; i < n; i++) {
        cout << "Elemento " << i + 1 << ": ";
        cin >> arreglo[i];
    }
    cout << endl;
    cout << endl;
    cout << "Los elementos ingresados son:" << endl;
    for (int i = 0; i < n; i++) {
        cout << "Elemento " << i + 1 << ": " << arreglo[i] << endl;
    }
}

void quickSort(int *arreglo, int prim, int ult) {
    int priv;
    if (prim < ult) {
        priv = particion(arreglo, prim, ult);
        quickSort(arreglo, prim, priv - 1);
        quickSort(arreglo, priv + 1, ult);
    }
}

int particion(int *arreglo, int prim, int ult) {
    int i = prim, j = ult;
    int tmp;

    int pivote = arreglo[(i + j) / 2];

    while (i <= j) {
        while (arreglo[i] < pivote)
            i++;
        while (arreglo[j] > pivote)
            j--;

        if (i <= j) {
            tmp = arreglo[i];
            arreglo[i] = arreglo[j];
            arreglo[j] = tmp;
            i++;
            j--;
        }
    }
    return i;
}

