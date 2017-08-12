package br.com.cominotti.olympics_api.server.infrastructure.persistence;

import br.com.cominotti.olympics_api.server.domain.model.Schedule;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface ScheduleRepository extends EntityRepository<Schedule, Integer> {
}
