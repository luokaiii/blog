package cn.luokaiii.blog.dto.article;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 文章创建对象
 *
 * @Date 2021/1/27
 */
@Getter
@Setter
public class ArticleBaseCreateDTO {
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
     * 标签
     */
    private List<Integer> tags;
    /**
     * 分类
     */
    private List<Integer> genres;
}
