package ua.nikiforov.play.with.guice.multibindings.domain;

public class Cat implements IAnimal {

    @Override
    public String getSound() {
        return "meow";
    }

}
