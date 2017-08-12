package br.com.cominotti.olympics_api.server.infrastructure.persistence;

import br.com.cominotti.olympics_api.server.domain.model.Competitor;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface CompetitorRepository extends EntityRepository<Competitor, Integer> {
}
