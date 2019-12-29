package org.th3shadowbroker.ouroboros.update.spiget;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.th3shadowbroker.ouroboros.update.sources.UpdaterSource;
import org.th3shadowbroker.ouroboros.update.util.UpdateSourceResponse;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

class SpigetSource extends UpdaterSource {

    private final String api = "https://api.spiget.org/v2";

    private final String userAgent = "ouroboros-updater-spiget-module/${project.version}";

    private SpigetUpdater spigetUpdater;

    public UpdateSourceResponse getAvailableVersion(String current) {
        this.spigetUpdater = (SpigetUpdater) updater;

        try {
            Optional<Object> resourceIdStr = spigetUpdater.getProperty("resourceId");
            int resourceId = resourceIdStr.map(o -> (int) o).orElse(0);

            URL apiUrl = new URL(api + String.format("/resources/%s/versions?size=1&sort=-releaseDate", resourceId));
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestProperty("user-agent", userAgent);
            connection.setDoOutput(true);

            JsonParser jsonParser = new JsonParser();
            JsonObject json = (JsonObject) ((JsonArray) jsonParser.parse(new InputStreamReader(connection.getInputStream()))).get(0);

            String available = json.get("name").getAsString();
            return new UpdateSourceResponse(current, available);
        } catch (Exception e) {
            onFail(e);
        }
        return UpdateSourceResponse.empty();
    }

    public void onUpdateAvailable(UpdateSourceResponse response) {
        spigetUpdater.getPlugin().getLogger().info(String.format("A new version is available (Installed: %s, Available: %s)", response.getCurrent(), response.getAvailable()));
    }

    public void onNoUpdateAvailable(UpdateSourceResponse response) {
        spigetUpdater.getPlugin().getLogger().info("Plugin is up to date");
    }

    public void onFail(Exception reason) {
        spigetUpdater.getPlugin().getLogger().severe("An error occurred: " + reason.getMessage());
    }
}
