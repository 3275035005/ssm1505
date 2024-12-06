package com.cinema.controller;

import com.cinema.entity.FeedbackInfo;
import com.cinema.service.FeedbackInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 对管理平台提供 意见反馈管理接口
 */
@RequestMapping("feedbackInfo")
@RestController
public class FeedbackInfoController {


    @Autowired
    private FeedbackInfoService feedbackInfoService;


    /**
     * 分页添加查询数据
     * @param current 当前页码
     * @param size 每页大小
     * @param feedbackInfo 查询数据
     * @return
     */
    @PostMapping("pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current,
                       @PathVariable int size,
                       @RequestBody FeedbackInfo feedbackInfo){
        PageResult<FeedbackInfo> pageResult = feedbackInfoService.pageQuery(feedbackInfo, current, size);
        return R.ok().put("list", pageResult);
    }


    /**
     * 新增数据
     * @param feedbackInfo
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody FeedbackInfo feedbackInfo){
        feedbackInfoService.save(feedbackInfo);
        return R.ok();
    }

    /**
     * 修改数据
     * @param feedbackInfo
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody FeedbackInfo feedbackInfo){
        feedbackInfoService.update(feedbackInfo);
        return R.ok();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable Integer id){
        feedbackInfoService.delete(id);
        return R.ok();
    }
}
