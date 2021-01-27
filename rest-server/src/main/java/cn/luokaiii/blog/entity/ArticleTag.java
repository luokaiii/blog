package cn.luokaiii.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 文章的标签
 *
 * @Date 2021/1/27
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "blog_article_tag")
public class ArticleTag extends AbstractEntity {
    /**
     * 文章ID
     */
    private Integer articleId;
    /**
     * 标签ID
     */
    private Integer tagId;

    public ArticleTag() {
    }

    public ArticleTag(Integer articleId, Integer tagId) {
        this.articleId = articleId;
        this.tagId = tagId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return super.getId();
    }
}
