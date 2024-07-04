void func_1(int a, real b)
begin
	real result = a + b;
	return result;
end

int func_2(bool a)
begin
	return not a;
end

void main()
begin
	int int_var_1 = 10;
	real real_var_1 = 15.0;
	string string_var = func_1(int_var_1, real_var_1);

	func_2();
end

/* Expected:
 line 16:8  error: operator = is invalid between string and void.
 line 18:1  error: func_2 has 1 arguments not 0
 line 18:1  error: value of 'func_2' should be assigned to a variable.
 3 Semantic errors detected, exiting program.
 */