#include <iostream>

using namespace std;

int main(){
	int n;
	cout<<"Ingresa el tamaño del arreglo: ";
	cin>>n;
	
	float *reales = new float[n];
	if (reales == NULL){
		cout<<"No es posible alojar en la memoria"<<"\n";
		return -1;
	}
	
	for(int i = 0; i < n; i++){
		cout<<"ingresa el valor "<< i + 1<<"\t";
		cin>>reales[i];
	}
	 cout<<"el contenido del arreglo con un total de "<<n<<" de elementes es \n";
	 
	 for(int i = 0; i < n; i++){
	 	cout<<"elemento "<< i +1<<" es :"<< reales[i]<<"\n";
	 }
	
	delete [] reales;
	
	return 0;
}
