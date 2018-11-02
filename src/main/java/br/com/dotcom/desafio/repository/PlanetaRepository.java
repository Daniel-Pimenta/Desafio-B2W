package br.com.dotcom.desafio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.dotcom.desafio.model.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {

}
