/*
    This test, a while inside a while with if's and breaks
*/

void check_odd_even(int x, int n)
begin
    int line = 0;
    begin
        while x < n do
            begin
                x = x+1;
                if x%2==0 then
                    begin
                        print line + ": " + x + " is par!!";
                        line = line + 1;
                    end
                else
                    begin
                        print line + ": " + x + " is impar!!";
                        line = line + 1;
                    end
                if x == 15.0 then
                    begin
                        print line + ": " + "x == 15, time to count down";
                        line = line + 1;
                        while x > 1 do
                        begin
                            x = x-1;
                            if x%2==0 then
                                begin
                                    print line + ": " + x + " is par!!";
                                    line = line + 1;
                                end
                            else
                                begin
                                    print line + ": " + x + " is impar!!";
                                    line = line + 1;
                                end
                        end
                        print "This was fun, type to give a break";
                        line = line + 1;
                        break;
                    end
           end
    end
end

void main()
begin
    int min = 0, max = 30;

    check_odd_even(min, max);
end

/*Expected
    0: 1 is impar!!
    1: 2 is par!!
    2: 3 is impar!!
    3: 4 is par!!
    4: 5 is impar!!
    5: 6 is par!!
    6: 7 is impar!!
    7: 8 is par!!
    8: 9 is impar!!
    9: 10 is par!!
    10: 11 is impar!!
    11: 12 is par!!
    12: 13 is impar!!
    13: 14 is par!!
    14: 15 is impar!!
    15: x == 15, time to count down
    16: 14 is par!!
    17: 13 is impar!!
    18: 12 is par!!
    19: 11 is impar!!
    20: 10 is par!!
    21: 9 is impar!!
    22: 8 is par!!
    23: 7 is impar!!
    24: 6 is par!!
    25: 5 is impar!!
    26: 4 is par!!
    27: 3 is impar!!
    28: 2 is par!!
    29: 1 is impar!!
    This was fun, type to give a break

*/

