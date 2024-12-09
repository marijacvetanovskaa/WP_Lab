package mk.finki.ukim.mk.lab.web.controller;

import lombok.AllArgsConstructor;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/artist")
@AllArgsConstructor
public class ArtistController {

    final private ArtistService artistService;
    final private SongService songService;

    @GetMapping
    public String getArtists(@RequestParam(required = false) String trackId, Model model)
    {
        model.addAttribute("trackId", trackId);
        model.addAttribute("artists", artistService.listArtists());
        return "artistList";
    }

    @PostMapping("/add")
    public String addArtistToSong(
                           @RequestParam String trackId,
                           @RequestParam String artistId) {

        Artist chosenArtist = artistService.findById(Long.parseLong(artistId));
        songService.addArtistToSong(chosenArtist, songService.findByTrackId(trackId));

        return "redirect:/songDetails?trackId=" + trackId;
    }
}
