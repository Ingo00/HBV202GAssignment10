package is.hi.hbv202g.ass9.compositeLeafObserverTemplateMethod;

import java.util.ArrayList;
import java.util.List;

public class MultiplyComposite implements MathExpression, Observer {
    private List<MathExpression> expressions;
    private int lastObservedResult;

    public MultiplyComposite() {
        expressions = new ArrayList<>();
    }

    public void addExpression(MathExpression expression) {
        expressions.add(expression);
        if (expression instanceof Observable) {
            ((Observable) expression).attach(this); // attaches this object as an observer of the expression
        }
    }

    @Override
    public int getResult() {
        int result = 1;
        for (MathExpression expression : expressions) {
            result *= expression.getResult();
        }
        lastObservedResult = result; // stores the result of the most recent calculation
        return result;
    }

    @Override
    public void update(Observable observable, Object arg) {
        getResult(); // recalculate the result when an observed object changes
        System.out.println("New result: " + lastObservedResult); // print the new result to the screen
    }
}
