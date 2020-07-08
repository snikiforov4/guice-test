package ua.nikiforov.play.with.guice.factory.plain;

import com.google.common.base.MoreObjects;
import ua.nikiforov.play.with.guice.factory.ValueSupplier;
import ua.nikiforov.play.with.guice.factory.Task;

public class PlainTask implements Task {

    private final String taskName;
    private final String value;

    public PlainTask(String taskName, ValueSupplier valueSupplier) {
        this.taskName = taskName;
        this.value = valueSupplier.value();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("taskName", taskName)
                .add("value", value)
                .toString();
    }
}
