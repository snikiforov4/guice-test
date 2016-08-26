package ua.nikiforov.guice.factory.assisted;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import ua.nikiforov.guice.factory.ValueSupplier;
import ua.nikiforov.guice.factory.Task;
import ua.nikiforov.guice.factory.TaskExecutor;
import ua.nikiforov.guice.factory.TaskFactory;

import javax.inject.Singleton;

public class Client {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            protected void configure() {
                install(new FactoryModuleBuilder().implement(Task.class, AssistedTask.class).build(TaskFactory.class));
                bind(ValueSupplier.class).annotatedWith(Assisted.class).to(ValueSupplier.class);
            }
        });
//        TaskExecutor executor = injector.getInstance(TaskExecutor.class);
//        executor.execute();
        TaskFactory factory = injector.getInstance(TaskFactory.class);
        System.out.println(factory.create("magic"));    }
}
