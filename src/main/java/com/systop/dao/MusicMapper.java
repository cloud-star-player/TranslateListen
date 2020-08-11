package com.systop.dao;

import com.systop.po.Music;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MusicMapper {
    Integer musicadd(Music music);
    List<Music> musicall();
    Music musicselectid(@Param("music_id")Integer music_id);
    Integer update_music(Music music);
    Integer music_delete(List list);
    Integer music_deletefyid(@Param("music_id")Integer music_id);
}
