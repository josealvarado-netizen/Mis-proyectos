#include <iostream>

using namespace std;



int main(){
int *pointer_int, a, x=7;
float *pointer_float, b, y= 4.0;

pointer_int = &x;
cout<<"el contenido de x es :"<<x<<"\n";
cout<<"la dirección de x es :"<<pointer_int<<"\n";
cout<<"pointer_int contiene :"<<pointer_int<<"\n";
cout<<"pointer_int apunta a :"<<*pointer_int<<"\n";

pointer_float = &y;
cout<<"el contenido de y es :"<<y<<"\n";
cout<<"la dirección de y es :"<<pointer_float<<"\n";
cout<<"pointer_float contiene :"<<pointer_float<<"\n";
cout<<"pointer_float apunta a :"<<*pointer_float<<"\n";

a = *pointer_int;
b = *pointer_float;

cout<<"a= "<<a<<"\n"<<"b= "<<b;

	return 0;
}
