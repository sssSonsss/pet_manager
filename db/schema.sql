PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS caretakers (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    phone TEXT,
    shift TEXT
);

CREATE TABLE IF NOT EXISTS pets (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    species TEXT NOT NULL,
    age INTEGER,
    health_status TEXT,
    intake_date TEXT,
    diet TEXT,
    caretaker_id INTEGER,
    FOREIGN KEY (caretaker_id) REFERENCES caretakers(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS care_schedule (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    pet_id INTEGER NOT NULL,
    caretaker_id INTEGER NOT NULL,
    activity TEXT NOT NULL,
    schedule_date TEXT NOT NULL,
    notes TEXT,
    FOREIGN KEY (pet_id) REFERENCES pets(id) ON DELETE CASCADE,
    FOREIGN KEY (caretaker_id) REFERENCES caretakers(id) ON DELETE CASCADE
);

