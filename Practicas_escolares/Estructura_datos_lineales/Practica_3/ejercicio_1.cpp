#include <iostream>

using namespace std;
void leer_datos (int **matriz, int n, int m );
void imprimir_datos(int **matriz, int n, int m);
int main(){
	
	int **matriz;
	int n, m;
	
	//declaramos n y m
	
	n = 2;
	m = 3;
	
	//delcaramos el arreglo de apuntadores
	
	matriz = new int * [n];
		for(int i = 0; i < n; i++){
			matriz[i] = new int [m];
		}
		
	//capturamos los datos
	/*
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			cout<< "valor de la matriz ["<< i<< "], ["<< j<< "] ";
			cin>>matriz[i][j];
		}
	}*/
	leer_datos (matriz,  n, m );
	// imprimimos los datos almacenados
	/*
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			cout<<"valor ["<<i<<"], ["<<j<<"] "<<matriz[i][j]<<" ";
		}
		cout<<"\n";
	}
	*/
	imprimir_datos(matriz, n, m);
	//desalojo de memoria
	
	if(matriz != NULL){
		for (int i = 0;i < n; i++){
			if(matriz[i] != NULL){
				delete [] matriz[i];
			}
		}
	}
	
	delete [] matriz;
	
	
	
	
	return 0;
}

void leer_datos (int **matriz, int n, int m ){ //declaramos la matriz con su tipo de dato.
	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			cout<< "valor de la matriz ["<< i<< "], ["<< j<< "] ";
			cin>>matriz[i][j];
		}
	}
}

void imprimir_datos(int **matriz, int n, int m){
		for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			cout<<"valor ["<<i<<"]["<<j<<"] "<<matriz[i][j]<<" ";
		}
		cout<<"\n";
	}
} 
