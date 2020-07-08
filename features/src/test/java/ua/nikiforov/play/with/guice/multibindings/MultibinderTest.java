package ua.nikiforov.play.with.guice.multibindings;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;
import ua.nikiforov.play.with.guice.multibindings.domain.IAnimal;
import ua.nikiforov.play.with.guice.multibindings.module.AnimalMultibindingModule;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class MultibinderTest {

    @Test
    void multibindigs() {
        Injector injector = Guice.createInjector(new AnimalMultibindingModule());
        Multibinder zoo = injector.getInstance(Multibinder.class);
        assertThat(zoo).describedAs("ZooService").isNotNull();
        Set<IAnimal> animals = zoo.getAnimals();
        assertThat(animals).isNotEmpty()
                .extracting(IAnimal::getName)
                .containsExactlyInAnyOrder("zebra", "cat");
    }

}