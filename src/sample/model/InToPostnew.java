package sample.model;

/**
 * Created by Denis on 31.03.2016.
 */
public class InToPostnew {
    private StackXnew theStack;
    private String output = "";
    private String input;
    String deco;
    public InToPostnew(String in) {
        input = in;
        theStack = new StackXnew(input.length());
    }
    public String doTrans() {
        String ch[] = input.split(" ");
        for (int j = 0; j < ch.length; j++) {
            theStack.displayStack("For "+ch[j]+" ");//diagnostic
            switch(ch[j]) {
                case "+":
                case "-":
                    gotOper(ch[j], 1);
                    break;
                case "*":
                case "/":
                    gotOper(ch[j], 2);
                    break;
                case "^":
                case "sqr":
                case "!" :
                    gotOper(ch[j], 3);
                    break;
                case "(":
                    theStack.push(ch[j]);
                    break;
                case ")":
                    gotParen(ch[j]);
                    break;
                default:
                    output = output +" "+ ch[j];
                    break;
            }
        }
        while (!theStack.isEmpty()) {
            theStack.displayStack("While ");
            output = output + " "+theStack.pop();
        }
        theStack.displayStack("End ");
        return output;
    }
    public void gotOper(String opThis, int prec1) {
        while (!theStack.isEmpty()){
            String opTop = theStack.pop();
            if (opTop.equals("(")){
                theStack.push(opTop);
                break;
            }
            else {
                int prec2;
                if (opTop.equals("+") || opTop.equals("-")) prec2=1;
                else if (opTop.equals("^")) prec2=3;
                else if (opTop.equals("sqr")) prec2=3;
                else if (opTop.equals("!")) prec2 =3;
                else prec2=2;
                if (prec2<prec1) {
                    theStack.push(opTop);
                    break;
                }
                else
                    output = output + " "+ opTop;
            }
        }
        theStack.push(opThis);
    }
    public void gotParen(String ch) {
        while (!theStack.isEmpty()) {
            String chx = theStack.pop();
            if (chx.equals("(")) {
                break;
            }
            else
                output = output +" "+ chx;
        }
    }
}
