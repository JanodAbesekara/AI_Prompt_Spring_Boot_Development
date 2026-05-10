# Cloud Deployment

## Build

```bash
mvn clean package
```

## Run

```bash
java -jar target/article-management.jar
```

## Docker

```bash
docker build -t article-api .
docker run -p 8080:8080 article-api
```

## Environment Variables

```env
SPRING_DATASOURCE_URL=
SPRING_DATASOURCE_USERNAME=
SPRING_DATASOURCE_PASSWORD=
```