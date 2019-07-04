package pl.kuba565.RepositoryInfo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class RepositoryRequestTest {
    @Test
    void shouldThrowNullPointerException() {
        //when
        NullPointerException exception = Assertions.assertThrows(
                NullPointerException.class,
                () -> new RepositoryRequest(null, "Allegro")
        );
        //then
        Assertions.assertEquals("owner is marked @NonNull but is null", exception.getMessage());
    }
}