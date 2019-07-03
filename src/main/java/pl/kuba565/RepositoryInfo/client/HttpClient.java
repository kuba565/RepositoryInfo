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

        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
        restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);

        return restTemplate
                .exchange(URL,
                        GET,
                        null,
                        new ParameterizedTypeReference<RepositoryInfoDTO>() {
                        })
                .getBody();
    }
}
