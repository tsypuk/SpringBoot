package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfiguration.class)
public class CDPlayerConfigurationTest {

    @Autowired
    private CompactDisc cd;

    @Test
    public void testCD() {
        assertNotNull(cd);
    }

    @Test
    public void testArtist() {
        assertEquals("The Beatles", cd.getArtist());
    }

    @Test
    public void testTitle() {
        assertEquals("Sgt. Pepper Lonely Hearts Club Band", cd.getTitle());
    }

}