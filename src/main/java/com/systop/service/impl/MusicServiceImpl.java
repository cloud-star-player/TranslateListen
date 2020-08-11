package com.systop.service.impl;

import com.systop.dao.MusicMapper;
import com.systop.po.Music;
import com.systop.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MusicServiceImpl implements MusicService {
    @Autowired
    private MusicMapper musicMapper;
    @Override
    public Integer musicadd(Music music) {
        return musicMapper.musicadd(music);
    }
    @Override
    public List musicall() {
        return musicMapper.musicall();
    }

    @Override
    public Music musicselectid(Integer music_id) {
        return musicMapper.musicselectid(music_id);
    }

    @Override
    public Integer update_music(Music music) {
        return musicMapper.update_music(music);
    }

    @Override
    public Integer music_delete(List list) {
        return musicMapper.music_delete(list);
    }

    @Override
    public Integer music_deletefyid(Integer music_id) {
        return musicMapper.music_deletefyid(music_id);
    }
}
