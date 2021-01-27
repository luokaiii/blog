package cn.luokaiii.blog.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 抽象实体基类
 *
 * @Date 2021/1/27
 */
@Getter
@Setter
public abstract class AbstractEntity {

    private Integer id;

    private Date createTime;

    private Date updateTime;
}
