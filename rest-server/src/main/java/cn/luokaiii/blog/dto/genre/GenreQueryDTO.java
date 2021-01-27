package cn.luokaiii.blog.dto.genre;

import lombok.Data;

/**
 * 分类查询对象
 *
 * @Date 2021/1/27
 */
@Data
public class GenreQueryDTO {
    /**
     * 父分类
     */
    private Integer parentId;
    /**
     * 名称
     */
    private String title;
    /**
     * 删除状态
     */
    private Boolean deleted = false;
}
