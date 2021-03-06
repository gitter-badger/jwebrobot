package website.automate.jwebrobot.executor.action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.inject.Inject;

import website.automate.jwebrobot.context.ScenarioExecutionContext;
import website.automate.jwebrobot.executor.filter.ElementFilterChain;
import website.automate.jwebrobot.expression.ConditionalExpressionEvaluator;
import website.automate.jwebrobot.expression.ExpressionEvaluator;
import website.automate.jwebrobot.listener.ExecutionEventListeners;
import website.automate.jwebrobot.model.Action;
import website.automate.jwebrobot.model.ActionType;

public class SelectActionExecutor extends FilterActionExecutor {

    private static final String OPTION = "option";

    @Inject
    public SelectActionExecutor(ExpressionEvaluator expressionEvaluator,
            ExecutionEventListeners listener,
            ElementFilterChain elementFilterChain,
            ConditionalExpressionEvaluator conditionalExpressionEvaluator) {
        super(expressionEvaluator, listener,
                elementFilterChain,
                conditionalExpressionEvaluator);
    }
    
    @Override
    public ActionType getActionType() {
        return ActionType.SELECT;
    }

    @Override
    public void perform(final Action action, final ScenarioExecutionContext context) {
        WebDriver driver = context.getDriver();

        WebElement element = (new WebDriverWait(driver, getActionTimeout(action, context))).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                return filter(context, action);
            }
        });

        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();

        if (element.getTagName().equalsIgnoreCase(OPTION)) {
            element.click();
        } else {
            Select select = new Select(element);
            select.selectByValue(action.getValue());
        }

    }

}
