package website.automate.jwebrobot.executor;

import com.google.inject.Inject;

import website.automate.jwebrobot.context.ScenarioExecutionContext;
import website.automate.jwebrobot.expression.ExpressionEvaluator;
import website.automate.jwebrobot.model.Scenario;

public class ScenarioPreprocessor {

    private final ExpressionEvaluator expressionEvaluator;
    
    @Inject
    public ScenarioPreprocessor(ExpressionEvaluator expressionEvaluator) {
        this.expressionEvaluator = expressionEvaluator;
    }
    
    public Scenario preprocess(Scenario scenario, ScenarioExecutionContext context){
        Scenario preprocessedScenario = new Scenario();
        preprocessedScenario.setDescription(scenario.getDescription());
        preprocessedScenario.setFragment(scenario.isFragment());
        preprocessedScenario.setName(scenario.getName());
        preprocessedScenario.setSteps(scenario.getSteps());
        preprocessedScenario.setPrecedence(scenario.getPrecedence());
        
        preprocessedScenario.setIf(preprocessProperty(scenario.getIf(), context));
        preprocessedScenario.setUnless(preprocessProperty(scenario.getUnless(), context));
        preprocessedScenario.setTimeout(preprocessProperty(scenario.getTimeout(), context));
        return preprocessedScenario;
    }
    
    private String preprocessProperty(String value, ScenarioExecutionContext context){
        if(value == null){
            return null;
        }
        Object evaluatedExpression = expressionEvaluator.evaluate(value, context.getMemory());
        return evaluatedExpression.toString();
    }
}
