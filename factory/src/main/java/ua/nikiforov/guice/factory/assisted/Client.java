package ua.nikiforov.guice.factory.assisted;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import ua.nikiforov.guice.factory.TaskExecutor;
import ua.nikiforov.guice.factory.TaskFactory;

public class Client {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            protected void configure() {
                install(new FactoryModuleBuilder().build(TaskFactory.class));
            }
        });
        TaskExecutor executor = injector.getInstance(TaskExecutor.class);
        executor.execute();
    }
}
