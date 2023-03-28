package is.hi.hbv202g.ass9.composite;

import java.util.ArrayList;
import java.util.List;

public class PlusComposite implements MathExpression{
    private List<MathExpression> componement;

    public PlusComposite() {
        componement = new ArrayList<>();
    }

    public void add(MathExpression mathExpression) {
        componement.add(mathExpression);
    }
    @Override
    public int getResult() {
        int result = 0;
        for (MathExpression mathExpression : componement) {
            result += mathExpression.getResult();
        }
        return result;
    }
}
