/*
    Calculadora Factorial
*/

int fatorialCalculator(int number)
begin

    int factorial = 1;
    int i;
    for i = 1 to number do
        factorial = factorial*i;
    return factorial;
end

void main()
begin
    int num = 10;
    int factorial = fatorialCalculator(num);

    print "Factorial de " + num + " é " + factorial;

end
//Expected: Factorial de 10 é 3628800