package com.example.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.inject.Named;

//@Component(value = "metalica")
@Named(value = "metalica")
public class MetallicaCD implements CompactDisc {
    private static final Logger LOGGER = LoggerFactory.getLogger(SgPeppersCD.class);

    private String title = "Oxigen";
    private String artist = "Metallica";

    @Override
    public void play() {
        LOGGER.info("Playing {} by {}.", title, artist);
        System.out.println(title + artist);
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
