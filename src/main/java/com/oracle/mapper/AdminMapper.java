package com.oracle.mapper;

import com.oracle.bean.Admin;
import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer adminId);

    int insert(Admin record);

    Admin selectByPrimaryKey(String account);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);
}