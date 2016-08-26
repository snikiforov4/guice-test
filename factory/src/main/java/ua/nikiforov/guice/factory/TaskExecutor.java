package ua.nikiforov.guice.factory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TaskExecutor {

    private final TaskFactory factory;

    @Inject
    public TaskExecutor(TaskFactory factory) {
        this.factory = factory;
    }

    public void execute() {
        Task task = factory.create("make magic");
        System.out.println(task);
    }
}
