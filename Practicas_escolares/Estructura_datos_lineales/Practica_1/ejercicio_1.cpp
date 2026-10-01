
#include <iostream>

using namespace std;



int main(){
int a;
int *ptr;

ptr = &a;
*ptr = 24;

cout<<"el valor de a es: "<<a<<"\n";
cout<<"el contenido del apuntador es: "<<ptr<<"\n";
cout<<"lo que apunta ptr es: "<<*ptr;
	
	return 0;
}
