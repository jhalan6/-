package csh.dhsjms.Calculator3;

import java.util.ArrayList;
import java.util.List;

public class SimpleCalculator {
    private float operated, operating;
    private Character operate = null;
    public static List<Character> operators = new ArrayList<Character>();

    static {
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
    }

    private float cal() {
        if (operate.equals('+')) {
            return operated + operating;
        } else if (operate.equals('-')) {
            return operated - operating;
        } else if (operate.equals('*')) {
            return operated * operating;
        } else if (operate.equals('/')) {
            return operated / operating;
        } else {
            return 0;
        }
    }

    public String getErrorMessage() {
        return null;
    }

    public float run(float operated, char operate, float operating) {
        this.operated = operated;
        this.operating = operating;
        this.operate = operate;
        return cal();
    }

    public static String calculate(String text) {
        if (text == null || text.isEmpty()){
            return 0 + "";
        }
        return null;
    }
}
