package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("metallicaCD")
public class MetallicaCD implements CompactDisc {
    private static final Logger LOGGER = LoggerFactory.getLogger(SgPeppersCD.class);

    private String title = "Oxigen";
    private String artist = "Metallica";

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
