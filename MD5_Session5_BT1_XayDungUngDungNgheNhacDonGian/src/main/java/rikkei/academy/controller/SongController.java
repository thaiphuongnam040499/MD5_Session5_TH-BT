package rikkei.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import rikkei.academy.model.entity.Song;
import rikkei.academy.model.service.ISongService;
import rikkei.academy.model.service.SongServiceIMPL;

import java.util.List;

@Controller
@RequestMapping({"/"})
public class SongController {
    ISongService songService = new SongServiceIMPL();
    @GetMapping("/show")
    public String showListSong(Model model){
        List<Song> list =  songService.findAll();
        model.addAttribute("listSong",list);
        return "list";
    }
}
