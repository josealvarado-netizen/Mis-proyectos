#include <iostream>
#include <cstdlib>

using namespace std;
void pideDatosVector(int *vector, int n);
double productoPunto(int *u, int *v, int n);
int main() {
    int *v, *u, n;

 	//solicitamos el tamaño y lo guardamos en n
	cout << "ingresa el tamaño de los vectores: ";
	cin  >>n;
	
		//Declaramos los vectores u y v 
    u = new int[n];
    v = new int[n];

    cout << "Datos del vector u\n";
    pideDatosVector(u, n);

    cout << "Datos del vector v\n";
    pideDatosVector(v, n);

    cout << "El producto punto de u por v es: " << productoPunto(u, v, n) << endl;

    // Liberación de memoria
    delete[] u;
    delete[] v;

    system("PAUSE");
    return EXIT_SUCCESS;
}

void pideDatosVector(int *vector, int n) {
    for (int i = 0; i < n; i++) {
        cout << "dato: "<<i + 1<< " es: ";
        cin >> vector[i];
    }
}

double productoPunto(int *u, int *v, int n) {
    double prod = 0;
    for (int i = 0; i < n; i++) {
        prod = prod + (u[i] * v[i]);
    }
    return prod;
}

