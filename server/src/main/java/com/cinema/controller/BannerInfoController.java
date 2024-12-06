package com.cinema.controller;

import com.cinema.entity.BannerInfo;
import com.cinema.service.BannerInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 对管理平台提供 轮播图广告信息管理接口
 */
@RequestMapping("bannerInfo")
@RestController
public class BannerInfoController {


    @Autowired
    private BannerInfoService bannerInfoService;


    /**
     * 分页添加查询数据
     * @param current 当前页码
     * @param size 每页大小
     * @param bannerInfo 查询数据
     * @return
     */
    @PostMapping("pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current,
                       @PathVariable int size,
                       @RequestBody BannerInfo bannerInfo){
        PageResult<BannerInfo> pageResult = bannerInfoService.pageQuery(bannerInfo, current, size);
        return R.ok().put("list", pageResult);
    }


    /**
     * 新增数据
     * @param bannerInfo
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody BannerInfo bannerInfo){
        bannerInfoService.save(bannerInfo);
        return R.ok();
    }

    /**
     * 修改数据
     * @param bannerInfo
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody BannerInfo bannerInfo){
        bannerInfoService.update(bannerInfo);
        return R.ok();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable Integer id){
        bannerInfoService.delete(id);
        return R.ok();
    }
}
