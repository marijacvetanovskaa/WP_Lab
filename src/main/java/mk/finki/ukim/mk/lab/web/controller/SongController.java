package mk.finki.ukim.mk.lab.web.controller;
import lombok.RequiredArgsConstructor;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model)
    {
        model.addAttribute("songs", songService.listSongs());
        model.addAttribute("error", error);
        return "listSongs";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        songService.deleteById(id);
        return "redirect:/songs";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam(required = false) Long id,
                           @RequestParam String title,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam int releaseYear,
                           @RequestParam Long album) {

        if (id != null) {
            songService.editSong(id, title, trackId, genre, releaseYear, album);
        } else {
            songService.addSong(title, trackId, genre, releaseYear, album);
        }

        return "redirect:/songs";
    }

    @GetMapping("/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id, Model model) {
        Song song = songService.findById(id);
        if (song == null) {
            return "redirect:/songs?error=NoTrackByThatIdFound";
        }
        model.addAttribute("song", song);
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }
    @GetMapping("/details/{id}")
    public String getDetails(@PathVariable Long id, Model model)
    {
        Song song = songService.findById(id);
        if (song == null) {
            return "redirect:/songs?error=NoTrackByThatIdFound";
        }
        model.addAttribute("song", song);
        return "songDetails";
    }
    @GetMapping("/add-form")
    public String getEditSongForm(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }

    @GetMapping("/album/{albumId}")
    public String getSongsByAlbum(@PathVariable String albumId, Model model) {
        model.addAttribute("songs", songService.getSongsByAlbumId(Long.parseLong(albumId)));
        return "listSongs";
    }
}
