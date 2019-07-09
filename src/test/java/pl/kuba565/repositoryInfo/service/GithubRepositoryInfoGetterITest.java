package pl.kuba565.repositoryInfo.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kuba565.repositoryInfo.client.HttpClient;
import pl.kuba565.repositoryInfo.exception.ValidationException;
import pl.kuba565.repositoryInfo.model.RepositoryInfo;
import pl.kuba565.repositoryInfo.model.RepositoryRequest;
import pl.kuba565.repositoryInfo.validation.RepositoryRequestValidator;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GithubRepositoryInfoGetterITest {

    @Test
    public void shouldGetRepository() {
        //given
        HttpClient httpClient = new HttpClient();
        RepositoryRequestValidator repositoryRequestValidator = new RepositoryRequestValidator();
        RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer = new RepositoryInfoDTOToRepositoryInfoTransformer();

        RepositoryInfoGetter githubRepositoryInfoGetter =
                new GithubRepositoryInfoGetter(httpClient, repositoryRequestValidator, repositoryInfoDTOToRepositoryInfoTransformer);
        RepositoryRequest repositoryRequest = new RepositoryRequest("kuba565", "Allegro");

        RepositoryInfo expectedRepositoryInfo =
                new RepositoryInfo("kuba565/Allegro",
                        "Summer e-Xperience 2019",
                        "https://github.com/kuba565/Allegro.git",
                        0,
                        "2019-04-21T19:59:20Z"
                );

        //when
        RepositoryInfo result = githubRepositoryInfoGetter.getRepository(repositoryRequest);

        //then
        Assertions.assertEquals(result, expectedRepositoryInfo);
    }

    @Test
    public void shouldThrowValidationExceptionWhenOwnerBlank() {
        //given
        HttpClient httpClient = new HttpClient();
        RepositoryRequestValidator repositoryRequestValidator = new RepositoryRequestValidator();
        RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer = new RepositoryInfoDTOToRepositoryInfoTransformer();

        RepositoryInfoGetter githubRepositoryInfoGetter =
                new GithubRepositoryInfoGetter(httpClient, repositoryRequestValidator, repositoryInfoDTOToRepositoryInfoTransformer);
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
        RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer = new RepositoryInfoDTOToRepositoryInfoTransformer();

        RepositoryInfoGetter githubRepositoryInfoGetter =
                new GithubRepositoryInfoGetter(httpClient, repositoryRequestValidator, repositoryInfoDTOToRepositoryInfoTransformer);
        RepositoryRequest repositoryRequest = new RepositoryRequest("kuba565", "");

        //when

        ValidationException exception = Assertions.assertThrows(
                ValidationException.class,
                () -> githubRepositoryInfoGetter.getRepository(repositoryRequest)
        );
        Assertions.assertEquals("repositoryName is null or whitespace", exception.getMessage());

    }
}