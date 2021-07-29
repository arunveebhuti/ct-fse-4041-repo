# Steps and Instructions

## Running Docker Containers on EC2

### Installing docker on ec2

```text

1. sudo yum update -y
2. sudo yum install docker -y
3. sudo service docker start
4. Add ec2-user to the docker group 
sudo usermod -a -G docker ec2-user
5. docker  -v

```

## Running Spring Boot Apps with Mysql On Docker

### Running Mysql On Docker

```bash

docker run -d -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=docker -e MYSQL_USER=docker -e MYSQL_PASSWORD=password -p 3306:3306 --name mysql mysql

```

### Running app with Mysql (Network Based Communication)

* Create a network

```bash
docker network create docker-mysql-network
```

* Run Mysql on that network :

```bash
docker run -d --network=docker-mysql-network -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=docker -e MYSQL_USER=docker -e MYSQL_PASSWORD=password -p 3306:3306 --name mysql mysql
```

* Running Spring Boot Application

```text

docker run -p 5000:5000 -d -e RDS_HOSTNAME=mysql -e RDS_PORT=3306 -e RDS_DB_NAME=docker -e RDS_USER=docker -e RDS_PASSWORD=docker --network=docker-mysql-network --name trainee-rest-api trainee-rest-api 

```
### Installing Docker-compose on EC2:

```bash

sudo curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose


sudo chmod +x /usr/local/bin/docker-compose

sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose

```
