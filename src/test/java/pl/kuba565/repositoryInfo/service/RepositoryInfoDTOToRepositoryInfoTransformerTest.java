package pl.kuba565.repositoryInfo.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kuba565.repositoryInfo.model.RepositoryInfo;
import pl.kuba565.repositoryInfo.model.RepositoryInfoDTO;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryInfoDTOToRepositoryInfoTransformerTest {

    @Test
    public void shouldTransformRepositoryInfoDTOToRepositoryInfo() {
        //given
        RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer = new RepositoryInfoDTOToRepositoryInfoTransformer();
        RepositoryInfoDTO input = new RepositoryInfoDTO("a", "a", "", 1, "");

        //when
        RepositoryInfo expected = repositoryInfoDTOToRepositoryInfoTransformer.apply(input);
        //then

        Assertions.assertAll(
                () -> Assertions.assertEquals(expected.getCloneUrl(), input.getClone_url()),
                () -> Assertions.assertEquals(expected.getCreatedAt(), input.getCreated_at()),
                () -> Assertions.assertEquals(expected.getDescription(), input.getDescription()),
                () -> Assertions.assertEquals(expected.getFullName(), input.getFull_name()),
                () -> Assertions.assertEquals(expected.getStars(), input.getStargazers_count())
        );
    }
}