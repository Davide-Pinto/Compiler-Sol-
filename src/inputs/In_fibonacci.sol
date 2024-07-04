/*
    Sequência de Fibonacci
*/

string fibonacciFunction(int n)
begin

    int first = 0, second = 1, next;
    int i;
    string result = "Série de Fibonacci:";

    for i = 2 to n do
    begin
        next = first + second;
        result = result + " " + next;
        first = second;
        second = next;
    end

    return result;
end

void main()
begin

    print fibonacciFunction(10);

end

//Expected: Série de Fibonacci: 1 2 3 5 8 13 21 34 55