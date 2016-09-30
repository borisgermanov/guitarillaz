package io.github.borisgermanov.guitarillaz;

import java.util.prefs.Preferences;

/**
 * Preferences handling
 */
public class GuitarillazConfig {
    public enum Channel { CLEAN, CRUNCH, DISTORTION }
    private static final String CHANNEL = "channel";
    private Preferences preferences;

    public GuitarillazConfig() {
        preferences = Preferences.userNodeForPackage(GuitarillazConfig.class);
    }

    public Channel getChannel() {
        int i = preferences.getInt(CHANNEL, 0);
        if (i < 0 || Channel.values().length <= i) {
            i = 0;
            preferences.putInt(CHANNEL, i);
        }
        return Channel.values()[i];
    }

    public void setChannel(Channel channel) {
        preferences.putInt(CHANNEL, channel.ordinal());
    }
}
