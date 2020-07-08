package ua.nikiforov.play.with.guice.factory.plain;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import ua.nikiforov.play.with.guice.factory.TaskFactory;

public class Client {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AbstractModule() {
            protected void configure() {
                bind(TaskFactory.class).to(PlainTaskFactory.class);
            }
        });
        TaskFactory factory = injector.getInstance(TaskFactory.class);
        System.out.println(factory.create("magic"));
    }
}
