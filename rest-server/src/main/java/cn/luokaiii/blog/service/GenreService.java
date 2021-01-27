package cn.luokaiii.blog.service;

import cn.luokaiii.blog.dao.GenreDao;
import cn.luokaiii.blog.dto.genre.GenreCreateDTO;
import cn.luokaiii.blog.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 分类服务
 *
 * @Date 2021/1/27
 */
@Service
public class GenreService implements AbstractService<Genre, Integer> {

    private final GenreDao genreDao;

    public GenreService(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public JpaRepository<Genre, Integer> getRepository() {
        return genreDao;
    }

    public List<Genre> findChildById(Integer id) {
        return genreDao.findAllByParentId(id);
    }

    public Genre create(GenreCreateDTO dto) {
        Genre genre = new Genre();
        genre.setTitle(dto.getTitle());
        genre.setParentId(dto.getParentId());
        genre.setDeleted(false);
        return create(genre);
    }

    public Genre update(Integer id, GenreCreateDTO dto) {
        Genre genre = findExistsById(id);
        genre.setTitle(dto.getTitle());
        return update(genre);
    }

    public Genre delete(Integer id) {
        Genre genre = findExistsById(id);
        genre.setDeleted(true);
        return update(genre);
    }
}
