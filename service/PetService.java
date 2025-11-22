package petfarm.service;

import petfarm.model.Pet;
import petfarm.repository.PetRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PetService {

    private final PetRepository repository;

    public PetService() {
        this(new PetRepository());
    }

    public PetService(PetRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    public List<Pet> listPets() {
        return repository.findAll();
    }

    public Pet addPet(Pet pet) {
        validate(pet, false);
        int id = repository.create(pet);
        pet.setId(id);
        return pet;
    }

    public Pet updatePet(Pet pet) {
        validate(pet, true);
        repository.update(pet);
        return pet;
    }

    public void deletePet(int id) {
        repository.delete(id);
    }

    public Optional<Pet> findById(int id) {
        return repository.findById(id);
    }

    private void validate(Pet pet, boolean requireId) {
        if (pet == null) {
            throw new IllegalArgumentException("Pet cannot be null");
        }
        if (requireId && pet.getId() == null) {
            throw new IllegalArgumentException("Pet ID is required");
        }
        if (pet.getName() == null || pet.getName().isBlank()) {
            throw new IllegalArgumentException("Tên thú cưng không được để trống");
        }
        if (pet.getSpecies() == null || pet.getSpecies().isBlank()) {
            throw new IllegalArgumentException("Loài thú cưng không được để trống");
        }
        if (pet.getAge() != null && pet.getAge() < 0) {
            throw new IllegalArgumentException("Tuổi không hợp lệ");
        }
        LocalDate intakeDate = pet.getIntakeDate();
        if (intakeDate != null && intakeDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Ngày nhập trại không thể ở tương lai");
        }
    }
}

