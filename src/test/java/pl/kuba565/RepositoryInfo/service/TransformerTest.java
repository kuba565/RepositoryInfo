package pl.kuba565.RepositoryInfo.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kuba565.RepositoryInfo.model.RepositoryInfo;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransformerTest {
    @Test
    public void shouldTransformRepositoryInfo() {
        //given
        RepositoryInfoDTO repositoryInfoDTOMock = new RepositoryInfoDTO("a", "a", "a", 1, "a");
        RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer = new RepositoryInfoDTOToRepositoryInfoTransformer();

        //when
        RepositoryInfo repositoryInfo = repositoryInfoDTOToRepositoryInfoTransformer.apply(repositoryInfoDTOMock);

        //then
        Assertions.assertAll(

                () -> Assertions.assertEquals(repositoryInfo.getCloneUrl(), repositoryInfoDTOMock.getClone_url()),
                () -> Assertions.assertEquals(repositoryInfo.getCreatedAt(), repositoryInfoDTOMock.getCreated_at()),
                () -> Assertions.assertEquals(repositoryInfo.getDescription(), repositoryInfoDTOMock.getDescription()),
                () -> Assertions.assertEquals(repositoryInfo.getFullName(), repositoryInfoDTOMock.getFull_name()),
                () -> Assertions.assertEquals(repositoryInfo.getStars(), repositoryInfoDTOMock.getStargazers_count()));
    }

    @Test
    public void shouldTransformWithNullFields() {
        //given
        RepositoryInfoDTO repositoryInfoDTOMock = new RepositoryInfoDTO(null, null, null, null, null);
        RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer = new RepositoryInfoDTOToRepositoryInfoTransformer();

        //when
        RepositoryInfo repositoryInfo = repositoryInfoDTOToRepositoryInfoTransformer.apply(repositoryInfoDTOMock);

        //then
        Assertions.assertAll(
                () -> Assertions.assertEquals(repositoryInfo.getCloneUrl(), repositoryInfoDTOMock.getClone_url()),
                () -> Assertions.assertEquals(repositoryInfo.getCreatedAt(), repositoryInfoDTOMock.getCreated_at()),
                () -> Assertions.assertEquals(repositoryInfo.getDescription(), repositoryInfoDTOMock.getDescription()),
                () -> Assertions.assertEquals(repositoryInfo.getFullName(), repositoryInfoDTOMock.getFull_name()),
                () -> Assertions.assertEquals(repositoryInfo.getStars(), repositoryInfoDTOMock.getStargazers_count())
        );
    }

    @Test
    public void shouldNotTransformNullObject() {
        //given
        RepositoryInfoDTOToRepositoryInfoTransformer repositoryInfoDTOToRepositoryInfoTransformer = new RepositoryInfoDTOToRepositoryInfoTransformer();

        //when
        RepositoryInfo repositoryInfo = repositoryInfoDTOToRepositoryInfoTransformer.apply(null);

        //then
        Assertions.assertNull(repositoryInfo);
    }

}