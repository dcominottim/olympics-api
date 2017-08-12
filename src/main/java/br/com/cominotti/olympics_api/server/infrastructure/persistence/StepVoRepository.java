package br.com.cominotti.olympics_api.server.infrastructure.persistence;

import br.com.cominotti.olympics_api.server.infrastructure.rest.views.StepVo;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface StepVoRepository extends EntityRepository<StepVo, Integer> {

}
