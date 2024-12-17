
# Quiz App

This is a Spring Boot-based quiz application that allows a user to:
1. Start a quiz session.
2. Fetch a random multiple-choice question.
3. Submit an answer.
4. View quiz statistics.

## How to Run
1. Clone the repository.
2. Run `mvn spring-boot:run`.
3. Access the APIs at `http://localhost:8080/api/quiz`.

## Assumptions
- A single user is predefined for simplicity.
- Questions are seeded into the H2 database.
