package org.th3shadowbroker.ouroboros.update.sources;

import org.th3shadowbroker.ouroboros.update.OuroborosUpdater;
import org.th3shadowbroker.ouroboros.update.util.UpdateSourceResponse;

public abstract class UpdaterSource {

    protected OuroborosUpdater updater;

    public abstract UpdateSourceResponse getAvailableVersion(String current);

    public abstract void onUpdateAvailable(UpdateSourceResponse response);

    public abstract void onNoUpdateAvailable(UpdateSourceResponse response);

    public abstract void onFail(Exception reason);

}