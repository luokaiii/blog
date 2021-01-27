package cn.luokaiii.blog.web.controller;

import cn.luokaiii.blog.dto.genre.GenreCreateDTO;
import cn.luokaiii.blog.dto.genre.GenreQueryDTO;
import cn.luokaiii.blog.entity.Genre;
import cn.luokaiii.blog.service.GenreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 分类接口
 *
 * @Date 2021/1/26
 */
@RestController
@RequestMapping("/web/genre")
@Api(tags = "分类管理接口")
public class GenreController {

    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/")
    @ApiOperation("分类列表")
    public ResponseEntity<Page<Genre>> findByPage(GenreQueryDTO dto,
                                                  @PageableDefault Pageable pageable) {
        Genre genre = new Genre();
        BeanUtils.copyProperties(dto, genre);
        Page<Genre> page = genreService.findAll(Example.of(genre), pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @ApiOperation("ID查询分类")
    public ResponseEntity<Genre> findById(@PathVariable Integer id) {
        Optional<Genre> optional = genreService.findById(id);
        return optional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping("/{id}/child")
    @ApiOperation("查询子分类")
    public ResponseEntity<List<Genre>> findChildById(@PathVariable Integer id) {
        List<Genre> list = genreService.findChildById(id);
        return ResponseEntity.ok(list);
    }

    @PostMapping("/")
    @ApiOperation("创建分类")
    public ResponseEntity<Genre> create(@RequestBody GenreCreateDTO dto) {
        Genre genre = genreService.create(dto);
        return ResponseEntity.ok(genre);
    }

    @PutMapping("/{id}")
    @ApiOperation("编辑分类")
    public ResponseEntity<Genre> update(@PathVariable Integer id,
                                        @RequestBody GenreCreateDTO dto) {
        Genre genre = genreService.update(id, dto);
        return ResponseEntity.ok(genre);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public ResponseEntity<Genre> delete(@PathVariable Integer id) {
        Genre genre = genreService.delete(id);
        return ResponseEntity.ok(genre);
    }
}
