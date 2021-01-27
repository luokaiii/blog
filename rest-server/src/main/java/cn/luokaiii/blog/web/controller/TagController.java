package cn.luokaiii.blog.web.controller;

import cn.luokaiii.blog.dto.tag.TagCreateDTO;
import cn.luokaiii.blog.entity.Tag;
import cn.luokaiii.blog.service.TagService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 标签接口
 *
 * @Date 2021/1/26
 */
@RestController
@RequestMapping("/web/tag")
@Api(tags = "标签管理接口")
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/")
    @ApiOperation("标签列表")
    public ResponseEntity<List<Tag>> findAll(@SortDefault Sort sort) {
        List<Tag> all = tagService.findAll(sort);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    @ApiOperation("ID查询标签")
    public ResponseEntity<Tag> findById(@PathVariable Integer id) {
        Optional<Tag> optional = tagService.findById(id);
        return optional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping("/")
    @ApiOperation("新增标签")
    public ResponseEntity<Tag> create(@RequestBody TagCreateDTO dto) {
        Tag tag = new Tag();
        tag.setTitle(dto.getTitle());
        return ResponseEntity.ok(tagService.create(tag));
    }
}
