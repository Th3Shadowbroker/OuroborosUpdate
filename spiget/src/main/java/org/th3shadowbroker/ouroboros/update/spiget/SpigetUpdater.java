package org.th3shadowbroker.ouroboros.update.spiget;

import org.bukkit.plugin.Plugin;
import org.th3shadowbroker.ouroboros.update.OuroborosUpdater;
import org.th3shadowbroker.ouroboros.update.comparison.Comparator;
import org.th3shadowbroker.ouroboros.update.sources.UpdaterSource;

public class SpigetUpdater extends OuroborosUpdater {

    private final Plugin plugin;

    public SpigetUpdater(Comparator comparator, Plugin plugin, int resourceId) {
        super(comparator);
        this.plugin = plugin;
        setProperty("resourceId", resourceId);
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void checkForUpdate() {
        super.checkForUpdate(new SpigetSource(), plugin.getDescription().getVersion());
    }
}
