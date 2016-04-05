package sample.model;

/**
 * Created by Denis on 31.03.2016.
 */
public class ParsePostnew {
    private StackXforPostfix theStack;
    private String input, input1;
    public ParsePostnew(String s) {
        input1 = s;
    }
    public double doParse() {
        theStack = new StackXforPostfix(20);
        //String[] ch;
        int j;
        double num1=0, num2=0, interAns = 0;
        input = input1.trim();
        String [] ch  = input.split(" ");
        for (j = 0; j < ch.length; j++) {
            theStack.displayStack(" "+ch[j]+" ");
            if (!ch[j].equals("+") && !ch[j].equals("-") && !ch[j].equals("*") && !ch[j].equals("/")
                    && !ch[j].equals("^") && !ch[j].equals("sqr") && !ch[j].equals("!")) {
                theStack.push(Double.parseDouble(ch[j]));
            }
            else {
                if (!theStack.isEmpty())
                    num2 = theStack.pop();
                if (!theStack.isEmpty())
                num1 = theStack.pop();
                switch(ch[j]) {
                    case "+":
                        interAns = num1+num2;
                        break;
                    case "-":
                        interAns = num1-num2;
                        break;
                    case "*":
                        interAns = num1*num2;
                        break;
                    case "/":
                        interAns = num1/num2;
                        break;
                    case "^":
                        interAns = Math.pow(num1, num2);
                        break;
                    case "sqr":  interAns = Math.pow(num2, 1/num1);
                        break;
                    case "!": interAns = factorial(num2);
                        break;
                    default: interAns = 0;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;

    }
    public double factorial(double num1) {
        double fact = 1;
        for (int i = 2; i <= num1; i++)
            fact *= i;
        return fact;
    }
}