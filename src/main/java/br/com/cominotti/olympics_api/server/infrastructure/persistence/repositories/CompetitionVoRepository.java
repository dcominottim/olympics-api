package br.com.cominotti.olympics_api.server.infrastructure.persistence.repositories;

import br.com.cominotti.olympics_api.server.infrastructure.rest.views.CompetitionVo;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;

@Repository
public interface CompetitionVoRepository extends EntityRepository<CompetitionVo, Integer> {

    List<CompetitionVo> findAllOrderByStartDateTimeAsc();

    List<CompetitionVo> findByModality_idOrderByStartDateTimeAsc(Integer id);
}
