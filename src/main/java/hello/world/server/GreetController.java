package hello.world.server;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Mono;

import javax.inject.Inject;

@Controller("/greet")
public class GreetController {
    @Inject
    private GreetingService greetingService;

/*
    @Get("/{name}")
    public String greet(String name) {
        return greetingService.getGreeting() + name;
    }
*/

    @Post(value = "/{name}", consumes = MediaType.TEXT_PLAIN)
    public String setGreeting(@Body String name) {
        return greetingService.getGreeting() + name;
    }

    @Get("/{name}")
    public Mono<String> greet(String name) {
        return Mono.just(greetingService.getGreeting() + name);
    }
}