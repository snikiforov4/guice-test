package ua.nikiforov.play.with.guice.multibindings.module;

import com.google.common.reflect.TypeToken;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import ua.nikiforov.play.with.guice.multibindings.domain.Cat;
import ua.nikiforov.play.with.guice.multibindings.domain.IAnimal;
import ua.nikiforov.play.with.guice.multibindings.domain.Zebra;

import java.util.Set;

import static com.google.common.base.Strings.isNullOrEmpty;

public class AnimalAutoMultibindingModule extends AbstractModule {

//    private final TypeToken<T> typeToken = new TypeToken<T>(getClass()) { };
    private final Class<?> classToScan;
    private final String[] packagesToScan;

    public AnimalAutoMultibindingModule(Class<?> classToScan, String... packagesToScan) {
        this.classToScan = classToScan;
        this.packagesToScan = packagesToScan;
    }

    @Override
    protected void configure() {
        var packagesToScan = this.packagesToScan;
        if (packagesToScan.length == 0) {
            packagesToScan = new String[]{this.classToScan.getPackageName()};
        }
        Reflections reflections = new Reflections(new ConfigurationBuilder().forPackages(packagesToScan));
        Multibinder<?> binder = Multibinder.newSetBinder(binder(), classToScan);
        reflections.getSubTypesOf(this.classToScan).forEach(t -> addBindings(binder, t));
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private void addBindings(Multibinder<?> uriBinder, Class type) {
        uriBinder.addBinding().to(type);
    }

}
