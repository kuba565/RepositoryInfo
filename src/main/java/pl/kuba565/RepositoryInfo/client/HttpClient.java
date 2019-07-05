package pl.kuba565.RepositoryInfo.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kuba565.RepositoryInfo.model.RepositoryInfoDTO;

import java.util.Arrays;

import static org.springframework.http.HttpMethod.GET;

@Service
public class HttpClient {

    public RepositoryInfoDTO get(String URL) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();

        return restTemplate
                .exchange(URL,
                        GET,
                        null,
                        new ParameterizedTypeReference<RepositoryInfoDTO>() {
                        })
                .getBody();
    }
}
