# Active MQ Configuration

## 1. Active Mq install on Windows/Linux link

```sh
https://activemq.apache.org/components/classic/download/
```
## 2. Start active Mq after installation
```sh
$> ./activemq start
```
## 3. Start the ActiveMq Server
```sh
http://localhost:8161/admin
user: admin
pass: admin
```
## 4. Spring maven central dependency
```sh
https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-activemq/3.1.3
```
## 5. Spring Configuration File
```sh
@Configuration
public class JmsConfig {

	String BROKER_URL = "tcp://localhost:61616"; 
	String BROKER_USERNAME = "admin"; 
	String BROKER_PASSWORD = "admin";
	
	@Bean
	ActiveMQConnectionFactory connectionFactory(){
	    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
	    connectionFactory.setBrokerURL(BROKER_URL);
	    connectionFactory.setPassword(BROKER_USERNAME);
	    connectionFactory.setUserName(BROKER_PASSWORD);
	    return connectionFactory;
	}

	@Bean
	JmsTemplate jmsTemplate(){
	    JmsTemplate template = new JmsTemplate();
	    template.setConnectionFactory(connectionFactory());
	    return template;
	}

	@Bean
	DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory());
	    factory.setConcurrency("1-10");
	    return factory;
	}
}
```
## 6. Spring Controller
```sh
@RestController
@RequestMapping(path = "/api/v1")
public class HelloController {

	private final Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private JmsTemplate template;

	@GetMapping(path = "/hello")
	public ResponseEntity<String> getHello(){
		logger.info("getHello");
		template.convertAndSend("outbound.queue", "getHelloFromOutboundQueue-Message1");
		template.convertAndSend("inbound.queue","received message from inbound.queue");
		String outboundMessage = (String) template.receiveAndConvert("outbound.queue");
		String inboundMessage = (String) template.receiveAndConvert("inbound.queue");
		System.err.println("MESSAGE FROM ACTIVEMQ OUTBOUND: " + outboundMessage);
		System.err.println("INBOUND MESSAGE: " + inboundMessage);
		return ResponseEntity.status(HttpStatus.OK).body("Success");
	}
}
```
## 7. References
```sh
https://www.tutorialspoint.com/apache_activemq/apache_activemq_quick_guide.htm
```

## 8. Queue(point-to-point) and Topic(publisher-subscriber)
