package pl.kuba565.RepositoryInfo.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kuba565.RepositoryInfo.client.HttpClient;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;

import javax.validation.ConstraintViolationException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubRepositoryInfoGetterITest {

    @Test
    public void shouldGetRepository() {
        //given
        HttpClient httpClient = new HttpClient();
        RepositoryInfoGetter githubRepositoryInfoGetter = new GithubRepositoryInfoGetter(httpClient);
        RepositoryRequest repositoryRequest = new RepositoryRequest("kuba565", "Allegro");

        RepositoryInfoDTO expectedRepositoryInfoDTO =
                new RepositoryInfoDTO("kuba565/Allegro",
                        "Summer e-Xperience 2019",
                        "https://github.com/kuba565/Allegro.git",
                        0,
                        "2019-04-21T19:59:20Z"
                );

        //when
        RepositoryInfoDTO result = githubRepositoryInfoGetter.getRepository(repositoryRequest);

        //then
        Assertions.assertEquals(result, expectedRepositoryInfoDTO);
    }

    @Test
    public void shouldThrowConstraintViolationExceptionWhenOwnerBlank() {
        //given
        HttpClient httpClient = new HttpClient();
        RepositoryInfoGetter githubRepositoryInfoGetter = new GithubRepositoryInfoGetter(httpClient);
        RepositoryRequest repositoryRequest = new RepositoryRequest(null, "Allegro");

        //when
        NullPointerException exception = Assertions.assertThrows(
                NullPointerException.class,
                () -> githubRepositoryInfoGetter.getRepository(repositoryRequest)
        );
        Assertions.assertEquals("owner is marked @NonNull but is null", exception.getMessage());

    }
}