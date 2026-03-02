package edu.iesam.features.songs.domain;

import edu.iesam.features.albums.domain.Album;
import edu.iesam.features.albums.domain.AlbumRepository;

public class SaveSongUseCase {

    private SongRepository songRepository;


    public SaveSongUseCase(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public void execute(Song song) {
        songRepository.saveSong(song);
    }
}
