package br.com.dotcom.desafio.swapi;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ApplicationSwapi {

	private static final Logger log = LoggerFactory.getLogger(ApplicationSwapi.class);

	public static void main(String args[]) {

    String uri = "https://swapi.co/api/planets/?format=json&search=Tatooine";
    
    RestTemplate restTemplate = new RestTemplate();
     
    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

    ResponseEntity<Planeta> re = restTemplate.exchange(uri, HttpMethod.GET, entity, Planeta.class);
    Planeta planeta = re.getBody();
    
    if (planeta.getResults().isEmpty()) {
    	log.info("Nada, nada, nada");
    }else {
    	long qtdTotal = planeta.getCount();
    	log.info("Foram encontrados :"+qtdTotal+" Planetas");
    	int i=0;
    	int qtd = planeta.getResults().size();
    	while (i < qtd) {
    		List<Result> r = planeta.getResults();
    		log.info("Planeta("+i+") :"+r.get(i).getName());
    		log.info("Aparece em :"+r.get(i).getFilms().size()+" filmes da saga !");
    		i++;
    		if (i==9 && qtdTotal > 10) {
    			uri = planeta.getNext();
    	    re = restTemplate.exchange(uri, HttpMethod.GET, entity, Planeta.class);
    	    planeta = re.getBody();
    	    i=0;
    	    qtd = planeta.getResults().size();
    		}
    	}
    }
    
	}

}
