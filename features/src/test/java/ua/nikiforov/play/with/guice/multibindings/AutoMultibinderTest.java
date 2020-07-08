package ua.nikiforov.play.with.guice.multibindings;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.jupiter.api.Test;
import ua.nikiforov.play.with.guice.multibindings.domain.IAnimal;
import ua.nikiforov.play.with.guice.multibindings.module.AnimalAutoMultibindingModule;
import ua.nikiforov.play.with.guice.multibindings.module.AnimalMultibindingModule;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class AutoMultibinderTest {

    @Test
    void autoMultibindigs() {
        Injector injector = Guice.createInjector(new AnimalAutoMultibindingModule(IAnimal.class));
        Multibinder multibinder = injector.getInstance(Multibinder.class);
        assertThat(multibinder).isNotNull();
        Set<IAnimal> animals = multibinder.getAnimals();
        assertThat(animals).isNotEmpty()
                .extracting(IAnimal::getName)
                .containsExactlyInAnyOrder("zebra", "cat");
    }

}