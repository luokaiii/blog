package cn.luokaiii.blog.dto.genre;

import lombok.Data;

/**
 * 分类创建对象
 *
 * @Date 2021/1/27
 */
@Data
public class GenreCreateDTO {
    /**
     * 父分类
     */
    private Integer parentId;
    /**
     * 名称
     */
    private String title;
}
