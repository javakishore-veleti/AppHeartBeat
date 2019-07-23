

** Note: Below steps assume you are invoking below commands from "hbs-main" folder ** 

# Running Heart Beat Server:

##### 1. Not deployed in any webserver 		- as stand alone Spring / Java application

	./bin/run_server_nonweb.sh

##### 2. Deployed in web container				- as Spring / Java in WebServer (Tomcat)

	./bin/run_server_in_web.sh


# Running Heart Beat Client:

##### 1. Client invoking Server when Server is deployed as stand alone Spring / Java application

	./bin/run_client_with_server_nonweb.sh

##### 2. Deployed in web container				- as Spring / Java in WebServer (Tomcat)

	./bin/run_client_with_server_in_web.sh


