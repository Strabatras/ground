package ru.dedus.ground.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ReportingListener {

    private static final Logger logger = LoggerFactory.getLogger(ReportingListener.class);

    @EventListener({UserCreationEvent.class})
    public void reportUserCreation(UserCreationEvent event) {
        logger.atInfo()
                .setMessage("Create user : #" + event.id() + " name " + event.username())
                .log();
    }
}
