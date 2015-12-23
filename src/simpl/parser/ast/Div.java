package simpl.parser.ast;

import simpl.interpreter.IntValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;

public class Div extends ArithExpr {

    public Div(Expr l, Expr r) {
        super(l, r);
    }

    public String toString() {
        return "(" + l + " / " + r + ")";
    }

    @Override
    public Value eval(State s) throws RuntimeError {
        Value v1 = l.eval(s);
        Value v2 = r.eval(s);
        if ((v1 instanceof IntValue) && (v2 instanceof IntValue)) {
            if (((IntValue) v2).n == 0)
                throw new RuntimeError("divide by zero");
            return new IntValue(((IntValue) v1).n / ((IntValue) v2).n);
        }
        throw new RuntimeError("operand is not int");
    }
}
