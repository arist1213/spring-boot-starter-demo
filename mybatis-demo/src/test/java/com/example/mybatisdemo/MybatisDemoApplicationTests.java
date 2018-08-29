package com.example.mybatisdemo;

import com.example.mybatisdemo.entity.User;
import com.example.mybatisdemo.mapper.UserMapper;
import com.example.mybatisdemo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class MybatisDemoApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(MybatisDemoApplicationTests.class);

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserService userService;

	// ===============
	// test mapper
	// ===============

	// ===============
	// insert
	// ===============
	@Test
	public void testInsertSelective() throws Exception {

		final User user1 = genUser("u1", "p1");
		userMapper.insertSelective(user1);
		assertTrue(user1.getId()>0);

	}
	// [PageInfo{pageNum=1, pageSize=5, size=5, startRow=1, endRow=5, total=10, pages=2, list=Page{count=true, pageNum=1, pageSize=5, startRow=0, endRow=5, total=10, pages=2, reasonable=false, pageSizeZero=false}[User(id=279, username=u9, password=p9), User(id=278, username=u8, password=p8), User(id=277, username=u7, password=p7), User(id=276, username=u6, password=p6), User(id=275, username=u5, password=p5)], prePage=0, nextPage=2, isFirstPage=true, isLastPage=false, hasPreviousPage=false, hasNextPage=true, navigatePages=8, navigateFirstPage=1, navigateLastPage=2, navigatepageNums=[1, 2]}]
	@Test
	public void testInsertList() throws Exception {
		List<User> list = new ArrayList<>();
		list.add(genUser("u1", "p1"));
		list.add(genUser("u1", "p1"));
		list.add(genUser("u1", "p1"));
		list.add(genUser("u1", "p1"));
		list.add(genUser("u1", "p1"));

		int n = userMapper.insertList(list);
		assertTrue(n==list.size());
	}

	@Test public void testCount() {
		userMapper.insertSelective(genUser("u1", "p"));
		userMapper.insertSelective(genUser("u1", "p"));
		userMapper.insertSelective(genUser("u1", "p"));
		userMapper.insertSelective(genUser("u1", "p"));
		userMapper.insertSelective(genUser("u1", "p"));
		userMapper.insertSelective(genUser("u2", "p"));

		final int count = userMapper.countByUsername("u1");
		assertTrue(count==5);
	}

	// ===============
	// update
	// ===============
	@Test public void testUpdate() {
		// insert
		User u = genUser("u2", "p2");
		userMapper.insertSelective(u);
		String newName = "yan";

		// update
		Long id = u.getId();
		u.setUsername(newName);
		userMapper.updateByPrimaryKeySelective(u);

		// check
		User u1 = userMapper.selectByPrimaryKey(id);

		assertTrue(newName.equals(u1.getUsername()));
		assertFalse(newName.equals("notEqual"));

	}

	// ===============
	// page
	// ===============
	@Test public void testPager1() {
		insertMany(100);
		final PageInfo<Object> pageInfo = PageHelper.startPage(1, 20)
				.setOrderBy("id desc")
				.doSelectPageInfo( () -> this.userMapper.selectAll() );
		log.info("[lambda写法] - [分页信息] - [{}]", pageInfo.toString());
	}

	@Test
	public void testPager2() {
		insertMany(10);
		PageHelper.startPage(1, 5).setOrderBy("id desc");
		final PageInfo<User> userPageInfo = new PageInfo<>(this.userMapper.selectAll());
		log.info("[普通写法] - [{}]", userPageInfo);
	}

	// ===============
	// search
	// ===============

	@Test public void testSearch() {
		Condition c = new Condition(User.class);
		c.createCriteria().andEqualTo("username", "u1");

		userMapper.insertSelective(genUser("u1", "p"));
		userMapper.insertSelective(genUser("u2", "p"));

		List<User> list = userMapper.selectByCondition(c);
		assertTrue(list.size()==1);
	}

	// ===============
	// test service
	// ===============

	@Test public void testServiceSave() {
		User u = genUser("y", "p");
		userService.save(u);
		assertTrue(u.getId()>0);
	}

	@Test public void testServiceSaveList() {
		int size = 10;
		List<User> list = genUserList(size);
		userService.save(list);
		assertTrue(list.size()==size);
	}


	// ===============
	// help
	// ===============
	private void insertMany(int n) {
		for (int i = 0; i < n; i++)
			userMapper.insertSelective(genUser("u"+i, "p"+i));
	}

	private User genUser(String name, String passwd) {
		User u = new User();
		u.setUsername(name);
		u.setPassword(passwd);
		return u;
	}

	private List<User> genUserList(int n) {
		List<User> list = new ArrayList<>();
		for (int i = 0; i < n; i++)
			list.add(genUser("u"+i, "p"+i));
		return list;
	}
}
