package simpl.interpreter;

public class PairValue extends Value {

    public final Value v1, v2;

    public PairValue(Value v1, Value v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public String toString() {
        return "pair@" + v1 + "@" + v2;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof PairValue) {
            PairValue v = (PairValue) other;
            return v1.equals(v.v1) && v2.equals(v.v2);
        }
        return false;
    }
}
