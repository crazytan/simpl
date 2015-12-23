package simpl.parser.ast;

import simpl.interpreter.BoolValue;
import simpl.interpreter.IntValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;

public class LessEq extends RelExpr {

    public LessEq(Expr l, Expr r) {
        super(l, r);
    }

    public String toString() {
        return "(" + l + " <= " + r + ")";
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        Value v1 = l.eval(s);
        Value v2 = r.eval(s);
        if ((v1 instanceof IntValue) && (v2 instanceof IntValue)) {
            return new BoolValue(((IntValue) v1).n <= ((IntValue) v2).n);
        }
        throw new RuntimeError("operand is not int");
    }
}
