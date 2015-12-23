package simpl.interpreter;

public class ConsValue extends Value {

    public final Value v1, v2;

    public ConsValue(Value v1, Value v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public String toString() {
        int cnt = 1;
        Value v = v2;
        while (v instanceof ConsValue) {
            cnt++;
            v = ((ConsValue) v2).v2;
        }
        return "list@" + cnt;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof ConsValue) {
            ConsValue v = (ConsValue) other;
            return (v1.equals(v.v1)) && (v2.equals(v.v2));
        }
        return false;
    }
}
