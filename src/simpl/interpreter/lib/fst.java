package simpl.interpreter.lib;

import simpl.interpreter.Env;
import simpl.interpreter.FunValue;
import simpl.interpreter.PairValue;
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

public class fst extends FunValue {

    public fst() {
        super(Env.empty, Symbol.symbol("x"), new UnaryExpr(new Name(Symbol.symbol("x"))) {
            @Override
            public TypeResult typecheck(TypeEnv E) throws TypeError {
                // TODO
                return null;
            }

            @Override
            public Value eval(State s) throws RuntimeError {
                Value v = e.eval(s);
                if (v instanceof PairValue) {
                    return ((PairValue) v).v1;
                }
                throw new RuntimeError("operand is not pair");
            }
        });
    }
}
