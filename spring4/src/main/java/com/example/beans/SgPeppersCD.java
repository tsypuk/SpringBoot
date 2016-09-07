package com.example.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("pepper")
@Profile("prod")
public class SgPeppersCD implements CompactDisc {
    private static final Logger LOGGER = LoggerFactory.getLogger(SgPeppersCD.class);

    private String title = "Sgt. Pepper Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        LOGGER.info("Playing {} by {}.", title, artist);
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getArtist() {
        return this.artist;
    }
}
