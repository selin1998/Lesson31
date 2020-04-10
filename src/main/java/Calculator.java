import java.util.Optional;

public class Calculator {

    public Optional<Integer> parse(String s){
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public int operate(String a,String b, String op) throws Exception {

        Integer aa= parse(a).orElseThrow(Exception::new);
        Integer bb= parse(b).orElseThrow(Exception::new);

        switch(op){
            case "add": return aa+bb;
            case "sub": return aa-bb;
            case "mult": return aa*bb;
            case "div": return division(aa,bb).orElseThrow(Exception::new);

        }
        return 0;
    }

    private Optional<Integer> division(int a, int b) {
        if (b==0) return Optional.empty();
        return Optional.of(a/b);
    }

    public String calculate(String a,String b,String op) throws Exception {
        return String.format("%s %s %s = %d",a,op,b,operate(a,b,op));
    }
}
