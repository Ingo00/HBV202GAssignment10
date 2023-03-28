package is.hi.hbv202g.ass9.compositeLeafObserverTemplateMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class MathComposite implements MathExpression, Observer {

    protected List<MathExpression> children;
    protected int lastObservedResult;

    public MathComposite() {
        children = new ArrayList<>();
        lastObservedResult = 0;
    }

    public void addChild(MathExpression child) {
        children.add(child);
        if (child instanceof Observable) {
            ((Observable) child).attach(this);
        }
    }

    protected abstract int doOperation(List<MathExpression> children);

    public int getResult() {
        int result = doOperation(children);
        lastObservedResult = result;
        return result;
    }

    public List<MathExpression> getChildren() {
        return children;
    }

    public int getLastObservedResult() {
        return lastObservedResult;
    }

    @Override
    public void update(Observable observable) {
        getResult();
        System.out.println(getClass().getSimpleName() + ": new result = " + lastObservedResult);
    }

    public void add(MultiplyComposite multiplyComposite) {
    }
}
