package com.sys.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sys.axsos.models.Song;
import com.sys.axsos.repositories.SongRepo;

@Service
public class ServicingSong {
    private final SongRepo songrepositoryinstance;

    public ServicingSong(SongRepo sonrepoinst) {
		super();
		this.songrepositoryinstance = sonrepoinst;
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

	public List<Song> findByArtistContaining(String searchName) {
		return songrepositoryinstance.findByArtistContaining(searchName);
	}

	public List<Song> getTopTen() {
		return songrepositoryinstance.findTop10ByOrderByRatingDesc();
	}
	public List<Song> getTopTenAs() {
		return songrepositoryinstance.findTop10ByOrderByRatingAsc();
	}
}