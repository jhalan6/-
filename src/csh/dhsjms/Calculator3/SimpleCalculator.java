package csh.dhsjms.Calculator3;

import java.util.Objects;

public class SimpleCalculator {
    private float operated, operating;
    private String operate = null;

    private float cal() {
        if (Objects.equals(operate, "+")) {
            return operated + operating;
        } else if (Objects.equals(operate, "-")) {
            return operated - operating;
        } else if (Objects.equals(operate, "*")) {
            return operated * operating;
        } else if (Objects.equals(operate, "/")) {
            return operated / operating;
        } else {
            return 0;
        }
    }

    public String getErrorMessage() {
        return null;
    }

    public float run(float operated, String operate, float operating) {
        this.operated = operated;
        this.operating = operating;
        this.operate = operate;
        return cal();
    }
}
