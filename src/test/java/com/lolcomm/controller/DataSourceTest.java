package com.lolcomm.controller;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	// DB 연결 테스트
	
	// DB연결 정보(DataSource 객체)
	// -> 객체 직접 생성x , 스프링으로 부터 전달(주입)
	@Inject
	private DataSource ds;
	
    // DB연결
	@Test
	public void testCon() throws Exception{
		try (Connection con = ds.getConnection()) {
			System.out.println("연결정보 : "+con);			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}

