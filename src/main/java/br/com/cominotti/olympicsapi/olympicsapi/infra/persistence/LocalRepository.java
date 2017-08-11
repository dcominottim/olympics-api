package br.com.cominotti.olympicsapi.olympicsapi.infra.persistence;

import br.com.cominotti.olympicsapi.olympicsapi.domain.olympics.model.Local;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface LocalRepository extends EntityRepository<Local, Integer> {
}
