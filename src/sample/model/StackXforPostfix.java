package sample.model;

/**
 * Created by Denis on 31.03.2016.
 */
public class StackXforPostfix {
    private int top;
    private int maxSize;
    private double[] stackArray;
    public StackXforPostfix(int s) {
        // TODO Auto-generated constructor stub
        maxSize = s;
        stackArray = new double[maxSize];
        top = -1;
    }
    public void push(double c) {
        stackArray[++top] = c;
    }
    public double pop() {
        return stackArray[top--];
    }
    public double peak() {
        return stackArray[top];
    }
    public boolean isEmpty() {
        return (top==-1);
    }
    public int size(){// Òåêóùèé ðàçìåð ñòåêà
        return top+1;
    }
    public double peekN(int n){ // ×òåíèå ýëåìåíòà ñ èíäåêñîì n
        return stackArray[n];
    }
    public void displayStack(String s){
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for(int j=0; j<size(); j++){
            System.out.print( peekN(j) );
            System.out.print(' ');
        }
        System.out.println("");
    }
}
