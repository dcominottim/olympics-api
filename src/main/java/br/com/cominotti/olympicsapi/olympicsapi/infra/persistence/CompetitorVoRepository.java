package br.com.cominotti.olympicsapi.olympicsapi.infra.persistence;

import br.com.cominotti.olympicsapi.olympicsapi.view.CompetitorVo;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface CompetitorVoRepository extends EntityRepository<CompetitorVo, Integer> {
}
