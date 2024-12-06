package com.cinema.controller;

import com.cinema.entity.FilmEncyclopedia;
import com.cinema.service.FilmEncyclopediaService;
import com.cinema.utils.PageResult;
import com.cinema.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 对管理平台提供 电影百科管理接口
 */
@RequestMapping("filmEncyclopedia")
@RestController
public class FilmEncyclopediaController {


    @Autowired
    private FilmEncyclopediaService filmEncyclopediaService;


    /**
     * 分页添加查询数据
     * @param current 当前页码
     * @param size 每页大小
     * @param filmEncyclopedia 查询数据
     * @return
     */
    @PostMapping("pageQuery/{current}/{size}")
    public R pageQuery(@PathVariable int current,
                       @PathVariable int size,
                       @RequestBody FilmEncyclopedia filmEncyclopedia){
        PageResult<FilmEncyclopedia> pageResult = filmEncyclopediaService.pageQuery(filmEncyclopedia, current, size);
        return R.ok().put("list", pageResult);
    }


    /**
     * 新增数据
     * @param filmEncyclopedia
     * @return
     */
    @PostMapping("save")
    public R save(@RequestBody FilmEncyclopedia filmEncyclopedia){
        filmEncyclopediaService.save(filmEncyclopedia);
        return R.ok();
    }

    /**
     * 修改数据
     * @param filmEncyclopedia
     * @return
     */
    @PostMapping("update")
    public R update(@RequestBody FilmEncyclopedia filmEncyclopedia){
        filmEncyclopediaService.update(filmEncyclopedia);
        return R.ok();
    }


    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("delete/{id}")
    public R delete(@PathVariable Integer id){
        filmEncyclopediaService.delete(id);
        return R.ok();
    }
}
