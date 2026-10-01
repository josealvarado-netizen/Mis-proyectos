#include <iostream>

using namespace std;

int main(){
	int n;
	cout<<"Ingresa el tamaño del arreglo: ";
	cin>>n;
	
	int *a = new int[n];
		if (a == NULL){
		cout<<"No es posible alojar en la memoria"<<"\n";
		return -1;
		}
	for(int i = 0; i < n; i++){
		cout<<"ingresa los valores del arrelo a" <<"el valor "<< i + 1<<"\t";
		cin>>a[i];
	}
	}
	for(int i = 0; i < n; i++){
	 	cout<<"elemento del arreglo de a "<< i +1<<" es :"<< a[i]<<"\n";
	 }
	int m = 3 * n;
	double *b = new double [n];
		if (b == NULL){
		cout<<"No es posible alojar en la memoria"<<"\n";
		return -1;
		}
	
	for(int j = 0; j <n; j++){
		cout<<"ingresa los valores del arrelo b" <<"el valor "<< j + 1<<"\t";
		cin>>b[j];
	}
	for(int j = 0; j < n; j++){
	 	cout<<"elemento "<< j +1<<" es :"<< b[j]<<"\n";
	 }
	 
		float *c = new float[n];
		if (c == NULL){
		cout<<"No es posible alojar en la memoria"<<"\n";
		return -1;
		}
	for(int k = 0; k < 2*n + 1; k++){
		cout<<"ingresa los valores del arrelo c" <<"el valor "<< k + 1<<"\t";
		cin>>c[k];
	}
	 for(int k = 0; k < 2 *n +1; k++){
	 	cout<<"elemento "<< k +1<<" es :"<< c[k]<<"\n";
	 }
	 
	 delete [] a;
	 delete [] b;
	 delete [] c;
	 return 0;
}
