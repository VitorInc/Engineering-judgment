# Engineering Judgment – Demo (Spring Boot + Kotlin + Docker)

## Tech Stack

- Java 17
- Kotlin
- Spring Boot
- Gradle 9.3.0
- Docker
- WSL2 (Windows)

---

## Docker commands to run in your local

cd Engineering-judgment-feature-filefeature\Engineering-judgment-feature-filefeature\demo
docker build -t engineering-demo:1.0 .

docker images
IMAGE
engineering-demo:1.0

docker run -p 8080:8080 --name engineering-demo-container engineering-demo:1.0