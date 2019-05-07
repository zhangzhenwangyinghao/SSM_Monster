package com.oracle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.bean.Monster;
import com.oracle.bean.SubMonster;
import com.oracle.bean.pageBean;
import com.oracle.mapper.MonsterMapper;
import com.oracle.service.MonsterService;

@Service
public class MonsterServiceImpl implements MonsterService {

	@Autowired
	private MonsterMapper monsterMapper;

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly=true) public List<SubMonster> list() { // TODO
	 * Auto-generated method stub return this.monsterMapper.selectAll(); }
	 */

	@Override
	@Transactional
	public int addMonster(SubMonster monster) {
		// TODO Auto-generated method stub
		return this.monsterMapper.insert(monster);
	}

	@Override
	@Transactional(readOnly = true)
	public SubMonster QueryOneMonster(Integer monsterId) {
		// TODO Auto-generated method stub
		return this.monsterMapper.selectByPrimaryKey(monsterId);
	}

	@Override
	@Transactional
	public void updateMonster(SubMonster monster) {
		// TODO Auto-generated method stub
		this.monsterMapper.updateByPrimaryKey(monster);
	}

	@Override
	@Transactional
	public void deleteMonster(Integer monsterId) {
		// TODO Auto-generated method stub
		this.monsterMapper.deleteByPrimaryKey(monsterId);
	}

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly=true) public pageBean<SubMonster>
	 * showByPage(Integer pageNow, int pageSize) { // TODO Auto-generated method
	 * stub
	 * 
	 * pageBean<SubMonster> pb = new pageBean<SubMonster>();
	 * 
	 * pb.setPageNow(pageNow);
	 * 
	 * pb.setpageSize(pageSize);
	 * 
	 * //查看有多少条 int sum=monsterMapper.selectCount();
	 * 
	 * pb.setCounts(sum);
	 * 
	 * //从第几条开始 int index=(pageNow-1)*pageSize;
	 * 
	 * List<SubMonster> list=this.monsterMapper.showByPage(index);
	 * 
	 * pb.setBeanList(list);
	 * 
	 * return pb; }
	 */

	@Override
	@Transactional(readOnly = true)
	public pageBean<SubMonster> showByPage(Integer pageNow) {
		// TODO Auto-generated method stub

		pageBean<SubMonster> pb = new pageBean<SubMonster>();

		// 当前页的数据
		PageHelper.startPage(pageNow, 8);

		// 已经是分页好的数据了
		List<SubMonster> list = this.monsterMapper.showByPage();

		pb.setBeanList(list);

		// 总记录数
		PageInfo<SubMonster> pi = new PageInfo<SubMonster>(list);

		pb.setCounts((int) pi.getTotal());

		// 当前页
		pb.setPageNow(pageNow);

		// 每页有多少条
		pb.setpageSize(8);

		return pb;
	}
}
