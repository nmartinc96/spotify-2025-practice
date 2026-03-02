package edu.iesam.features.songs.presentation;

import edu.iesam.features.albums.data.AlbumDataRepository;
import edu.iesam.features.albums.data.AlbumMemLocalDataSource;
import edu.iesam.features.albums.domain.Album;
import edu.iesam.features.albums.domain.DeleteAlbumUseCase;
import edu.iesam.features.albums.domain.SaveAlbumUseCase;
import edu.iesam.features.songs.data.SongDataRepository;
import edu.iesam.features.songs.data.SongMemLocalDataSource;
import edu.iesam.features.songs.domain.*;

import java.util.ArrayList;

public class SongView {


    public static void printSongs() {
        GetSongsUseCase getSongsUseCase = new GetSongsUseCase(new SongDataRepository(new SongMemLocalDataSource()));

        ArrayList<Song> songsList = getSongsUseCase.execute();

        System.out.println(songsList);
    }

    public static void saveSong() {
        Song newSong = new Song("1", "Canción 1", "Author 1", "05:20");
        SaveSongUseCase saveSongUseCase = new SaveSongUseCase(
                new SongDataRepository(SongMemLocalDataSource.newInstance())
        );
        saveSongUseCase.execute(newSong);

        //visualizo las canciones para ver si se están añadiendo correctamente.
        printSongs();
    }

    public static void deleteSong() {
        DeleteSongUseCase deleteSongUseCase = new DeleteSongUseCase(new SongDataRepository(SongMemLocalDataSource.newInstance()));
        //Escojo un ID que exista, por ejemplo el 1.
        //Para probar esta funcionalidad aconsejo ejecutar esto en el main:
        //SongView.saveSong();
        //SongView.deleteSong();
        deleteSongUseCase.execute("1");

        //visualizo las canciones para ver si se ha eliminado correctamente.
        printSongs();
    }
}
