package br.com.cominotti.olympicsapi.olympicsapi.infra.persistence;

import br.com.cominotti.olympicsapi.olympicsapi.view.LocalVo;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface LocalVoRepository extends EntityRepository<LocalVo, Integer> {
}
