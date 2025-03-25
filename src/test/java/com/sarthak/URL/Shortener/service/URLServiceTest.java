package com.sarthak.URL.Shortener.service;

import com.sarthak.URL.Shortener.entity.URL;
import com.sarthak.URL.Shortener.exception.NotFoundException;
import com.sarthak.URL.Shortener.repo.URLRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.validator.*;
import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ContextConfiguration(classes = { URLServiceTest.class })
@RunWith(SpringRunner.class)
class URLServiceTest {

    @InjectMocks
    private URLService service;

    @Mock
    private URLRepo repo;

    URL url;
    String urlStr;
    Date date;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        date = new Date();
        url = new URL("randomurl","localhost:8081",date);
        urlStr = "localhost:8081";

    }

    @Test
    void testSave() {

        Mockito.when(repo.save(any(URL.class))).thenReturn(url);
        URL actualRes = service.save(urlStr);
        assertThat(actualRes).isEqualTo(url);
    }

    @Test
    void testGet_Exist() throws NotFoundException {

        Mockito.when(repo.findById(anyString())).thenReturn(Optional.of(url));
        String actualRes = service.get("randomurl");
        assertThat(actualRes).isEqualTo(url.getFullURL());

    }

    @Test
    void testGet_NotExist(){

        Mockito.when(repo.findById(anyString())).thenReturn(Optional.empty());
        Throwable exception = assertThrows(NotFoundException.class,()->{
            service.get("randomurl1");
        });

        String expectedMessage = "url not found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}