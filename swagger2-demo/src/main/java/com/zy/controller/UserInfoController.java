package com.zy.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zy.model.UserInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 人员信息控制类
 * 创建人：ZhangYu
 * 创建时间：2019年6月22日 上午21:03:29
 */
@RestController
@RequestMapping(value = "/userInfo")
@Api(value = "用户信息")
public class UserInfoController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Resource
//    UserInfoService service;
    
    @ResponseBody
    @RequestMapping(value = "/selectAllUsers", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有的人员信息并分页展示", notes = "查询所有的人员信息并分页展示")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page",value = "跳转到的页数", required = true, paramType = "query"),
        @ApiImplicitParam(name = "size",value = "每页展示的记录数", required = true, paramType = "query")
    })
    public String selectAllUsers(Integer page, Integer size) {
        return "hello world 1!";
    }
    
    @ResponseBody
    @RequestMapping(value = "/selectContacts", method = RequestMethod.GET)
    @ApiOperation(value = "查询通讯录人员信息", notes = "查询通讯录人员信息")
    public String selectContacts() {
        return "hello world 2!";
    }
    
    @ResponseBody
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ApiOperation(value = "查询人员信息", notes = "查询信息")
    public UserInfo getUser() {
    	UserInfo user= new UserInfo();
    	user.setCreateTime(new Date());
    	user.setId(1);
    	user.setPassword("123456");
    	user.setSpellName("zhangyu");
    	user.setUserName("张禹");
    	user.setUserPhone("18789497110");
    	return user;
    }
}
