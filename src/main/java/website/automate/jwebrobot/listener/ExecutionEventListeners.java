package website.automate.jwebrobot.listener;

import java.util.HashSet;
import java.util.Set;

import com.google.inject.Inject;

import website.automate.jwebrobot.context.GlobalExecutionContext;
import website.automate.jwebrobot.context.ScenarioExecutionContext;
import website.automate.jwebrobot.model.Action;

public class ExecutionEventListeners implements ExecutionEventListener {

    private Set<ExecutionEventListener> listeners = new HashSet<>();
    
    @Inject
    public ExecutionEventListeners(Set<ExecutionEventListener> listeners){
        this.listeners = listeners;
    }
    
    @Override
    public void beforeScenario(ScenarioExecutionContext context) {
        for(ExecutionEventListener listener : listeners){
            listener.beforeScenario(context);
        }
    }

    @Override
    public void afterScenario(ScenarioExecutionContext context) {
        for(ExecutionEventListener listener : listeners){
            listener.afterScenario(context);
        }
    }

    @Override
    public void errorScenario(ScenarioExecutionContext context, Exception exception) {
        for(ExecutionEventListener listener : listeners){
            listener.errorScenario(context, exception);
        }
    }

    @Override
    public void beforeAction(ScenarioExecutionContext context, Action action) {
        for(ExecutionEventListener listener : listeners){
            listener.beforeAction(context, action);
        }
    }

    @Override
    public void afterAction(ScenarioExecutionContext context, Action action) {
        for(ExecutionEventListener listener : listeners){
            listener.afterAction(context, action);
        }
    }

    @Override
    public void errorAction(ScenarioExecutionContext context, Action action, Exception exception) {
        for(ExecutionEventListener listener : listeners){
            listener.errorAction(context, action, exception);
        }
    }

    @Override
    public void beforeExecution(GlobalExecutionContext context) {
        for(ExecutionEventListener listener : listeners){
            listener.beforeExecution(context);
        }
    }

    @Override
    public void afterExecution(GlobalExecutionContext context) {
        for(ExecutionEventListener listener : listeners){
            listener.afterExecution(context);
        }
    }

    @Override
    public void errorExecution(GlobalExecutionContext context, Exception exception) {
        for(ExecutionEventListener listener : listeners){
            listener.errorExecution(context, exception);
        }
    }

}
