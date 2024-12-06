package com.cinema.controller;

import com.cinema.entity.FilmInfo;
import com.cinema.service.FilmInfoService;
import com.cinema.utils.PageResult;
import com.cinema.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 对管理平台提供 电影信息管理接口
 */
@RequestMapping("filmInfo")
@RestController
public class FilmInfoController {


    @Autowired
    private FilmInfoService filmInfoService;


    /**
     * 分页添加查询数据
     * @param current 当前页码
     * @param size 每页大小
     * @param filmInfo 查询数据
     * @return
     */
    @PostMapping("pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current,
                       @PathVariable int size,
                       @RequestBody FilmInfo filmInfo){
        PageResult<FilmInfo> pageResult = filmInfoService.pageQuery(filmInfo, current, size);
        return R.ok().put("list", pageResult);
    }


    /**
     * 新增数据
     * @param filmInfo
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody FilmInfo filmInfo){
        filmInfoService.save(filmInfo);
        return R.ok();
    }

    /**
     * 修改数据
     * @param filmInfo
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody FilmInfo filmInfo){
        filmInfoService.update(filmInfo);
        return R.ok();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable Integer id){
        filmInfoService.delete(id);
        return R.ok();
    }

    /**
     * 查询所有电影信息
     * @return
     */
    @GetMapping("getFilmAll")
    public R getFilmAll(){

        return R.ok().put("data", filmInfoService.getAll());
    }
}
