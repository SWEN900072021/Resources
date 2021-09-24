# Distribution: Service Example - SWEN90007 

This project exposes the transfer methods implemented in the Concurrency project via a RESTful API. Its purpose is to demonstrate the use of JMeter and Moskito for performance profiling purposes. It is also useful in demonstrating how JMeter can be useful when testing for concurrency issues in web applications.

Transfer ACID: http://<host>:<port>/Performance/webapi/transfer/acid?from=Alice&to=Bob&amount=10
Transfer Optimistic: http://<host>:<port>/Performance/webapi/transfer/optimistic?from=Alice&to=Bob&amount=10
Transfer Pessimistic: http://<host>:<port>/Performance/webapi/transfer/pessimistic?from=Alice&to=Bob&amount=10

## Useful Resources

### Jersey - REST framework
https://eclipse-ee4j.github.io/jersey/

### Moskito - Performance profiling
https://www.moskito.org/
https://anotheria.net/blog/msk/the-complete-moskito-integration-guide-step-1/

### JMeter - Load testing
http://jmeter.apache.org/
https://jmeter.apache.org/usermanual/build-web-test-plan.html


