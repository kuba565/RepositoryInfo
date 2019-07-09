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
public class RepositoryInfoMapperTest {
    @Test
    public void shouldMapRepositoryInfoDTOToRepositoryInfo() {
        //given
        RepositoryInfoDTO repositoryInfoDTOMock = new RepositoryInfoDTO("a", "a", "a", 1, "a");
        RepositoryMapper repositoryInfoMapper = new RepositoryInfoMapper();

        //when
        RepositoryInfo repositoryInfo = repositoryInfoMapper.mapRepositoryInfo(repositoryInfoDTOMock);

        //then
        Assertions.assertAll(

                () -> Assertions.assertEquals(repositoryInfo.getCloneUrl(), repositoryInfoDTOMock.getClone_url()),
                () -> Assertions.assertEquals(repositoryInfo.getCreatedAt(), repositoryInfoDTOMock.getCreated_at()),
                () -> Assertions.assertEquals(repositoryInfo.getDescription(), repositoryInfoDTOMock.getDescription()),
                () -> Assertions.assertEquals(repositoryInfo.getFullName(), repositoryInfoDTOMock.getFull_name()),
                () -> Assertions.assertEquals(repositoryInfo.getStars(), repositoryInfoDTOMock.getStargazers_count()));
    }

    @Test
    public void shouldMapRepositoryInfoDTOToRepositoryInfoWithNullFields() {
        //given
        RepositoryInfoDTO repositoryInfoDTOMock = new RepositoryInfoDTO(null, null, null, null, null);
        RepositoryMapper repositoryInfoMapper = new RepositoryInfoMapper();

        //when
        RepositoryInfo repositoryInfo = repositoryInfoMapper.mapRepositoryInfo(repositoryInfoDTOMock);

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
    public void shouldNotMapNullObject() {
        //given
        RepositoryMapper repositoryInfoMapper = new RepositoryInfoMapper();

        //when
        RepositoryInfo repositoryInfo = repositoryInfoMapper.mapRepositoryInfo(null);

        //then
        Assertions.assertNull(repositoryInfo);
    }


}