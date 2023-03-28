package is.hi.hbv202g.ass9.compositeLeafObserverTemplateMethod;

import java.util.List;

public class PlusComposite extends MathComposite {

    public PlusComposite() {
        super();
    }

    @Override
    protected int doOperation(List<MathExpression> children) {
        int sum = children.stream().mapToInt(MathExpression::getResult).sum();
        return sum;
    }
}
