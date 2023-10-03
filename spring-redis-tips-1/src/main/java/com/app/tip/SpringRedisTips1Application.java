package com.app.tip;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableRedisHttpSession
@EnableCaching
public class SpringRedisTips1Application {	
	
	private ApplicationRunner titledRunner(String title, ApplicationRunner rr) {
		return args -> {
			log.info(title.toUpperCase() + ":");
			rr.run(args);
		};
	}
//	
//	@Bean
//	ApplicationRunner geography(RedisTemplate<String, String> rt) {
//		return titledRunner("geography", args -> {
//			GeoOperations<String, String> geo = rt.opsForGeo();
//			geo.add("Sicily", new Point(13.361389, 38.1155556), "Arigento");
//			geo.add("Sicily", new Point(15.087269, 37.502669), "Catania");
//			geo.add("Sicily", new Point(13.583333, 37.316667), "Palermo");
//			
//			Circle circle = new Circle(new Point(13.583333, 37.316667), new Distance(100, DistanceUnit.KILOMETERS));
//			GeoResults<RedisGeoCommands.GeoLocation<String>> geoResults = geo.radius("Sicily", circle);
//			
//			geoResults.getContent().forEach(c -> log.info(c.toString()));
//		});
//	}
	
	@Bean
	CacheManager cacheManager(RedisConnectionFactory cf) {
		return RedisCacheManager.builder(cf).build();
	}
	
	@Bean
	ApplicationRunner repositories(OrderRepository ordRepo, LineItemRepository repo) {
		return titledRunner("repositories", args -> {
			Long orderId = generateId();
			List<LineItem> itemList = Arrays.asList(new LineItem(orderId, generateId(), "plunger"), 
					new LineItem(orderId, generateId(), "soup"),
					new LineItem(orderId, generateId(), "coffee mug"));
			itemList.stream().map((element) -> {repo.save(element); return element;}).forEach(li -> log.info(li.toString()));
			
			Order order = new Order(orderId, new Date(), itemList);
			ordRepo.save(order);
			
			Collection<Order> found = ordRepo.findByWhen(order.getWhen());
			found.forEach(o -> log.info(o.toString()));
		});	
	}

	private Long generateId() {
		long tmp = new Random().nextLong();
		return Math.max(tmp, tmp * (-1));
	}
	
	private long measure(Runnable r) {
		long start = System.nanoTime();
		r.run();
		long stop = System.nanoTime();
		return stop-start;
	}
	
	
	@Bean
	ApplicationRunner cache(OrderService service) {
		return titledRunner("caching", args -> {
			Runnable measure = () -> service.byId(1L);
			log.info("one " + measure(measure));
			log.info("two " + measure(measure));
			log.info("three " + measure(measure));
		});
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisTips1Application.class, args);
	}
}



interface OrderRepository extends CrudRepository<Order, Long>{
	Collection<Order> findByWhen(Date date);
}

interface LineItemRepository extends CrudRepository<LineItem, Long>{}


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(value = "orders")
class Order implements Serializable {
	
	@Id
	private Long id;
	
	@Indexed
	private Date when;
	
	@Reference
	private List<LineItem> lineItems;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@RedisHash(value = "lineItems")
class LineItem implements Serializable {
	
	@Indexed
	private Long orderId;
	
	@Id
	private Long id;
	
	private String description;
}

@Service
class OrderService {
	/* THIS ENTIRE METHOD IS MEMOISED AS IT RETURNS JUST A NEW ORDER */
	@Cacheable("order-by-id")
	public Order byId(Long id) {
		
		try {
			Thread.sleep(1000 * 10);
		} catch (Exception e) {
			throw new RuntimeException();
		}		
		return new Order(id, new Date(), Collections.emptyList());
	}
}


class ShoppingCart implements Serializable {
	
	private final Collection<Order> orders = new ArrayList<>();
	
	public void addOrder(Order order) {
		this.orders.add(order);
	}
	
	public Collection<Order> getOrders(){
		return this.orders;
	}
}


@Slf4j
@Controller
@SessionAttributes("cart")
class CartSessionController {
	
	private final AtomicLong ids = new AtomicLong();

	@ModelAttribute("cart")
	ShoppingCart cart() {
		log.info("Creating new Cart");
		return new ShoppingCart();
	}
	
	@GetMapping(path = "/orders")
	public String orders(@ModelAttribute ("cart") ShoppingCart cart, Model model) {
		cart.addOrder(new Order(ids.incrementAndGet(), new Date(), Collections.emptyList()));
		model.addAttribute("orders", cart.getOrders());		
		return "orders";		
	}
	
}
