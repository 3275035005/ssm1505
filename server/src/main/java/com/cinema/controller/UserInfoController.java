package com.cinema.controller;

import com.cinema.entity.UserInfo;
import com.cinema.service.UserInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 对管理平台提供 用户信息管理接口
 */
@RequestMapping("userInfo")
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 管理平台登录接口
     */
    @PostMapping("login")
    public R login(@RequestBody UserInfo userInfo){
        UserInfo userInfos = userInfoService.getUserInfoByUsername(userInfo.getUsername());
        if(userInfos == null){
            return R.error("请输入正确的账号");
        }
        if(!userInfo.getPassword().equals(userInfos.getPassword())){
            return R.error("请输入正确的密码");
        }
        String status = userInfos.getStatus();
        if("0".equals(status)){
            return R.error("账号已被禁用");
        }
        if(!"2".equals(userInfos.getRole())){
            return R.error("请登录管理员账号");
        }
        return R.ok().put("row", userInfos);
    }

    @GetMapping("getSuccess")
    public String getSuccess(){

        return "success";
    }
    /**
     * 通过用户表id查询数据
     */
    @GetMapping("getUserById")
    public R getUserById(Integer id){
        UserInfo userInfo = userInfoService.getById(id);
        return R.ok().put("row", userInfo);
    }

    /**
     * 通过用户表id查询数据
     */
    @GetMapping("getAll")
    public R getAll(){
        List<UserInfo> all = userInfoService.getAll();
        System.out.println(all);
        return R.ok().put("row", all);
    }


    /**
     * 分页添加查询数据
     * @param current 当前页码
     * @param size 每页大小
     * @param userInfo 查询数据
     * @return
     */
    @PostMapping("pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current,
                       @PathVariable int size,
                       @RequestBody UserInfo userInfo){
        PageResult<UserInfo> pageResult = userInfoService.pageQuery(userInfo, current, size);
        return R.ok().put("list", pageResult);
    }


    /**
     * 新增数据
     * @param userInfo
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody UserInfo userInfo){
        userInfoService.save(userInfo);
        return R.ok();
    }

    /**
     * 修改数据
     * @param userInfo
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody UserInfo userInfo){
        userInfoService.update(userInfo);
        return R.ok();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable Integer id){
        userInfoService.delete(id);
        return R.ok();
    }
}
