package pl.kuba565.RepositoryInfo.util;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlUtilTest {
    @Test
    public void shouldGenerateUrl() {
        //when
        String url = UrlUtil.getUrl("owner", "repositoryName");
        //then
        Assertions.assertEquals(url, "https://api.github.com/repos/owner/repositoryName");
    }

    @Test
    public void shouldNotGenerateUrlWhenGivenNullValue() {
        //when
        String url = UrlUtil.getUrl(null,  "test");
        //then
        Assertions.assertNull(url);
    }
}