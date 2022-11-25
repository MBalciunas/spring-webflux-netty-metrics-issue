# Example project to reproduce issue in spring boot: https://github.com/spring-projects/spring-boot/issues/33300

### Steps:
1. Clone the repo or download project 
2. Start application: `./gradlew bootRun`
3. Execute in terminal: `ab -n 15000 -c 50 -H "Authorization:Basic cHJvbWV0aGV1czpwcm9tZXRoZXVz" http://localhost:8080/v1/hello` (Authorization conains username: prometheus, pasword: prometheus)
4. Execute prometheus query: `curl -X GET http://localhost:8081/actuator/prometheus -H 'authorization: Basic cHJvbWV0aGV1czpwcm9tZXRoZXVz'`
5. Observe generated metric examples: `http_server_requests_seconds_count{exception="CancelledServerWebExchangeException",method="GET",outcome="UNKNOWN",status="200",uri="/v1/hello",} 203.0`

### This issue seems to rely on spring-security dependecy and these UNKNOWN metrics seems not to be generated when Authorization header is missing.