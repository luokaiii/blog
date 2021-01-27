package cn.luokaiii.blog.web.controller;

import cn.luokaiii.blog.dto.article.ArticleBaseCreateDTO;
import cn.luokaiii.blog.dto.article.ArticleContentUpdateDTO;
import cn.luokaiii.blog.dto.article.ArticleQueryDTO;
import cn.luokaiii.blog.entity.Article;
import cn.luokaiii.blog.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * 文章管理
 *
 * @Date 2021/1/26
 */
@RestController
@RequestMapping("/web/article")
@Api(tags = "文章管理接口")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    @ApiOperation("查询文章列表")
    public ResponseEntity<Page<Article>> findByPage(ArticleQueryDTO vo,
                                                    @PageableDefault Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatcher.of(ExampleMatcher.StringMatcher.CONTAINING));
        Article article = new Article();
        article.setTitle(vo.getSearch());
        article.setShelves(vo.getShelves());
        article.setDeleted(vo.getDeleted());
        Page<Article> page = articleService.findAll(Example.of(article, matcher), pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/genre/{genreId}")
    @ApiOperation("类型下的文章")
    public ResponseEntity<Page<Article>> findByGenreId(@PathVariable Integer genreId,
                                                       @PageableDefault Pageable pageable) {
        Page<Article> page = articleService.findByGenreId(genreId, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/tag/{tagId}")
    @ApiOperation("标签下的文章")
    public ResponseEntity<Page<Article>> findByTagId(@PathVariable Integer tagId,
                                                     @PageableDefault Pageable pageable) {
        Page<Article> page = articleService.findByTagId(tagId, pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @ApiOperation("ID查询文章")
    public ResponseEntity<Article> findById(@PathVariable Integer id) {
        Optional<Article> optional = articleService.findById(id);
        return optional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PostMapping
    @ApiOperation(value = "创建文章", notes = "基本信息")
    public ResponseEntity<Article> create(@RequestBody ArticleBaseCreateDTO dto) {
        Article article = articleService.createBase(dto);
        return ResponseEntity.ok(article);
    }

    @PutMapping("/{id}/content")
    @ApiOperation(value = "编辑文章内容", notes = "Markdown部分")
    public ResponseEntity<Article> updateContent(@PathVariable Integer id,
                                                 @RequestBody ArticleContentUpdateDTO dto) {
        Article db = articleService.findExistsById(id);
        db.setContent(dto.getContent());
        Article update = articleService.update(db);
        return ResponseEntity.ok(update);
    }

    @PutMapping("/{id}/putAway")
    @ApiOperation("上架")
    public ResponseEntity<Article> putAway(@PathVariable Integer id) {
        Article article = articleService.findExistsById(id);
        article.setShelves(true);
        Article db = articleService.update(article);
        return ResponseEntity.ok(db);
    }

    @PutMapping("/{id}/soldOut")
    @ApiOperation("下架")
    public ResponseEntity<Article> soldOut(@PathVariable Integer id) {
        Article article = articleService.findExistsById(id);
        article.setShelves(false);
        Article db = articleService.update(article);
        return ResponseEntity.ok(db);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public void drop(@PathVariable Integer id) {
        Article article = articleService.findExistsById(id);
        article.setDeleted(true);
        article.setShelves(false);
        articleService.update(article);
    }
}
