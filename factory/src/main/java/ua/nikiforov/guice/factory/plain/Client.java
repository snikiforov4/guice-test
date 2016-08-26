package ua.nikiforov.guice.factory.plain;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import ua.nikiforov.guice.factory.TaskExecutor;
import ua.nikiforov.guice.factory.TaskFactory;

/**
 * @author <a href="mailto:snikiforov@corp.nekki.ru">Sergey Nikiforov</a>
 */
public class Client {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            protected void configure() {
                bind(TaskFactory.class).to(PlainTaskFactory.class);
            }
        });
        TaskExecutor executor = injector.getInstance(TaskExecutor.class);
        executor.execute();
    }
}
