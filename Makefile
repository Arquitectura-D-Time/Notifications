run:
	mvn clean package -B
	docker-compose up --build
