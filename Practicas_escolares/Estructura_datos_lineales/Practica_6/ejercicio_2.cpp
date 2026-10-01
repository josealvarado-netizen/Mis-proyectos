#include <iostream>

#define N 6
using namespace std;


int main(){
	int menor, temp, indice;
	int arreglo[6] = {6,14,12,4,2, 0};
	
	//Imprimimos la lista del arreglo
	cout << "Lista de numeros enteros\n";
	
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
	
	cout << "\n";
	
	//Usamos el metodo de seleccion
	
	for(int i = 0; i < N -1; i++){
		menor = arreglo[i];
		indice = i;;
		
		for(int j = i + 1; j < N; j++){
			if (menor > arreglo[j]){
				menor  = arreglo[j];
				indice = j;
			}
		}
		temp            = arreglo[i];
		arreglo[i]      = menor;
		arreglo[indice] = temp;
	}
	
	// Imprimos el arreglo ordenado
	cout << "Lista de numeros enteros ordenado por seleccion\n";
	
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
	
	return 0;
}
