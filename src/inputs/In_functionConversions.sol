int global_int = 10;
real global_real = 5.5;

real simpleSum(real a, int b)
begin
	real result = a + b;
	return result;
end

string unusedFunction(string a, string b)
begin
	string result = a + b;
	return result;
end


void main()
begin
	real globalSum, localSum, finalSum;

	int local_int = 10;
	real local_real = 5.5;

	bool a = false;
	bool b = false;

	globalSum = simpleSum(global_real, global_int);
	print "Global Sum is: " + globalSum;

	localSum = simpleSum(local_real, local_int);
	print "Local Sum is: " + localSum;

	finalSum = globalSum + localSum;
	print "The sum between those two sums is: " + finalSum;

	print a == b;

end

/*
Expected:
Global Sum is: 15.5
Local Sum is: 15.5
The sum between those two sums is: 31.0
true
*/