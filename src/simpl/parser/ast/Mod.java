package simpl.parser.ast;

import simpl.interpreter.IntValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;

public class Mod extends ArithExpr {

    public Mod(Expr l, Expr r) {
        super(l, r);
    }

    public String toString() {
        return "(" + l + " % " + r + ")";
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        IntValue v1 = (IntValue) l.eval(s);
        IntValue v2 = (IntValue) r.eval(s);
        if (v2.n == 0)
            throw new RuntimeError("divide by zero");
        return new IntValue(v1.n % v2.n);
    }
}
