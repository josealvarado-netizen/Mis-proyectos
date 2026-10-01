#include <cstdlib>
#include <iostream>
#include <conio.h>

using namespace std;

int main(){
	
	struct s_alumno{
		char nombre[30];
		float promedio;
	};
	struct s_nodo{
	s_alumno elemento;
	s_nodo *link;	
	};
	
	s_nodo *inicio, *q;
	int elem;
	char c, cr[2];
	
	inicio = NULL;
	
	//llenado de la lista
	do{
		cout << "Oprime ""S"" si deseas agregar otro elemento \n";
		c = getch();
		if(c == 's' || c == 'S'){
			q = new s_nodo;
			cout << "\n Nombre: ";
			cin.getline(q ->elemento.nombre, 30);
			cout << "\n Promedio: ";
			cin >> q -> elemento.promedio;
			cin.getline(cr,2);
			q -> link = inicio;
			inicio = q;
		}
	}while(c == 's' || c == 'S');
	
	//recorrido de la lista
	q = inicio;
	while (q != NULL){
		cout << "El alumno " << q -> elemento.nombre << " tiene de promedio: " << q -> elemento.promedio << "\n";
		q = q -> link;
	}
	
	//desalojo de memoria
	while(inicio != NULL){
		q = inicio -> link;
		delete inicio;
		inicio = q;
	}
	return 0;
}
