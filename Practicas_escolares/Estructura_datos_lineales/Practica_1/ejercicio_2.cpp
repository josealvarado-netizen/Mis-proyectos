#include <iostream>

using namespace std;



int main(){
int *a, *b, *c;
int i, j;

a = b = &i;
c = &j;
*b = 5;
*c = 2;
*a = (*b * 2) + *c;

cout<<"el valor de i es: "<<i<<"\n";
cout<<"el valor de j es: "<<j;
	
	return 0;
}
