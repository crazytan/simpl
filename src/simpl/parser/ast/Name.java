package simpl.parser.ast;

import simpl.interpreter.RecValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;
import simpl.parser.Symbol;
import simpl.typing.Type;
import simpl.typing.TypeEnv;
import simpl.typing.TypeError;
import simpl.typing.TypeResult;

public class Name extends Expr {

    public Symbol x;

    public Name(Symbol x) {
        this.x = x;
    }

    public String toString() {
        return "" + x;
    }

    @Override
    public TypeResult typecheck(TypeEnv E) throws TypeError {
        // TODO
        return null;
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        Value v = s.E.get(x);
        if (v == null) throw new RuntimeError("name not found");
        if (v instanceof RecValue) {
            RecValue _v = (RecValue) v;
            return (new Rec(_v.x, _v.e)).eval(State.of(_v.E, s.M, s.p));
        }
        return v;
    }
}
