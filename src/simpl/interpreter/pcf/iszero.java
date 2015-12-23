package simpl.interpreter.pcf;

import simpl.interpreter.BoolValue;
import simpl.interpreter.Env;
import simpl.interpreter.FunValue;
import simpl.interpreter.IntValue;
import simpl.interpreter.RuntimeError;
import simpl.interpreter.State;
import simpl.interpreter.Value;
import simpl.parser.Symbol;
import simpl.parser.ast.Expr;
import simpl.parser.ast.Name;
import simpl.parser.ast.UnaryExpr;
import simpl.typing.TypeEnv;
import simpl.typing.TypeError;
import simpl.typing.TypeResult;

public class iszero extends FunValue {

    public iszero() {
        super(Env.empty, Symbol.symbol("x"), new UnaryExpr(new Name(Symbol.symbol("x"))) {
            @Override
            public TypeResult typecheck(TypeEnv E) throws TypeError {
                // TODO
                return null;
            }

            @Override
            public Value eval(State s) throws RuntimeError {
                Value v = e.eval(s);
                if (v instanceof IntValue) {
                    return new BoolValue(((IntValue) v).n == 0);
                }
                throw new RuntimeError("operand is not int");
            }
        });
    }
}
