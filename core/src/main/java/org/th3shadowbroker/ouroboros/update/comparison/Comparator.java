package org.th3shadowbroker.ouroboros.update.comparison;

import org.th3shadowbroker.ouroboros.update.util.UpdateSourceResponse;

public abstract class Comparator {

    public static final Comparator EQUAL = new Comparator() {
        @Override
        public boolean isUpdateAvailable(String current, String available) {
            return !current.equals(available);
        }
    };

    public static final Comparator SEMANTIC = new Comparator() {
        @Override
        public boolean isUpdateAvailable(String current, String available) {
            int currentRepl = Integer.parseInt(current.replaceAll("[^0-9]", ""));
            int availableRepl = Integer.parseInt(available.replaceAll("[^0-9]", ""));
            return currentRepl < availableRepl;
        }
    };

    public boolean isUpdateAvailable(UpdateSourceResponse response) {
        return isUpdateAvailable(response.getCurrent(), response.getAvailable());
    }

    public abstract boolean isUpdateAvailable(String current, String available);

}
