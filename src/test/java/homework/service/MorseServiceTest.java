package homework.service;

import homework.ApplicationTests;
import homework.config.Config;
import homework.model.TranslationData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Import({Config.class})
public class MorseServiceTest {

    @Autowired
    private MorseService morseService;

    @Mock
    private TranslationData translationData;

    @Test
    public void testEncode() {
        when(translationData.getText()).thenReturn(ApplicationTests.TEST_TEXT);
        Assert.assertEquals(ApplicationTests.TEST_TEXT_MORSE_ENCODE, morseService.encode(translationData));
    }

    @Test
    public void testDecode() {
        when(translationData.getText()).thenReturn(ApplicationTests.TEST_TEXT_MORSE_ENCODE);
        Assert.assertEquals(ApplicationTests.TEST_TEXT, morseService.decode(translationData));
    }

}
