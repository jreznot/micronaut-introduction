package hello.world.server;

import javax.inject.Singleton;

@Singleton
public class GreetingService {

    public String getGreeting() {
        return "Hello ";
    }
}