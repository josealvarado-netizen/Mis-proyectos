#include <iostream>

using namespace std;

long int factorial(long int n);

int main() {
    long int n;
    cout << "Introduce un numero entero para obtener su factorial\n";
    cin >> n;

    cout << "\nEl factorial de " << n << " es " << factorial(n) << endl;

    return 0;
}

long int factorial(long int n) {
    if (n > 1) {
       long int result = n * factorial(n - 1);
       cout << "se despliega un  " << result << endl;
       return result;
    } else {
        cout << "se despliega un " << n << endl;
        return 1;
    }
}

