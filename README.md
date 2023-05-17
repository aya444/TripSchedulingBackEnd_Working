# Deploy your spring boot application to kubernetes cluster 
mvn clean
mvn clean install -DskipTests=true

docker build -t backend_image .
