// Function 1: Print numbers up to a user-specified limit
void printNumbersUpToLimit()
begin
    int limit = 10;

    int i = 1;
    print "Numbers from 1 to " + limit;
    while i <= limit do
    begin
        print i;
        i = i + 1;
    end
    print " ";
end

// Function 2: Sum numbers from 1 up to a user-defined limit
void sumNumbersUpToLimit()
begin
    int limit, sum = 0;
    int i = 1;
    limit = 10;

    while i <= limit do 
    begin
        sum = sum + i;
        i = i+1;
    end
    print "Sum of numbers from 1 to " + limit + " is " + sum;
end

// Main function
void main() 
begin
    print "Begin Test program";

    printNumbersUpToLimit();

    sumNumbersUpToLimit();

end

/*
Expected:
Begin Test program
Numbers from 1 to 10
1
2
3
4
5
6
7
8
9
10

Sum of numbers from 1 to 10 is 55
*/