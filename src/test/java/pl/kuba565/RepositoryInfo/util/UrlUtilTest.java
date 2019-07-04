package pl.kuba565.RepositoryInfo.util;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlUtilTest {
    @Test
    public void shouldGenerateUrl() {
        //given
        RepositoryRequest repositoryRequest = new RepositoryRequest("owner", "repositoryName");
        //when
        String url = UrlUtil.getUrl(repositoryRequest);
        //then
        Assertions.assertEquals(url, "https://api.github.com/repos/owner/repositoryName");
    }

}