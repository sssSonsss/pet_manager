package petfarm.model;

import java.util.Objects;

public class Caretaker {
    private Integer id;
    private String name;
    private String phone;
    private String shift;

    public Caretaker() {
    }

    public Caretaker(Integer id, String name, String phone, String shift) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.shift = shift;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caretaker caretaker = (Caretaker) o;
        return Objects.equals(id, caretaker.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

