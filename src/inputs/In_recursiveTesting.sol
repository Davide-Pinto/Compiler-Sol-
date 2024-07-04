// VARIABLES

int global_counter = 1;
int i;

string a = "a";

// FUNCTIONS

void addIntToGlobalCounter(int var)
begin
    global_counter = global_counter + var;
end

string recursiveStringFunction(string str)
begin
    string changedString = "";
    string solution = "";
    if str == "aaaa" then
        return str;
    else
    begin
        changedString = str + "a";
        solution = recursiveStringFunction(changedString);
        return solution;
    end
end

void main()
begin

    string solution = "";
    int number = 15;

    // Add one to global_counter
    for i = 1 to 10 do
    begin
        addIntToGlobalCounter(number);
    end
    print global_counter;
    
    // Recursive String Function Test
    
    solution = recursiveStringFunction(a);
    print solution;
    
end

/*
Expected:
151
aaaa
*/