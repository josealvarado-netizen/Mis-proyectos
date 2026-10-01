#include <iostream>

#define N 6
using namespace std;
void ordenamiento_intercambio(int arreglo[]);
void ordemaniento_seleccion(int arreglo[]);
void ordemaniento_insercion(int arreglo[]);
void ordemaniento_burbuja(int arreglo[]);
int main(){

int arreglo[6] = {6,14,12,4,2, 0};	
char op = 's';
int opcion;

cout << "\t\tMenu de ordenamineto\n";
cout << "1. ordenamiento por intercambio\n";
cout << "2. ordenamiento por selección\n";
cout << "3. ordenamiento por inserción\n";
cout << "4. ordenamiento por burbuja\n";
cout << "Selecciona una opción (de 1 a 4): ";
cin  >> opcion;
cout <<"\n";



switch(opcion){
	case 1: 
	cout << "Seleccionaste ordenamiento por intercambio\n";
	cout <<"lista de numeros \n";
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
	cout <<  "\n";
	ordenamiento_intercambio(arreglo);
	break;
	case 2: 
	cout << "Seleccionaste ordenamiento por seleccion\n";
	cout <<"lista de numeros \n";
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
	cout <<  "\n";
	ordemaniento_seleccion(arreglo);
	break;
	case 3: 
	cout << "Seleccionaste ordenamiento por insercion\n";
	cout <<"lista de numeros \n";
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
	cout <<  "\n";
	ordemaniento_insercion(arreglo);
	break;
	case 4:
	cout << "Seleccionaste ordenamiento por burbuja\n";
	cout <<"lista de numeros \n";
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
	cout <<  "\n";
	ordemaniento_burbuja(arreglo);
	 
	break;
	default:  cout << "El numero no pertenece al rango intenta de nuevo";
	
}


return 0;
}


void ordenamiento_intercambio(int arreglo[]){
	int temp;
	for(int i = 0; i < N-1; i++){
		for(int j = i+1; j < N; j++){
			if(arreglo[i] > arreglo[j]){
				temp       = arreglo[i];
				arreglo[i] = arreglo[j];
				arreglo[j] = temp;
				
			}
		}
	}
	cout << "Lista de numeros enteros ordenad por intercambio\n";
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
}

void ordemaniento_seleccion(int arreglo[]){
		
		int menor, temp, indice;
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
	cout << "Lista de numeros enteros ordenad por intercambio\n";
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
}

void ordemaniento_insercion(int arreglo[]){
	int temp, j;
	
	for (int i = 1; i < N; i++){
		temp = arreglo[i];
		
		for ( j = i -1; j >= 0 && temp < arreglo[j]; j--)
			arreglo[j + 1] = arreglo[j];
			arreglo[j + 1] = temp;
			
	}
	
	cout << "Lista de numeros enteros ordenad por intercambio\n";
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
}

void ordemaniento_burbuja(int arreglo[]){
	int temp;
	for (int i = 0; i < N - 1; i++){
		for (int j = 0; j < N - 1; j++){
			if (arreglo[j] > arreglo[j + 1]){
				temp           = arreglo[j];
				arreglo[j]     = arreglo[j + 1];
				arreglo[j + 1] = temp;
			}
		}
	}
	
	cout << "Lista de numeros enteros ordenad por intercambio\n";
	for(int i = 0; i<N; i++){
		cout << arreglo[i] << "\n";
	}
}
