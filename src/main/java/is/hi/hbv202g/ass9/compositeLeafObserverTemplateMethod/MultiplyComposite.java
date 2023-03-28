package is.hi.hbv202g.ass9.compositeLeafObserverTemplateMethod;

import java.util.List;

public class MultiplyComposite extends MathComposite {

    public MultiplyComposite() {
        super();
    }

    @Override
    protected int doOperation(List<MathExpression> children) {
        int result = 1;
        for (MathExpression child : children) {
            result *= child.getResult();
        }
        return result;
    }
}
