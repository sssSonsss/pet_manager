package petfarm.model;

import java.time.LocalDate;
import java.util.Objects;

public class Pet {
    private Integer id;
    private String name;
    private String species;
    private Integer age;
    private String healthStatus;
    private LocalDate intakeDate;
    private String diet;
    private Integer caretakerId;

    public Pet() {
    }

    public Pet(Integer id, String name, String species, Integer age, String healthStatus,
               LocalDate intakeDate, String diet, Integer caretakerId) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.age = age;
        this.healthStatus = healthStatus;
        this.intakeDate = intakeDate;
        this.diet = diet;
        this.caretakerId = caretakerId;
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }

    public LocalDate getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(LocalDate intakeDate) {
        this.intakeDate = intakeDate;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public Integer getCaretakerId() {
        return caretakerId;
    }

    public void setCaretakerId(Integer caretakerId) {
        this.caretakerId = caretakerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(id, pet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

