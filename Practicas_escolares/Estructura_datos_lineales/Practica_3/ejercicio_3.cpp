#include <iostream>

using namespace std;
void ingresodatosvectores(int *vectores, int n);
double productopunto(int *u, int *v, int n);

int main(){
	
	int *u, *v, n;
	
	//solicitamos el tamaño y lo guardamos en n
	cout << "ingresa el tamaño de los vectores: ";
	cin  >>n;
	
	//Declaramos los vectores u y v 
	u = new int [n];
	v = new int [n];
	
	//solicitamos los valores de u
	ingresodatosvectores(u, n);
	
	//solicitamos los valores de v
	ingresodatosvectores(v, n);
	
	//imprimimos el productopunto de los vectores
	cout<<"el valor del prodcuto de u * v es: "<<productopunto(u, v, n);
	
	
	return 0;
}

void ingresodatosvectores(int *vectores, int tamanio){
	for(int i = 0; i < tamanio; i++){
		cout << "dato: "<<i + 1<< " es: ";
		cin  >> vectores[i];
	}
}

double productopunto(int *u, int *v, int n){
	double producto = 0;
	for(int i = 0; i < n; i++){
		producto = producto + (u[i] * v[i]);
		return producto;
	}
}
