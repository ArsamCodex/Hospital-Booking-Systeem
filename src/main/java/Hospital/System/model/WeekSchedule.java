package Hospital.System.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WeekSchedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int appointmentDuration;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "weekSchedule")
    @OrderBy("id")
    private Set<DaySchedule> daySchedules;

    public WeekSchedule() {
        this.setDaySchedules(new HashSet<>());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAppointmentDuration() {
        return appointmentDuration;
    }

    public void setAppointmentDuration(int appointmentDuration) {
        this.appointmentDuration = appointmentDuration;
    }

    public Set<DaySchedule> getDaySchedules() {
        return daySchedules;
    }

    public void setDaySchedules(Set<DaySchedule> daySchedules) {
        this.daySchedules = daySchedules;
    }
}