/// VARIABLES ///

int five = 5;
int ten = 10;
int fifty = 50;
int twenty_five = 25;
int hundred = 100;
int seventy_five = 75;

// FUNCTIONS ////

int returnBiggerInt(int arg1, int arg2)
begin
	if arg1 >= arg2 then
		return arg1;
	else
		return arg2;
end

int returnLesserInt(int arg1, int arg2)
begin
	if arg1 <= arg2 then
		return arg1;
	else
		return arg2;
end

int sum(int arg1, int arg2)
begin
	int result = arg1 + arg2;
	return result;
end

int sub(int arg1, int arg2)
begin
	int result = arg1 - arg2;
	return result;
end

/// MAIN ////

void main()
begin
	int final_result;

	final_result = sum(returnBiggerInt(ten, fifty), fifty) + sub(returnBiggerInt(seventy_five, five), returnLesserInt(twenty_five, sum(fifty, fifty)));
	print final_result;

end

// Expected: 150