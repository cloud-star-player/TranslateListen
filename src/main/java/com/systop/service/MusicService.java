package com.systop.service;

import com.systop.po.Music;


import java.util.List;

public interface MusicService {
    public Integer musicadd(Music music);
    public List<Music>musicall();
    public Music musicselectid(Integer music_id);
    public Integer update_music(Music music);
    public Integer music_delete(List list);
    public Integer music_deletefyid(Integer music_id);

}
