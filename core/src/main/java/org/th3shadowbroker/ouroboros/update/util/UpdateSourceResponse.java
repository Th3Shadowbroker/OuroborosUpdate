package org.th3shadowbroker.ouroboros.update.util;

import org.th3shadowbroker.ouroboros.update.comparison.Comparator;

public class UpdateSourceResponse {

    private final String current;

    private final String available;

    public UpdateSourceResponse(String current, String available) {
        this.current = current;
        this.available = available;
    }

    public String getCurrent() {
        return current;
    }

    public String getAvailable() {
        return available;
    }

    public boolean isEmpty() {
        return current == null && available == null;
    }

    public static UpdateSourceResponse empty() {
        return new UpdateSourceResponse(null, null);
    }

}
