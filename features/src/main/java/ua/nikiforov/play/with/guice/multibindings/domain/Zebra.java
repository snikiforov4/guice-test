package ua.nikiforov.play.with.guice.multibindings.domain;

public class Zebra implements IAnimal {

    @Override
    public String getSound() {
        return "braying";
    }

}
