#include <iostream>


using namespace std;


int main(){
	
	int temp, n = 6;
	int arreglo[6] = {6,14,12,4,2, 0};
	
	//Imprimimos los numeros del arreglo
	cout << "Lista de numeros enteros\n";
	
	for(int i = 0; i<n; i++){
		cout << arreglo[i] << "\n";
	}
	cout <<  "\n";
	
	//hacemos el uso del ordenamiento por intercambio
	for(int i = 0; i < n-1; i++){
		for(int j = i+1; j < n; j++){
			if(arreglo[i] > arreglo[j]){
				temp       = arreglo[i];
				arreglo[i] = arreglo[j];
				arreglo[j] = temp;
				
			}
		}
	}
	
	//Imprimimos los numeros en orden
	cout << "Lista de numeros enteros ordenad por intercambio\n";
	for(int i = 0; i<n; i++){
		cout << arreglo[i] << "\n";
	}
	
	
	return 0;
}
