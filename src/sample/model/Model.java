package sample.model;

/**
 * Created by Denis on 31.03.2016.
 */
public class Model {
    public double operate(double number1, double number2, String operator) {
        if (operator.equals("+")) return number1+number2;
        else if (operator.equals("-")) return number1-number2;
        else if (operator.equals("*")) return number1*number2;
        else if (operator.equals("/")) {
            if (number2==0) {
                return 0;
            }
            else
            return number1/number2;
        }
        else return 0;
    }
    public double oneDeleteX(double number1) {

        return 1/number1;
    }

}
