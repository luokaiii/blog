package cn.luokaiii.blog.service;

import cn.luokaiii.blog.dao.ArticleDao;
import cn.luokaiii.blog.dao.ArticleGenreDao;
import cn.luokaiii.blog.dao.ArticleTagDao;
import cn.luokaiii.blog.dto.article.ArticleBaseCreateDTO;
import cn.luokaiii.blog.entity.Article;
import cn.luokaiii.blog.entity.ArticleGenre;
import cn.luokaiii.blog.entity.ArticleTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date 2021/1/27
 */
@Service
public class ArticleService implements AbstractService<Article, Integer> {

    private final ArticleDao articleDao;

    private final ArticleTagDao articleTagDao;

    private final ArticleGenreDao articleGenreDao;

    public ArticleService(ArticleDao articleDao,
                          ArticleTagDao articleTagDao,
                          ArticleGenreDao articleGenreDao) {
        this.articleDao = articleDao;
        this.articleTagDao = articleTagDao;
        this.articleGenreDao = articleGenreDao;
    }

    @Override
    public JpaRepository<Article, Integer> getRepository() {
        return articleDao;
    }

    /**
     * 创建文章
     *
     * @param createDTO 创建对象
     * @return 新建的文章
     */
    @Transactional(rollbackFor = Exception.class)
    public Article createBase(ArticleBaseCreateDTO createDTO) {
        // 保存文章
        Article article = new Article();
        article.setTitle(createDTO.getTitle());
        article.setSubTitle(createDTO.getSubTitle());
        article.setCover(createDTO.getCover());
        article.setDeleted(false);
        article.setShelves(false);
        article.setCreateTime(new Date());
        Integer articleId = articleDao.save(article).getId();

        // 建立文章标签关系
        if (!ObjectUtils.isEmpty(createDTO.getTags())) {
            List<ArticleTag> articleTags = createDTO.getTags()
                    .stream()
                    .map(v -> new ArticleTag(articleId, v))
                    .collect(Collectors.toList());
            articleTagDao.saveAll(articleTags);
        }

        // 建立文章分类关系
        if (!ObjectUtils.isEmpty(createDTO.getGenres())) {
            List<ArticleGenre> articleGenres = createDTO.getGenres()
                    .stream()
                    .map(v -> new ArticleGenre(articleId, v))
                    .collect(Collectors.toList());
            articleGenreDao.saveAll(articleGenres);
        }
        return article;
    }

    public Page<Article> findByGenreId(Integer genreId, Pageable pageable) {
        return articleDao.findAllByGenreId(genreId, pageable);
    }

    public Page<Article> findByTagId(Integer tagId, Pageable pageable) {
        return articleDao.findAllByTagId(tagId, pageable);
    }
}
