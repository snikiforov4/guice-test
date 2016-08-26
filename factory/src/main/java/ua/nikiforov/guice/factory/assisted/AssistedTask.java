package ua.nikiforov.guice.factory.assisted;

import com.google.common.base.MoreObjects;
import com.google.inject.assistedinject.Assisted;
import ua.nikiforov.guice.factory.Config;

import javax.inject.Inject;

public class AssistedTask {

    private final String taskName;
    private final String value;

    @Inject
    public AssistedTask(String taskName, @Assisted Config config) {
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
