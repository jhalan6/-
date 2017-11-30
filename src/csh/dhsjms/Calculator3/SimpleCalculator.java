package hwt.Calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimpleCalculator {
    public static List<Character> operators = new ArrayList<Character>();
    private static boolean calculated = false;

    static {
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
    }


    public static boolean isCalculated() {
        return calculated;
    }

    public static void setCalculated(boolean calculated) {
        SimpleCalculator.calculated = calculated;
    }

    public static String calculate(String text) {
        calculated = true;
        if (text == null || text.isEmpty()) {
            return 0 + "";
        }

        Stack<Double> numStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        int stringIndex = 0;
        int nextStringStart = 0;

        for (Character character : text.toCharArray()) {
            if (operators.contains(character)) {
                String aNum = text.substring(nextStringStart, stringIndex);
                int a = Integer.parseInt(aNum);
                if (operatorStack.isEmpty()) {
                    numStack.push(((double) a));
                } else {
                    if (operatorStack.peek().equals('*')) {
                        operatorStack.pop();
                        numStack.push(numStack.pop() * a);
                    } else if (operatorStack.peek().equals('/')) {
                        operatorStack.pop();
                        numStack.push(numStack.pop() / a);
                    } else {
                        numStack.push((double) a);
                    }
                }
                nextStringStart = stringIndex + 1;
            }
            stringIndex++;
        }

        numStack.add(Double.parseDouble(text.substring(nextStringStart, stringIndex)));

        if (operatorStack.peek().equals('*')) {
            operatorStack.pop();
            double a =numStack.pop();
            numStack.push(numStack.pop() * a);
        } else if (operatorStack.peek().equals('/')) {
            operatorStack.pop();
            double a =numStack.pop();
            numStack.push(numStack.pop() / a);
        }

        Double result = (double) 0;
        while (!operatorStack.isEmpty()) {
            Character operator = operatorStack.pop();
            Double a;
            if (operator.equals('+')) {
                result += numStack.pop();
            } else {
                result -= numStack.pop();
            }
        }

        result += numStack.pop();

        return String.valueOf(result);
    }
}
