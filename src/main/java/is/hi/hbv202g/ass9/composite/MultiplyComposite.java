package is.hi.hbv202g.ass9.composite;

import is.hi.hbv202g.ass9.compositeLeafObserverTemplateMethod.MathComposite;

import java.util.ArrayList;
import java.util.List;

public class MultiplyComposite implements MathExpression{
    private List<MathExpression> componement;

    public MultiplyComposite() {
        componement = new ArrayList<>();
    }

    public void add(MathExpression mathExpression) {
        componement.add(mathExpression);
    }
    @Override
    public int getResult() {
        int result = 1;
        for (MathExpression mathExpression : componement) {
            result *= mathExpression.getResult();
        }
        return result;
    }
}
