package pl.kuba565.repositoryInfo.validation;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.kuba565.repositoryInfo.model.RepositoryRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryRequestValidatorTest {


    @Test
    public void shouldPositivelyValidateSupportedClass(){
        //given
        RepositoryRequestValidator repositoryRequestValidator = new RepositoryRequestValidator();
        RepositoryRequest repositoryRequest = new RepositoryRequest();

        //when
        boolean result = repositoryRequestValidator.supports(repositoryRequest.getClass());

        //then
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNegativelyValidateSupportedClass(){
        //given
        RepositoryRequestValidator repositoryRequestValidator = new RepositoryRequestValidator();
        String string = "";

        //when
        boolean result = repositoryRequestValidator.supports(string.getClass());

        //then
        Assertions.assertFalse(result);
    }
}