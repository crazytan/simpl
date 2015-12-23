package simpl.interpreter;

class NilValue extends Value {

    protected NilValue() {
    }

    public String toString() {
        return "nil";
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof NilValue;
    }
}
