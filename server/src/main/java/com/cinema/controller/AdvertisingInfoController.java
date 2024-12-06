package com.cinema.controller;

import com.cinema.entity.AdvertisingInfo;
import com.cinema.service.AdvertisingInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 对管理平台提供 广告信息管理接口
 */
@RequestMapping("advertisingInfo")
@RestController
public class AdvertisingInfoController {


    @Autowired
    private AdvertisingInfoService advertisingInfoService;


    /**
     * 分页添加查询数据
     * @param current 当前页码
     * @param size 每页大小
     * @param advertisingInfo 查询数据
     * @return
     */
    @PostMapping("pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current,
                       @PathVariable int size,
                       @RequestBody AdvertisingInfo advertisingInfo){
        PageResult<AdvertisingInfo> pageResult = advertisingInfoService.pageQuery(advertisingInfo, current, size);
        return R.ok().put("list", pageResult);
    }


    /**
     * 新增数据
     * @param advertisingInfo
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody AdvertisingInfo advertisingInfo){
        advertisingInfoService.save(advertisingInfo);
        return R.ok();
    }

    /**
     * 修改数据
     * @param advertisingInfo
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody AdvertisingInfo advertisingInfo){
        advertisingInfoService.update(advertisingInfo);
        return R.ok();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable Integer id){
        advertisingInfoService.delete(id);
        return R.ok();
    }
}
