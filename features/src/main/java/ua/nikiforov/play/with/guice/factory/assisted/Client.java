package ua.nikiforov.play.with.guice.factory.assisted;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import ua.nikiforov.play.with.guice.factory.Task;
import ua.nikiforov.play.with.guice.factory.TaskFactory;

public class Client {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            protected void configure() {
                install(new FactoryModuleBuilder().implement(Task.class, AssistedTask.class).build(TaskFactory.class));
            }
        });
        TaskFactory factory = injector.getInstance(TaskFactory.class);
        System.out.println(factory.create("magic"));    }
}
