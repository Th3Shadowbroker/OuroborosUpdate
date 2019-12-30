package org.th3shadowbroker.ouroboros.update;

import org.th3shadowbroker.ouroboros.update.comparison.Comparator;
import org.th3shadowbroker.ouroboros.update.sources.UpdaterSource;
import org.th3shadowbroker.ouroboros.update.util.UpdateSourceResponse;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OuroborosUpdater {

    private final Comparator comparator;

    private final Map<String, Object> environment = new HashMap<>();

    public OuroborosUpdater(Comparator comparator) {
        this.comparator = comparator;
    }

    public void setProperty(String name, Object value) {
        environment.put(name, value);
    }

    public Optional<Object> getProperty(String name) {
        return Optional.ofNullable(environment.getOrDefault(name, null));
    }

    public void checkForUpdate(UpdaterSource updaterSource, String current) {
        if (injectUpdaterInstance(updaterSource)) {
            Thread updateThread = new Thread(() -> {
                try {
                    UpdateSourceResponse updateSourceResponse = updaterSource.getAvailableVersion(current);
                    if (!updateSourceResponse.isEmpty()) {
                        if (comparator.isUpdateAvailable(updateSourceResponse)) {
                            updaterSource.onUpdateAvailable(updateSourceResponse);
                        } else {
                            updaterSource.onNoUpdateAvailable(updateSourceResponse);
                        }
                    } else {
                        throw new Exception("Source response was empty!");
                    }
                } catch (Exception ex) {
                    updaterSource.onFail(ex);
                }
            });
            updateThread.start();
        }
    }

    private boolean injectUpdaterInstance(UpdaterSource updaterSource) {
        try {
            Field instanceField = updaterSource.getClass().getSuperclass().getDeclaredField("updater");
            instanceField.setAccessible(true);
            instanceField.set(updaterSource, this);
            return true;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return false;
        }
    }

}
