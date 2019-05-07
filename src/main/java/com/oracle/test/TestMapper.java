package com.oracle.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageHelper;
import com.oracle.bean.SubMonster;
import com.oracle.mapper.MonsterMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestMapper {
	
	@Autowired
	private MonsterMapper monsterMapper;
	
	
	@Test
	public void testMapper(){
		
		PageHelper.startPage(1,8);
		
		List<SubMonster> list=this.monsterMapper.showByPage();
		
		for (SubMonster monster : list) {
			
			System.out.println(monster);
		}		
	}

}
