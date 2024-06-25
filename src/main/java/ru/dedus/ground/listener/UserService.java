package ru.dedus.ground.listener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserService {
    private final ApplicationEventPublisher eventPublisher;

    public UserService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public Long createUser(String username) {

        Long primaryKey = ThreadLocalRandom.current().nextLong(1, 1000);

        this.eventPublisher.publishEvent(new UserCreationEvent(username, primaryKey));

        return primaryKey;
    }

    public List<Long> createUser(List<String> usernames) {
        List<Long> resultIds = new ArrayList<>();

        for (String username : usernames) {
            resultIds.add(createUser(username));
        }
        return resultIds;
    }
}
