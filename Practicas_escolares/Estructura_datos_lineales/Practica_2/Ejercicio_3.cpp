#include <iostream>

using namespace std;

int main(){

int i = 0, n;
char cr[2];

struct s_matria{
	char nombre[50];
	float califc;
};

s_matria *materia;

cout<<"ingresa la cantidad de alumnos a calificar: ";
cin>>n;

materia = new s_matria[n];
	if(materia == NULL){
		return -1;
	}
	//solicitamos datos
	
	for(i; i < n; i++){
		cin.getline(cr,2); /*eliminamos basura*/
		cout<<"Ingresa nombre de la UEA: "<< i + 1;
		cin.getline(materia[i].nombre, 30);
		cout<<"Ingresa la calificacion: ";
		cin>>materia[i].califc;
	}

//desplegamos los datos
	for(i = 0; i < n; i++){
		cout<<"En "<<materia[i].nombre<<" tienes: "<<materia[i].califc<<"\n";
	}

	delete [] materia;
return 0;
}
