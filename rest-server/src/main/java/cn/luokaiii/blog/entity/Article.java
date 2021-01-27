package cn.luokaiii.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 文章
 *
 * @Date 2021/1/27
 */
@Entity
@Table(name = "blog_article")
@Data
@EqualsAndHashCode(callSuper = true)
public class Article extends AbstractEntity {
    /**
     * 标题
     */
    private String title;
    /**
     * 副标题
     */
    private String subTitle;
    /**
     * 封面
     */
    private String cover;
    /**
     * 内容（Markdown）
     */
    private String content;
    /**
     * 上架状态
     */
    private Boolean shelves;
    /**
     * 删除状态
     */
    private Boolean deleted;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Override
    public Integer getId() {
        return super.getId();
    }
}
