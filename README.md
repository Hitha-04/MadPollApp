# MadPollApp 📊

A simple Android polling application built with Java and Android Studio. Users can create a poll with two options, vote on it, and view the results with percentage breakdowns.

---

## 📱 Features

- **Create a Poll** — Enter a question and two answer options
- **Vote** — Select one of the two options via radio buttons
- **View Results** — See vote counts, percentages, and progress bars
- **Reset** — Clear the poll and start a new one

---

## 🗂️ Project Structure

```
MadPollApp/
├── app/src/main/
│   ├── java/com/example/madpollapp/
│   │   ├── MainActivity.java          # Entry point — routes to correct screen
│   │   ├── PollManager.java           # Data layer — SharedPreferences storage
│   │   ├── CreatePollActivity.java    # Screen 1 — Create a poll
│   │   ├── VoteActivity.java          # Screen 2 — Cast a vote
│   │   └── ResultsActivity.java       # Screen 3 — View results
│   └── AndroidManifest.xml
```

---

## 🔄 App Flow

```
Launch App
    │
    ├── Poll exists? ──Yes──▶ VoteActivity (Screen 2)
    │
    └── No ──▶ CreatePollActivity (Screen 1)
                    │
                    ▼
              VoteActivity (Screen 2)
                    │
                    ▼
              ResultsActivity (Screen 3)
                    │
                  Reset
                    │
                    ▼
              CreatePollActivity (Screen 1)
```

---

## 👥 Team & Responsibilities

| Member      | Responsibility                          |
|-------------|------------------------------------------|
| Hithashree  | `MainActivity`, `PollManager`, `CreatePollActivity` |
| Sherin      | `VoteActivity` (Screen 2)               |
| Jeeva       | `ResultsActivity` (Screen 3)            |

---

## 🛠️ Tech Stack

- **Language:** Java
- **Platform:** Android (API 21+)
- **Storage:** SharedPreferences
- **IDE:** Android Studio

---

## 🚀 Getting Started

### Prerequisites
- Android Studio installed
- Android device or emulator (API 21+)

### Steps to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/Sherin-Suresh/MadPollApp.git
   ```
2. Open the project in **Android Studio**
3. Let Gradle sync finish
4. Click **Run ▶** or press `Shift + F10`

---

## 📦 Data Storage

All poll data is stored locally using `SharedPreferences` under the key `poll_prefs`:

| Key        | Type   | Description              |
|------------|--------|--------------------------|
| `question` | String | The poll question        |
| `optA`     | String | Option A text            |
| `optB`     | String | Option B text            |
| `votesA`   | int    | Vote count for Option A  |
| `votesB`   | int    | Vote count for Option B  |

---
