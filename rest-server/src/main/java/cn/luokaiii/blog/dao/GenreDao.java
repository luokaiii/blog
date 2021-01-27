package cn.luokaiii.blog.dao;

import cn.luokaiii.blog.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 分类
 *
 * @Date 2021/1/27
 */
public interface GenreDao extends JpaRepository<Genre, Integer> {

    List<Genre> findAllByParentId(Integer parentId);
}
