#include <iostream>
using namespace std;

int fibonacci(int n);

int main(){
	int n;
	cout << "¿Qué elemento de la serie fibonacci necesitas? ";
	cin  >> n;
	 for (int i = 1; i <= n; ++i) {
        cout << fibonacci(i) << " ";
    }
    cout << endl;
	cout << "El elemento " << n << " de la serie es: " << fibonacci(n) << endl;
}

int fibonacci(int n){
	int fb;
	if(n <= 2)
	fb = 1;
	else 
	return  fibonacci(n-1) + fibonacci(n-2);
}
