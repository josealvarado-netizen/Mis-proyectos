#include <iostream>

#define N 6
using namespace std;


int main(){
	
	int temp, j;
	int arreglo[6] = {6,14,12,4,2, 0};
	
	cout << "Lista de numeros enteros\n";
	
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
	
		cout << "\n";
		
		//realizamos el ordenamineto de los numeros por inserción
	for (int i = 1; i < N; i++){
		temp = arreglo[i];
		
		for ( j = i -1; j >= 0 && temp < arreglo[j]; j--)
			arreglo[j + 1] = arreglo[j];
			arreglo[j + 1] = temp;
		
		
	}
	
	//Imprimimos la lista ordenada
	cout << "Lista de numeros enteros ordenada por inserción\n";
	
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
}
