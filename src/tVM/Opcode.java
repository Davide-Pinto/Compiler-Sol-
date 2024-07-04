package tVM;

public enum Opcode {
    iconst(10, 1),  // int constant: empilha o valor n no stack
    dconst(11,1),   // real constant: empilha a constante que esta na posicao n da constant pool, no stack.
    sconst(12,1),   // string constant: empilha a constante que esta na posicao n da constant pool, no stack.
    jump(13,1),     // unconditional jump: actualiza o instruction pointer de modo a que a proxima instrucao a ser executada seja aquela que se encontra na posicao addr do array de instrucoes
    jumpt(14,1),    // jump if true: faz pop do stack. Se o valor for true, actualiza o instruction pointer de modo a que a proxima instrucao a ser executada seja aquela que se encontra na posicao addr do array de instrucoes.
    jumpf(15,1),    // jump if false: faz pop do stack. Se o valor for true, actualiza o instruction pointer de modo a que a proxima instrucao a ser executada seja aquela que se encontra na posicao addr do array de instrucoes.
    galloc(16,1),   // global memory allocation: aloca n posicoes num array que permite armazenar variaveis globais. Designemos esse array por Globals. Essas n posicoes de memoria ficam inicializadas com o valor NIL.
    gload(17,1),    // global load: empilha Globals[addr] no stack.
    gstore(18,1),   // global store: faz pop do stack e guarda o valor em Globals[addr]
    iprint(19,0),   // int print: faz pop do operando a, e escreve o seu valor no ecra
    iuminus(20,0),  // int unary minus: faz pop do operando a, e empilha-a no stack
    iadd(21,0),     // int addition: faz pop do operando direito b, seguido de pop do operando esquerdo a, e empilha a + b no stack.
    isub(22,0),     // int subtraction: faz pop do operando direito b, seguido de pop do operando esquerdo a, e empilha a − b no stack.
    imult(23,0),    // int multiplication: faz pop do operando direito b, seguido de pop do operando esquerdo a, e empilha a ∗ b no stack.
    idiv(24,0),     // int division: faz pop do operando direito b, seguido de pop do operando esquerdo a, e empilha a/b no stack.
    imod(25,0),     // int modulus: faz pop do operando direito b, seguido de pop do operando esquerdo a, e empilha o resto da divisao de a por b no stack.
    ieq(26,0),      // int equal: faz pop do operando direito b, seguido de pop do operando esquerdo a, e empilha o valor logico de a == b no stack.
    ineq(27,0),     // int not equal: faz pop do operando direito b, seguido de pop do operando esquerdo a, e empilha o valor logico de a 6= b no stack.
    ilt(28,0),      // int less than faz pop do operando direito b, seguido de pop do operando esquerdo a, e empilha o valor logico de a < b no stack
    ileq(29,0),     // int less or equal faz pop do operando direito b, seguido de pop dooperando esquerdo a, e empilha o valor logico de a ≤ b no stack.
    itod(30,0),     // int to real converte o valor int que esta no topo do stack para um valor real
    itos(31,0),     // int to string converte o valor int que esta no topo do stack para uma string. Ex: 53 e convertido para “53”
    dprint(32,0),   // equivalente a iprint, mas para um valor real
    duminus(33,0),  // equivalente a iuminus, mas para um valor real.
    dadd(34,0),     // equivalente a iadd, mas para valores do tipo real.
    dsub(35,0),     // equivalente a isub, mas para valores do tipo real.
    dmult(36,0),    // equivalente a imult, mas para valores do tipo real.
    ddiv(37,0),     // equivalente a idiv, mas para valores do tipo real.
    deq(38,0),      // equivalente a ieq, mas para valores do tipo real.
    dneq(39,0),     // equivalente a ineq, mas para valores do tipo real.
    dlt(40,0),      // equivalente a ilt, mas para valores do tipo real.
    dleq(41,0),     // equivalente a ileq, mas para valores do tipo real.
    dtos(42,0),     // equivalente a itos, mas para valores do tipo real.
    sprint(43,0),   // equivalente a iprint, mas para valores do tipo real.
    sadd(44,0),     // string concatenation: faz pop do operando direito b, seguido de pop do operando esquerdo a, e empilha a concatenado com b no stack.
    seq(45,0),      // equivalente a ieq, mas para strings.
    sneq(46,0),     // equivalente a ineq, mas para strings.
    bprint(47,0),   // equivalente a iprint, mas para um valor do tipo bool.
    beq(48,0),      // equivalente a ieq, mas para valores do tipo bool.
    bneq(49,0),     // equivalente a ineq, mas para valores do tipo bool.
    btos(50,0),     // equivalente a itos, mas para um valor do tipo bool. Ex: true e convertido para “true”.
    halt(51,0),     // termina a execucao do programa.
    spool(52,1),    // string in pool, arg is the size of the string
    dpool(53,1),    // double in pool, arg is the size of the double
    and(54,0),
    or(55,0),
    not(56,0),
    tconst(57,0),
    fconst(58,0),
    call(59,1),
    lalloc(60,1),
    lload(61,1),
    lstore(62,1),
    pop(63,1),
    retval(64,1),
    ret(65,1);



    private final int opcode;
    private final int numArgs;

    Opcode(int opcode, int numArgs){
        this.opcode = opcode;
        this.numArgs = numArgs;
    }

    public int getOpcode(){
        return opcode;
    }

    public int getNumArgs() {
        return numArgs;
    }

    public static Opcode valueOf(int opcode) {
        for (Opcode op : Opcode.values()) {
            if (op.getOpcode() == opcode) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown opcode: " + opcode);
    }

}
