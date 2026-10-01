#include <iostream>

using namespace std;

int main(){
	struct s_caja{
		int elemento;
		s_caja *enlace;
	};
	
	s_caja *p = NULL, *q;
	int elem;
	
	//llenado de la lista
	cout<<"cuando quieras terminar el programa introduce un numero negativo\n";
	do{
		cout << "introduce un numero entero: "; 
		cin  >> elem;
		
		if(elem >= 0){
			q = new s_caja;
			q -> elemento = elem;
			q -> enlace = p;
			p = q;
		}
	}while(elem >= 0);
	
	//recorrido de la lista
	
	int j = 1;
	q = p;
	while (q != NULL){
		cout << "El elemento" << j << "es: " << q -> elemento << "\n";
		q = q -> enlace;
		j++; 
	}
	
	return 0;
}
