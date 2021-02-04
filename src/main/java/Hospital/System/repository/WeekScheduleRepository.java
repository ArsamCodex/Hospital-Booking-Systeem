package Hospital.System.repository;

import Hospital.System.model.WeekSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekScheduleRepository extends JpaRepository<WeekSchedule, Long> {

}