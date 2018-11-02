package br.com.dotcom.desafio.resources;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dotcom.desafio.model.Planeta;
import br.com.dotcom.desafio.repository.PlanetaRepository;
import br.com.dotcom.desafio.swapi.Swapi;

@RestController
@RequestMapping(value="/api")
@CrossOrigin(origins="*")
public class PlanetaResource {

	@Autowired
	PlanetaRepository repository;
	
  /*
   * Teste de Funcionalidade...
   */
	@GetMapping("/hello")
  public Collection<String> sayHello() {
      return IntStream.range(0, 10)
        .mapToObj(i -> "Hello number " + i)
        .collect(Collectors.toList());
  }
	
	@GetMapping("/planeta")
	//@ApiOperation(value="Retorna uma lista de planetas")
	public List<Planeta> findAll(){
		return repository.findAll();
	}

	@GetMapping("/planeta/{id}")
	//@ApiOperation(value="Retorna um determinado planeta inforando o ID")
	public Optional<Planeta> findById(@PathVariable(value="id") String id){		
		return repository.findById(id);
	}
	
	@PostMapping("/planeta") 
	//@ApiOperation(value="Grava um planeta no Banco retornando o mesmo")
	public Planeta save(@RequestBody Planeta planeta){	
		Swapi swapi = new Swapi(planeta.getNome());
		planeta.setQtdAparicao(swapi.getQtdFilmes()+"");
		return repository.save(planeta);
	}

	@DeleteMapping("/planeta")
	//@ApiOperation(value="Remove um determinado planeta")
	public void delete(@RequestBody Planeta planeta){	
		repository.delete(planeta);
	}
	
	@PutMapping("/planeta")
	//@ApiOperation(value="Altera um determinado planeta e retorna o mesmo")
	public Planeta put(@RequestBody Planeta planeta){	
		Swapi swapi = new Swapi(planeta.getNome());
		planeta.setQtdAparicao(swapi.getQtdFilmes()+"");
		return repository.save(planeta);
	}
	
}
