package ua.nikiforov.guice.factory.assisted;

import com.google.common.base.MoreObjects;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import ua.nikiforov.guice.factory.Task;
import ua.nikiforov.guice.factory.ValueSupplier;


public class AssistedTask implements Task {

    private String taskName;
    private String value;

    @Inject
    public AssistedTask(@Assisted String taskName, ValueSupplier valueSupplier) {
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
