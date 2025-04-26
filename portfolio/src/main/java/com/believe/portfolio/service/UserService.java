package com.believe.portfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.believe.portfolio.entity.Customer;
import com.believe.portfolio.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StringRedisTemplate redisTemplate;

	private static final String USER_CACHE_KEY_PREFIX = "user:";

	// Read Through Cache Strategy (Cache and DB)
	@Cacheable(value = "users", key = "#id", unless = "#result == null")
	public Customer readThroughCache(Long id) {
		System.out.println("Cache Miss for Read-Through, Fetching from DB...");
		return userRepository.findById(id).orElse(null);
	}

	// Cache Aside Strategy (Populate Cache Manually)
	public Customer cacheAside(Long id) {
		String cacheKey = USER_CACHE_KEY_PREFIX + id;
		String cachedUser = redisTemplate.opsForValue().get(cacheKey);

		if (cachedUser != null) {
			System.out.println("Cache Hit for Cache-Aside");
			return new Customer(id, cachedUser); // Return from cache
		}

		System.out.println("Cache Miss for Cache-Aside, Fetching from DB...");
		Customer user = userRepository.findById(id).orElse(null);

		if (user != null) {
			redisTemplate.opsForValue().set(cacheKey, user.getName());
		}
		return user;
	}

	// Write Through Strategy (Write to DB and Cache)
	@CachePut(value = "users", key = "#user.id")
	public Customer writeThroughCache(Customer user) {
		System.out.println("Write-Through: Writing to both DB and Cache");
		return userRepository.save(user); // Saves to DB and updates cache
	}

	// Write Around Strategy (Write to DB and Cache is Updated Later)
	@Transactional
	public void writeAroundCache(Customer user) {
		System.out.println("Write-Around: Writing to DB and Updating Cache Later");
		userRepository.save(user); // Write to DB
		redisTemplate.opsForValue().set(USER_CACHE_KEY_PREFIX + user.getId(), user.getName()); // Update cache later
	}

	// Write Back Strategy (Write to Cache and DB is Updated Later)
	@CacheEvict(value = "users", key = "#user.id")
	public void writeBackCache(Customer user) {
		System.out.println("Write-Back: Writing to Cache, DB is Updated Later");
		redisTemplate.opsForValue().set(USER_CACHE_KEY_PREFIX + user.getId(), user.getName()); // Write to Cache
		// The actual DB update happens later, maybe after a certain time or manual
		// flush
	}
}
