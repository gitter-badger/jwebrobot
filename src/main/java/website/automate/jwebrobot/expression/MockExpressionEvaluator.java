package website.automate.jwebrobot.expression;

import java.util.Map;

public class MockExpressionEvaluator implements ExpressionEvaluator {

    @Override
    public Object evaluate(String expression, Map<String, Object> memory) {
        return expression;
    }
}