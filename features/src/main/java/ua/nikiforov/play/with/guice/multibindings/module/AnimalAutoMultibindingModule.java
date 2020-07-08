package ua.nikiforov.play.with.guice.multibindings.module;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

public class AnimalAutoMultibindingModule<T> extends AbstractModule {

    private final Class<T> classToScan;
    private final String[] packagesToScan;

    public AnimalAutoMultibindingModule(Class<T> classToScan, String... packagesToScan) {
        this.classToScan = classToScan;
        this.packagesToScan = packagesToScan;
    }

    @Override
    protected void configure() {
        var packagesToScan = this.packagesToScan;
        if (packagesToScan.length == 0) {
            packagesToScan = new String[]{this.classToScan.getPackageName()};
        }
        var reflections = new Reflections(new ConfigurationBuilder().forPackages(packagesToScan));
        var binder = Multibinder.newSetBinder(binder(), classToScan);
        reflections.getSubTypesOf(this.classToScan).forEach(t -> addBinding(binder, t));
    }

    private void addBinding(Multibinder<T> binder, Class<? extends T> type) {
        binder.addBinding().to(type);
    }

}
