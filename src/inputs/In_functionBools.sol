void printVariable(bool var)
begin
  print var;
end

bool boolInverse(bool boolVar)
begin
  return not boolVar;
end

void main()
begin
  bool booleanVariable_1 = true;
  bool booleanVariable_2, booleanVariable_3 = false;
  booleanVariable_2 = boolInverse(booleanVariable_1) or (not booleanVariable_3);
  printVariable(booleanVariable_2);
end

//Expected: true