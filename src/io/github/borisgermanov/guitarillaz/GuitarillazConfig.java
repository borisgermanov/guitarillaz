/*
 * Copyright 2016 bo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
