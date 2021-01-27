package cn.luokaiii.blog.service;

import cn.luokaiii.blog.dao.TagDao;
import cn.luokaiii.blog.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * 标签服务
 *
 * @Date 2021/1/27
 */
@Service
public class TagService implements AbstractService<Tag, Integer> {

    private final TagDao tagDao;

    public TagService(TagDao tagDao) {
        this.tagDao = tagDao;
    }

    @Override
    public JpaRepository<Tag, Integer> getRepository() {
        return tagDao;
    }
}
