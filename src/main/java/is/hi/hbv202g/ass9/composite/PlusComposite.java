package is.hi.hbv202g.ass9.composite;

import java.util.ArrayList;
import java.util.List;

public class PlusComposite implements MathExpression{
    private List<NumberLeaf> numberLeafs;

    public PlusComposite() {
        numberLeafs = new ArrayList<>();
    }

    public void add(NumberLeaf numberLeaf) {
        numberLeafs.add(numberLeaf);
    }
    @Override
    public int getResult() {
        int result = 0;
        for (NumberLeaf numberLeaf : numberLeafs) {
            result += numberLeaf.getResult();
        }
        return result;
    }
}
