package ua.nikiforov.guice.factory.plain;

import ua.nikiforov.guice.factory.ValueSupplier;
import ua.nikiforov.guice.factory.Task;
import ua.nikiforov.guice.factory.TaskFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PlainTaskFactory implements TaskFactory {

    private final ValueSupplier valueSupplier;

    @Inject
    public PlainTaskFactory(ValueSupplier valueSupplier) {
        this.valueSupplier = valueSupplier;
    }

    @Override
    public Task create(String taskName) {
        return new PlainTask(taskName, valueSupplier);
    }

}
