package rikkei.academy.model.service;

import rikkei.academy.model.entity.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findById(Long id);

    void deleteById(Long id);

    void save(Song song);
}
