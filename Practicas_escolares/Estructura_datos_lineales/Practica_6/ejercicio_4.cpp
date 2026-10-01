#include <iostream>

#define N 6
using namespace std;


int main(){
	int temp;
	int arreglo[6] = {6,14,12,4,2, 0};
	
	//Imprimimos la lista del arreglo
	cout << "Lista de numeros enteros\n";
	
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
	
	cout << "\n";
	
	//realizar el odenamiento por metodo burbuja
	for (int i = 0; i < N - 1; i++){
		for (int j = 0; j < N - 1; j++){
			if (arreglo[j] > arreglo[j + 1]){
				temp           = arreglo[j];
				arreglo[j]     = arreglo[j + 1];
				arreglo[j + 1] = temp;
			}
		}
	}
	
	//Imprimimos la lista ordenada
	cout << "Lista de numeros enteros\n";
	
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
	
	return 0;
}
