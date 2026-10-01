#include <iostream>

using namespace std;



int main(){
int i = 10, j = 0, *p, **q;

p = &i;
j = *p + 1;

cout<<"el valor de j es: "<<j<<"\n"<<"la direccion de j es: "<<&j<<"\n";

*p = 20;

cout<<"el valor de i es: "<<i<<"\n"<<"la direccion de i es: "<<&i<<"\n";

p = &j;
q = &p;

cout<<"lo que apunta **q es: "<<**q<<"\n";

i = 2 + **q;

cout<<"el valor de i es: "<< i;

	return 0;
}
