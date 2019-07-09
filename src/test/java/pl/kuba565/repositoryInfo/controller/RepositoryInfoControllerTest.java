package pl.kuba565.repositoryInfo.controller;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kuba565.repositoryInfo.client.HttpClient;
import pl.kuba565.repositoryInfo.model.RepositoryInfo;
import pl.kuba565.repositoryInfo.service.GithubRepositoryInfoGetter;
import pl.kuba565.repositoryInfo.service.RepositoryInfoDTOToRepositoryInfoTransformer;
import pl.kuba565.repositoryInfo.validation.RepositoryRequestValidator;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryInfoControllerTest {


    @Test
    public void shouldGetRepository() {
        //given
        HttpClient httpClient = new HttpClient();
        RepositoryRequestValidator repositoryRequestValidator = new RepositoryRequestValidator();
        RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer = new RepositoryInfoDTOToRepositoryInfoTransformer();
        GithubRepositoryInfoGetter githubRepositoryInfoGetter = new GithubRepositoryInfoGetter(httpClient, repositoryRequestValidator, repositoryInfoDTOToRepositoryInfoTransformer);
        RepositoryInfoController repositoryInfoController = new RepositoryInfoController(githubRepositoryInfoGetter);
        RepositoryInfo expectedRepositoryInfo =
                new RepositoryInfo("kuba565/Allegro",
                        "Summer e-Xperience 2019",
                        "https://github.com/kuba565/Allegro.git",
                        0,
                        "2019-04-21T19:59:20Z"
                );

        //when

        ResponseEntity<RepositoryInfo> responseEntity = repositoryInfoController.getRepository("kuba565", "Allegro");
        RepositoryInfo result = responseEntity.getBody();

        //then
        Assertions.assertEquals(result, expectedRepositoryInfo);
    }
}