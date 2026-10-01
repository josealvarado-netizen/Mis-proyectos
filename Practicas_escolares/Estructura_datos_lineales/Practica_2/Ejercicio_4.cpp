#include <iostream>
#include <fstream>
using namespace std;

int main(){
	
ifstream entrada;
entrada.open("Datos.txt");
if(!entrada.is_open()){
	cout<<"no es posible abrir el archivo";
	return -2;
}
	
	int n;
	
	entrada >> n;
	
	double *datos;
	
	datos = new double [n];
	if(datos == NULL){
		cout << "no se pudo alojar";
		entrada.close();
		return -1;
	}
	
	for(int i = 0; i < n; i++){
		entrada>>datos[i];
	}
	entrada.close();
	
	for(int i = n - 1; i >= 0; i--){
		cout << datos[i]* 2<<"\n";
	}
	
	delete [] datos;
	return 0;
}
