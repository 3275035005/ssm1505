package com.cinema.controller;

import com.cinema.entity.JournalismInfo;
import com.cinema.service.JournalismInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 对管理平台提供 电影新闻资讯管理接口
 */
@RequestMapping("journalismInfo")
@RestController
public class JournalismInfoController {


    @Autowired
    private JournalismInfoService journalismInfoService;


    /**
     * 分页添加查询数据
     * @param current 当前页码
     * @param size 每页大小
     * @param journalismInfo 查询数据
     * @return
     */
    @PostMapping("pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current,
                       @PathVariable int size,
                       @RequestBody JournalismInfo journalismInfo){
        PageResult<JournalismInfo> pageResult = journalismInfoService.pageQuery(journalismInfo, current, size);
        return R.ok().put("list", pageResult);
    }


    /**
     * 新增数据
     * @param journalismInfo
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody JournalismInfo journalismInfo){
        journalismInfoService.save(journalismInfo);
        return R.ok();
    }

    /**
     * 修改数据
     * @param journalismInfo
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody JournalismInfo journalismInfo){
        journalismInfoService.update(journalismInfo);
        return R.ok();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable Integer id){
        journalismInfoService.delete(id);
        return R.ok();
    }
}
