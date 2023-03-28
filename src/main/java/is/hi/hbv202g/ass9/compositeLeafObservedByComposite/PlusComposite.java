package is.hi.hbv202g.ass9.compositeLeafObservedByComposite;

import java.util.ArrayList;
import java.util.List;

public class PlusComposite implements MathExpression, Observer {

    private List<MathExpression> components;
    private int lastObservedResult;

    public PlusComposite() {
        components = new ArrayList<>();
        lastObservedResult = 0;
    }

    public void addComponent(MathExpression component) {
        components.add(component);
        if (component instanceof Observable) {
            ((Observable) component).attach(this);
        }
    }

    public int getResult() {
        int sum = components.stream().mapToInt(MathExpression::getResult).sum();
        lastObservedResult = sum;
        return sum;
    }

    public List<MathExpression> getComponents() {
        return components;
    }

    public int getLastObservedResult() {
        return lastObservedResult;
    }

    @Override
    public void update(Observable observable) {
        getResult();
        System.out.println("PlusComposite: new result = " + lastObservedResult);
    }
}
