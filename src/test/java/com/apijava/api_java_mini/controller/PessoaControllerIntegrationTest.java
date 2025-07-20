package com.apijava.api_java_mini.controller;
import com.apijava.api_java_mini.entity.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test") // usa application-test.properties com H2
public class PessoaControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getUrl(String path) {
        return "http://localhost:" + port + path;
    }

    @Test
    void deveSalvarPessoaViaPost() {
        Pessoa pessoa = new Pessoa("Carlos", "999.888.777-66", "40", "carlos@email.com", "44444-5555");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Pessoa> request = new HttpEntity<>(pessoa, headers);

        ResponseEntity<Pessoa> response = restTemplate.postForEntity(
                getUrl("/pessoa"),
                request,
                Pessoa.class
        );

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Carlos", response.getBody().getNome());
    }

    @Test
    void deveBuscarPessoaPorId() {
        // primeiro cria a pessoa
        Pessoa novaPessoa = new Pessoa("Ana", "123.456.789-00", "28", "ana@email.com", "99999-0000");

        Pessoa criada = restTemplate.postForEntity(getUrl("/pessoa"), novaPessoa, Pessoa.class).getBody();
        assertNotNull(criada);
        Long id = criada.getId();

        // agora faz GET
        ResponseEntity<Pessoa> response = restTemplate.getForEntity(getUrl("/pessoa/" + id), Pessoa.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Ana", response.getBody().getNome());
    }
}
