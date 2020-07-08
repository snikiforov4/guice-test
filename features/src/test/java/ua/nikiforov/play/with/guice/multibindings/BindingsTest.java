package ua.nikiforov.play.with.guice.multibindings;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import ua.nikiforov.play.with.guice.multibindings.domain.IAnimal;
import ua.nikiforov.play.with.guice.multibindings.module.AnimalAutoMultibindingModule;
import ua.nikiforov.play.with.guice.multibindings.module.AnimalMapBinderModule;
import ua.nikiforov.play.with.guice.multibindings.module.AnimalMultibindingModule;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BindingsTest {

    @Nested
    @DisplayName("multi bindings")
    class Multibindings {

        @Test
        void manual() {
            Injector injector = Guice.createInjector(new AnimalMultibindingModule());
            Multibinder zoo = injector.getInstance(Multibinder.class);
            assertThat(zoo).describedAs("ZooService").isNotNull();
            Set<IAnimal> animals = zoo.getAnimals();
            assertThat(animals).isNotEmpty()
                    .extracting(IAnimal::getName)
                    .containsExactlyInAnyOrder("zebra", "cat");
        }

        @Test
        void auto() {
            Injector injector = Guice.createInjector(new AnimalAutoMultibindingModule<>(IAnimal.class));
            Multibinder multibinder = injector.getInstance(Multibinder.class);
            assertThat(multibinder).isNotNull();
            Set<IAnimal> animals = multibinder.getAnimals();
            assertThat(animals).isNotEmpty()
                    .extracting(IAnimal::getName)
                    .containsExactlyInAnyOrder("zebra", "cat");
        }

    }

    @Nested
    @DisplayName("map binder")
    class MapBinder {

        @Test
        void manual() {
            Injector injector = Guice.createInjector(new AnimalMapBinderModule());
            ua.nikiforov.play.with.guice.multibindings.MapBinder sut = injector.getInstance(ua.nikiforov.play.with.guice.multibindings.MapBinder.class);
            assertThat(sut).describedAs("ZooService").isNotNull();
            Map<String, IAnimal> animals = sut.getAnimals();
            assertThat(animals).isNotEmpty()
                    .hasSize(2)
                    .containsKeys("zebra", "cat");
        }

    }

}
