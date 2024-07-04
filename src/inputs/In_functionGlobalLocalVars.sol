int a = 1;
int b = 2;
int c;

void void_1()
begin
end

void void_2()
begin
  void_1();
end

void void_3()
begin
  void_2();
end

void void_4()
begin
  void_3();
end

void void_5()
begin
  void_4();
end

int sum(int a, int b)
begin
  int result = a + b;
  return result;
end

void main()
begin
  c = sum(a, b);
  void_5();

  print c;
end

//Expected: 3