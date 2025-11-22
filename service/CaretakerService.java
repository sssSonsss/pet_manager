package petfarm.service;

import petfarm.model.Caretaker;
import petfarm.repository.CaretakerRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CaretakerService {

    private final CaretakerRepository repository;

    public CaretakerService() {
        this(new CaretakerRepository());
    }

    public CaretakerService(CaretakerRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    public List<Caretaker> listCaretakers() {
        return repository.findAll();
    }

    public Caretaker addCaretaker(Caretaker caretaker) {
        validate(caretaker, false);
        int id = repository.create(caretaker);
        caretaker.setId(id);
        return caretaker;
    }

    public Caretaker updateCaretaker(Caretaker caretaker) {
        validate(caretaker, true);
        repository.update(caretaker);
        return caretaker;
    }

    public void deleteCaretaker(int id) {
        repository.delete(id);
    }

    public Optional<Caretaker> findById(int id) {
        return repository.findById(id);
    }

    private void validate(Caretaker caretaker, boolean requireId) {
        if (caretaker == null) {
            throw new IllegalArgumentException("Caretaker cannot be null");
        }
        if (requireId && caretaker.getId() == null) {
            throw new IllegalArgumentException("Caretaker ID is required");
        }
        if (caretaker.getName() == null || caretaker.getName().isBlank()) {
            throw new IllegalArgumentException("Tên nhân viên không được trống");
        }
    }
}

