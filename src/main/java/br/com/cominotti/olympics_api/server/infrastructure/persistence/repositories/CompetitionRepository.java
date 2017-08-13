package br.com.cominotti.olympics_api.server.infrastructure.persistence.repositories;

import br.com.cominotti.olympics_api.server.domain.model.Competition;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface CompetitionRepository extends EntityRepository<Competition, Integer> {

}
