void printReal(real arg1)
begin
	print arg1;
end

bool isOdd(int arg)
begin
	if arg % 2 == 0 then
		begin
			return true;
			print arg + " is odd";
		end
	else
		begin
			return false;
			print arg + " is even";
		end
end

real simpleSumReals(real arg1, real arg2)
begin
	real solution = arg1 + arg2;
	print "The sum between " + arg1 + " and " + arg2 + " is: " + solution;
	return solution;
end

real simpleSumIntsToReal(int arg1, int arg2)
begin
	int solution = arg1 + arg2;
	print "The sum between " + arg1 + " and " + arg2 + " is: " + solution;
	return solution;
end

void main()
begin

	real realVar_1, realVar_2, realVar_3, realVar_4;
	int intVar_1, intVar_2;
	bool boolVar_1, boolVar_2;

	realVar_1 = 0.5;
	realVar_2 = 0.5;

	intVar_1 = 10;
	intVar_2 = 5;

	realVar_3 = simpleSumReals(realVar_1, realVar_2);
	realVar_4 = simpleSumIntsToReal(intVar_1, intVar_2);

	print "---";
	printReal(realVar_3);
	printReal(realVar_4);

end

/*
Expected:
The sum between 0.5 and 0.5 is: 1.0
The sum between 10 and 5 is: 15
---
1.0
15.0
*/