package com.wangyonghui.redis.test;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import com.wangyonghui.common.utils.UserUtils;
import com.wangyonghui.domain.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-redis.xml")
public class TestRedis {
	//声明redis
	@Resource
	RedisTemplate redisTemplate;
	
	//使用JDK方法
	@Test
	public void TestJDK(){
		ValueOperations opsForValue = redisTemplate.opsForValue();
		//获取当前时间
		long time1 = System.currentTimeMillis();
		//循环随机生成50000个user对象
		for (int i = 0; i < 50000; i++) {
			User user = new User();
			//工具类生成随机数据
			user.setId(i);
			user.setName(UserUtils.getName());
			user.setSex(UserUtils.getSex());
			user.setPhone(UserUtils.getPhone());
			user.setEmail(UserUtils.getEmail());
			user.setBriday(UserUtils.getBirthday());
			
			opsForValue.set("user"+i, user);
		}
		//获取存入redis后的时间
		long time2 = System.currentTimeMillis();
		System.out.println("用JDK方法存入redis使用时间为"+(time2-time1)+"s");
		System.out.println("已成功存入JDK方法50000条redis数据");
		
	}
	//JSON方法
	@Test
	public void TestJSON(){
		ValueOperations opsForValue = redisTemplate.opsForValue();
		//获取当前时间
		long time1 = System.currentTimeMillis();
		//循环随机生成50000个user对象
		for (int i = 0; i < 50000; i++) {
			User user = new User();
			//工具类生成随机数据
			user.setId(i);
			user.setName(UserUtils.getName());
			user.setSex(UserUtils.getSex());
			user.setPhone(UserUtils.getPhone());
			user.setEmail(UserUtils.getEmail());
			user.setBriday(UserUtils.getBirthday());
			
			opsForValue.set("user"+i, user);
		}
		//获取存入redis后的时间
		long time2 = System.currentTimeMillis();
		System.out.println("用JSON方法存入redis使用时间为"+(time2-time1)+"s");
		System.out.println("已成功存入JSON方法50000条redis数据");
	}
	
	// Hash
	@Test
	public void TestHash(){
		HashMap map =  new HashMap<String, User>();
		//获取当前时间
		HashOperations opsForHash = redisTemplate.opsForHash();
		
		long time1 = System.currentTimeMillis();
		//循环随机生成50000个user对象
		for (int i = 0; i < 50000; i++) {
			User user = new User();
			//工具类生成随机数据
			user.setId(i);
			user.setName(UserUtils.getName());
			user.setSex(UserUtils.getSex());
			user.setPhone(UserUtils.getPhone());
			user.setEmail(UserUtils.getEmail());
			user.setBriday(UserUtils.getBirthday());
			
			map.put("user"+i, user);
			opsForHash.put("users"+i, "user"+i, user.toString());
		}
		//将map存入redis
		opsForHash.putAll("users",  map);
		//获取存入redis后的时间
		long time2 = System.currentTimeMillis();
		System.out.println("用Hash方法存入redis使用时间为"+(time2-time1)+"s");
		System.out.println("已成功存入Hash方法50000条redis数据");
	}
	
	
	
	
}
