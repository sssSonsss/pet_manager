Pet Farm Simulation (Swing + SQLite)
====================================

Structure Overview
------------------
- `petfarm/db`: SQLite connection management and schema bootstrap.
- `petfarm/model`: Plain models (`Pet`, `Caretaker`, `CareSchedule`).
- `petfarm/repository`: Data access objects using JDBC + prepared statements.
- `petfarm/service`: Business logic, validation, DTO orchestration.
- `petfarm/view`: Swing UI (main frame + tab panels).
- `petfarm/util`: Small helpers (date parsing, UI utilities).

Key Technologies
----------------
- Java 8+ with Swing for the desktop UI.
- SQLite (via `sqlite-jdbc` driver) for persistence.
- JDBC with prepared statements (no ORM) for CRUD operations.
- Simple layered design: View → Service → Repository → DB.

Setup Cheatsheet
----------------
1. Place `sqlite-jdbc-<version>.jar` inside a `lib` folder (or adjust classpath).
2. Compile:
   ```
   javac -cp ".:lib/sqlite-jdbc-3.45.2.0.jar" $(find . -name "*.java")
   ```
3. Run:
   ```
   java -cp ".:lib/sqlite-jdbc-3.45.2.0.jar" petfarm.view.PetFarmApp
   ```
4. On first launch, `DatabaseInitializer` auto-creates `petfarm.db` with sample data.

Next Steps
----------
- Flesh out UI panels (pets, caretakers, schedules) once services and repositories are in place.
- Add form validation, search filters, and CSV export as bonus features.

