package petfarm.model;

import java.time.LocalDate;
import java.util.Objects;

public class CareSchedule {
    private Integer id;
    private Integer petId;
    private Integer caretakerId;
    private String activity;
    private LocalDate scheduleDate;
    private String notes;

    public CareSchedule() {
    }

    public CareSchedule(Integer id, Integer petId, Integer caretakerId, String activity,
                        LocalDate scheduleDate, String notes) {
        this.id = id;
        this.petId = petId;
        this.caretakerId = caretakerId;
        this.activity = activity;
        this.scheduleDate = scheduleDate;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getCaretakerId() {
        return caretakerId;
    }

    public void setCaretakerId(Integer caretakerId) {
        this.caretakerId = caretakerId;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareSchedule that = (CareSchedule) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

