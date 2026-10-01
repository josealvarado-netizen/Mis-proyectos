#include <iostream>
#include <cstdlib>
using namespace std;

void pideDatosVector( int *vector, int tamanio){
   for( int i=0; i<tamanio; i++){
        cout << "dato "<< i+1 << "=? ";
        cin >> vector[i];
   };  
}
void pideDatosMatriz( int **A, int n, int m){
   
   for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            cout << "A("<< i+1 <<", " << j+1<< " )=? ";
            cin >> A[i][j];
        }
   }
   
}

void prodMatrizVector(int **A, int *v, int *prod, int n, int m){  
  for( int i=0; i<n; i++ ){
    prod[i] = 0;
    for( int j=0; j<m; j++ )
      prod[i] = prod[i] + (A[i][j] * v[j]);
  };
}

int main()
{
    int *v, n, m;
    
    cout << "Tamano del vector \n"; cin>>m;
    // Alojar el vector v
    v = new int [m];
    
    cout << "Datos del vector v \n";
    pideDatosVector( v, m);
    
    int *prodMatrVect, **A;

        
    cout << "La matriz debe tener " << m 
         << "columnas. ¿Cuántos renglones tiene? ";
    cin >> n;
    // Alojar el arreglo de apuntadores a int
    A = new int *[n];

    // Alojar las columnas de A
    for( int i=0; i<n; i++)
      A[i] = new int [m];
   
    // Alojar prodMatrVect 
    prodMatrVect = new int[n]; 

    pideDatosMatriz( A, n, m);
    prodMatrizVector( A, v, prodMatrVect, n, m);
    
    cout << "El producto de A por v es:\n ";
    
    // Desplegar prodMatrVect
    for( int i=0; i<n; i++)
      cout << prodMatrVect[i] << endl;
      

    system("PAUSE");
      return EXIT_SUCCESS;
}
