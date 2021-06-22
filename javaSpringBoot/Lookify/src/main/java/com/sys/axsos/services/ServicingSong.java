package com.sys.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sys.axsos.models.Song;
import com.sys.axsos.repositories.SongRepo;

@Service
public class ServicingSong {
    private final SongRepo songrepositoryinstance;

    public ServicingSong(SongRepo songrepositoryinstance) {
		super();
		this.songrepositoryinstance = songrepositoryinstance;
	}
    
	public List<Song> songinstances() {
    	return songrepositoryinstance.findAll();
    }
    public Song findsonginstance(Long id) {
        Optional<Song> optionalSong = songrepositoryinstance.findById(id);
        if(optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }
    public Song createsonginstance(Song b) {
        return songrepositoryinstance.save(b);
    }

	public void deletesonginstance(Long id) {
		songrepositoryinstance.deleteById(id);
		
	}
    public Song updatesonginstance(Song b) {
    	Song chang = findsonginstance(b.getId());
    	chang.setTitle(b.getTitle());
    	chang.setArtist(b.getArtist());
    	chang.setRating(b.getRating());
    	return songrepositoryinstance.save(chang);
    }
}