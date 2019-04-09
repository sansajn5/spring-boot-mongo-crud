package it.tdgroup.eroi.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.SmartLifecycle;

/**
 *

 */
public class SpringContainerLifeCycle implements SmartLifecycle {

    /**
     * Log applicativo.
     */
    private static final Log LOG = LogFactory.getLog(SpringContainerLifeCycle.class);

    private boolean isRunning = false;


    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public void stop(Runnable runnable) {
        stop();
        runnable.run();
    }

    @Override
    public void start() {
        LOG.info("Spring container started.");
        isRunning = true;
    }

    @Override
    public void stop() {
	LOG.info("Spring container is shutting down.");
	isRunning = false;
	LOG.info("...done!");
    }

    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public int getPhase() {
        return Integer.MAX_VALUE;
    }

}
