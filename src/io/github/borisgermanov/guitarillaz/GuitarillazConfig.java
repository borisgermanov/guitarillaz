package io.github.borisgermanov.guitarillaz;

/**
 *
 */
class GuitarillazConfig {
    enum Channel { CLEAN, CRUNCH, DISTORTION }
    private static Channel channel;

    GuitarillazConfig() {
        channel = Channel.CLEAN;
    }

    Channel getChannel() {
        return channel;
    }

    void setChannel(Channel channel) {
        GuitarillazConfig.channel = channel;
    }
}
