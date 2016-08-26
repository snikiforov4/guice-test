package ua.nikiforov.guice.factory.plain;

import com.google.common.base.MoreObjects;
import com.google.inject.assistedinject.Assisted;
import ua.nikiforov.guice.factory.Config;
import ua.nikiforov.guice.factory.Task;

import javax.inject.Inject;

public class PlainTask implements Task {

    private final String taskName;
    private final String value;

    public PlainTask(String taskName, Config config) {
        this.taskName = taskName;
        this.value = config.value();
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("taskName", taskName)
                .add("value", value)
                .toString();
    }
}
