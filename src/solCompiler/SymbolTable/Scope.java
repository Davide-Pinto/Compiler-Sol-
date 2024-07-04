package solCompiler.SymbolTable;

import java.util.LinkedHashMap;
import java.util.Map;

public class Scope {
    Scope enclosingScope;
    String name;
    public Map<String, Symbol> symbols = new LinkedHashMap<String,Symbol>();

    public Scope(Scope enclosingScope){
        this.enclosingScope = enclosingScope;
        this.name = "noname";
    }

    public Scope(Scope enclosingScope, String name){
        this.enclosingScope = enclosingScope;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Scope getEnclosingScope() {
        return enclosingScope;
    }

    public VariableSymbol getVariableSymbol(String name){
        Symbol s = resolve_local(name);
        if(s instanceof VariableSymbol){
            return (VariableSymbol) s;
        }
        if(enclosingScope != null) return enclosingScope.getVariableSymbol(name);
        return null;// not found
    }

    public FunctionSymbol getFuctionSymbol(String name){
        Symbol s = resolve_local(name);
        if(s instanceof FunctionSymbol){
            return (FunctionSymbol) s;
        }
        if(enclosingScope != null) return enclosingScope.getFuctionSymbol(name);
        return null;// not found
    }

    public Symbol resolve_local(String name){
        return symbols.get(name);
    }

    public Symbol resolve(String name){
        Symbol s = resolve_local(name);
        if(s!=null) return s;
        if(enclosingScope != null) return enclosingScope.resolve(name);
        return null;// not found
    }

    public boolean contains(String name){
        Symbol s = resolve(name);
        return s != null;
    }

    public void define(Symbol sym){
        symbols.put(sym.lexeme(), sym);
        sym.scope = this;
    }




}
