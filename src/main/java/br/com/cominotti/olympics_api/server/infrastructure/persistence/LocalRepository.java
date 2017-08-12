package br.com.cominotti.olympics_api.server.infrastructure.persistence;

import br.com.cominotti.olympics_api.server.domain.model.Local;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface LocalRepository extends EntityRepository<Local, Integer> {
}
