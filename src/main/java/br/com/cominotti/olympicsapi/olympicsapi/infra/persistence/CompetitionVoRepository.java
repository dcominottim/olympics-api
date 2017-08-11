package br.com.cominotti.olympicsapi.olympicsapi.infra.persistence;

import br.com.cominotti.olympicsapi.olympicsapi.view.CompetitionVo;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
public interface CompetitionVoRepository extends EntityRepository<CompetitionVo, Integer> {

    List<CompetitionVo> findAllOrderByStartDateTimeAsc();

    List<CompetitionVo> findByModality_idOrderByStartDateTimeAsc(Integer id);
}
