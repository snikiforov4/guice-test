package ua.nikiforov.guice.serialization;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;

public class Client {
    public static void main(String[] args) throws Exception {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.getNetworkConfig().addAddress("127.0.0.1");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

        makeOrderForApplePies(client);

        Thread.sleep(1_000L);

        HazelcastClient.shutdownAll();
    }

    private static void makeOrderForApplePies(HazelcastInstance client) throws Exception {
        IExecutorService service = client.getExecutorService("service");
        service.execute(new CookMealTask("Apple pie"));
        service.execute(new CookMealTask("Chicken"));
        service.execute(new CookMealTask("Lobster Rolls"));
//        System.out.println(r1.get());
//        System.out.println(r2.get());
//        System.out.println(r3.get());
        System.out.println("The order is sent to member!");
    }
}
