package ua.nikiforov.play.with.guice.multibindings.service;

import static ua.nikiforov.play.with.guice.multibindings.ServiceUtils.getServiceNameByClass;

public interface IService {

    default String getName() {
        return getServiceNameByClass(getClass());
    }

}
