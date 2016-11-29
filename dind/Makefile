build:
	docker build -t tesco/jenkins .

run:
	docker run -d -v /var/run/docker.sock:/var/run/docker.sock -v $(which docker):/usr/bin/docker -p 8080:8080 tesco/jenkins
