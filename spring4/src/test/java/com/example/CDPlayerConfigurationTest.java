package com.example;

import com.example.beans.CompactDisc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfiguration.class)
@ActiveProfiles("prod")
public class CDPlayerConfigurationTest {

    @Rule
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    @Qualifier("pepper")
    private CompactDisc cd;

    @Test
    public void testCD() {
        assertNotNull(cd);
    }

    @Inject
    @Qualifier("metalica")
    private CompactDisc metalicaCD;

    @Test
    public void testArtist() {
        assertEquals("The Beatles", cd.getArtist());
    }

    @Test
    public void testTitle() {
        assertEquals("Sgt. Pepper Lonely Hearts Club Band", cd.getTitle());
    }

//    @Test
//    public void testPlay() {
//        metalicaCD.play();
//        assertEquals("ff", log.getLog());
//    }
}