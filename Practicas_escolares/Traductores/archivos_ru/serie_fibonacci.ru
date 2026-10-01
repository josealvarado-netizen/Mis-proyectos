a = 1;
b = 1;
contador = 3;
limite = 10;

imprime a;
imprime b;

while (contador <= limite) {
    c = a + b;
    imprime c;
    a = b;
    b = c;
    contador = contador + 1;
}
