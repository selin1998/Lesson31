package entities;

public class Operation {

    String a;
    String b;
    String operation;
    String result;

    public Operation( String a, String b, String operation, String result) {

        this.a = a;
        this.b = b;
        this.operation = operation;
        this.result = result;
    }


    @Override
    public String toString() {
        return "Operation{" +
                "a=" + a +
                ", b=" + b +
                ", operation='" + operation + '\'' +
                ", result=" + result +
                '}';
    }
}
