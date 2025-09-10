package com.elitea.tests.ui;

import com.elitea.ui.pages.HomePage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageTest extends BaseUiTest {

    @Test
    void canOpenHomeAndReadTitle() {
        String title = new HomePage(page)
                .navigate()
                .getTitle();
        assertThat(title).isNotNull();
    }
}


