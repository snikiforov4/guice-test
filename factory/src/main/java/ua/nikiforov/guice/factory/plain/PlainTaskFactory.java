package ua.nikiforov.guice.factory.plain;

import ua.nikiforov.guice.factory.Config;
import ua.nikiforov.guice.factory.TaskFactory;

import javax.inject.Inject;

/**
 * @author <a href="mailto:snikiforov@corp.nekki.ru">Sergey Nikiforov</a>
 */
public class PlainTaskFactory implements TaskFactory {
    private final Config config;

    @Inject
    public PlainTaskFactory(Config config) {
        this.config = config;
    }

    @Override
    public PlainTask create(String taskName) {
        return new PlainTask(taskName, config);
    }
}
