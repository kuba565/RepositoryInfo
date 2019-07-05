package pl.kuba565.RepositoryInfo.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kuba565.RepositoryInfo.client.HttpClient;
import pl.kuba565.RepositoryInfo.exception.ValidationException;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;
import pl.kuba565.RepositoryInfo.model.RepositoryRequest;
import pl.kuba565.RepositoryInfo.validation.RepositoryRequestValidator;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubRepositoryInfoGetterITest {

    @Test
    public void shouldGetRepository() {
        //given
        HttpClient httpClient = new HttpClient();
        RepositoryRequestValidator repositoryRequestValidator = new RepositoryRequestValidator();
        RepositoryInfoGetter githubRepositoryInfoGetter = new GithubRepositoryInfoGetter(httpClient, repositoryRequestValidator);
        RepositoryRequest repositoryRequest = new RepositoryRequest("kuba565", "Allegro");

        RepositoryInfoDTO expectedRepositoryInfoDTO =
                new RepositoryInfoDTO("kuba565/Allegro",
                        "Summer e-Xperience 2019",
                        "https://github.com/kuba565/Allegro.git",
                        0,
                        "2019-04-21T19:59:20Z"
                );

        //when
        RepositoryInfoDTO result = null;
        try {
            result = githubRepositoryInfoGetter.getRepository(repositoryRequest);
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        //then
        Assertions.assertEquals(result, expectedRepositoryInfoDTO);
    }

    @Test
    public void shouldThrowValidationExceptionWhenOwnerBlank() {
        //given
        HttpClient httpClient = new HttpClient();
        RepositoryRequestValidator repositoryRequestValidator = new RepositoryRequestValidator();
        RepositoryInfoGetter githubRepositoryInfoGetter = new GithubRepositoryInfoGetter(httpClient, repositoryRequestValidator);
        RepositoryRequest repositoryRequest = new RepositoryRequest(null, "Allegro");

        //when

        ValidationException exception = Assertions.assertThrows(
                ValidationException.class,
                () -> githubRepositoryInfoGetter.getRepository(repositoryRequest)
        );
        Assertions.assertEquals("owner is null or whitespace", exception.getMessage());

    }

    @Test
    public void shouldThrowValidationExceptionWhenRepositoryNameBlank() {
        //given
        HttpClient httpClient = new HttpClient();
        RepositoryRequestValidator repositoryRequestValidator = new RepositoryRequestValidator();
        RepositoryInfoGetter githubRepositoryInfoGetter = new GithubRepositoryInfoGetter(httpClient, repositoryRequestValidator);
        RepositoryRequest repositoryRequest = new RepositoryRequest("kuba565", "");

        //when

        ValidationException exception = Assertions.assertThrows(
                ValidationException.class,
                () -> githubRepositoryInfoGetter.getRepository(repositoryRequest)
        );
        Assertions.assertEquals("repositoryName is null or whitespace", exception.getMessage());

    }
}