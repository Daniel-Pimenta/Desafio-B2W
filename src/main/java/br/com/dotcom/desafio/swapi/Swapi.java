package br.com.dotcom.desafio.swapi;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Swapi {
	
	private int qtdFilmes = 0;

	public Swapi(String nomePlaneta) {
		String uri = "https://swapi.co/api/planets/?format=json&search=" + nomePlaneta;

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

		ResponseEntity<Planeta> re = restTemplate.exchange(uri, HttpMethod.GET, entity, Planeta.class);
		Planeta planeta = re.getBody();
    // teste
		if (!planeta.getResults().isEmpty()) {
			List<Result> r = planeta.getResults();
			this.qtdFilmes = r.get(0).getFilms().size();
		}
	}

	public int getQtdFilmes() {
		return qtdFilmes;
	}
	
}
