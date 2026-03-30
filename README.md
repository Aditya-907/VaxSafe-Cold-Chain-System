# VaxSafe — Cold Chain Monitoring System

## Overview

VaxSafe is a backend-based Java project that simulates a cold chain logistics system for temperature-sensitive medicines such as vaccines. It monitors temperature in real time, detects unsafe conditions, updates batch status, and logs all critical events.

The system is designed to demonstrate concepts like object-oriented design, concurrency, database integration, and system-level architecture.

---

## Features

* Real-time temperature simulation using multi-threading
* Automatic detection of temperature violations
* State management (IN_STORAGE → SPOILED)
* Persistent storage using SQLite (JDBC)
* File-based audit logging
* Clean modular architecture (model, service, dao, simulation, util)

---

## Project Structure

```
src/com/vaxsafe/
│
├── model/        # Data classes and enums
├── service/      # Business logic and alerts
├── dao/          # Database operations (JDBC)
├── simulation/   # Sensor and environment simulation
├── exception/    # Custom exceptions
├── util/         # Utilities (logging, analytics)
└── Main.java     # Entry point
```

---

## Technologies Used

* Java (Core + Concurrency)
* JDBC (SQLite)
* ExecutorService (multi-threading)
* Java NIO (file logging)

---

## Prerequisites

* Java JDK 8 or higher
* SQLite JDBC driver (`sqlite-jdbc.jar`)
* Any Java IDE (IntelliJ, Eclipse, VS Code)

---

## Setup Instructions

### 1. Clone the Repository

```
git clone <https://github.com/Aditya-907/VaxSafe-Cold-Chain-System.git>
cd VaxSafe
```

### 2. Add JDBC Driver

* Download SQLite JDBC driver
* Place it inside:

```
lib/sqlite-jdbc.jar
```

* Add it to your project classpath

---

### 3. Compile the Project

```
javac -cp "lib/*" -d bin src/com/vaxsafe/**/*.java
```

---

### 4. Run the Application

```
java -cp "bin;lib/*" com.vaxsafe.Main
```

(Use `:` instead of `;` on Linux/Mac)

---

## How It Works

1. Vaccine batches are created and stored in the database
2. Simulation generates temperature readings every few seconds
3. Each reading is processed by the system
4. If temperature goes out of range:

   * Batch is marked as SPOILED
   * Database is updated
   * Alert is triggered
   * Event is logged

---

## Output

### Console

* Continuous temperature readings
* Alerts when unsafe conditions occur

### Database (`vaxsafe.db`)

* Stores batch details and updated states

### Log File (`vaxsafe.log`)

* Records:

  * State changes
  * Alerts

---

## Example Flow

```
Batch Created → Stored in DB → Sensor Generates Temp →
Temperature Checked → If Unsafe:
State Updated → Alert Triggered → Logged
```

## License

This project is licensed under the [MIT License](LICENSE) - see the [LICENSE](LICENSE) file for details

---

## Author

Aditya Singh Tomar
