package com.sochacki.michal.notes.controller.audit;


import com.sochacki.michal.notes.entity.Note;
import com.sochacki.michal.notes.repositiories.audit.INoteHistoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/history")
public class NoteHistoryController {

    private final INoteHistoryRepository repository;

    public NoteHistoryController(INoteHistoryRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/note/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Note> getHistory(@PathVariable(value = "id") int id) {

        List<Note> history = repository.listCustomerRevisions(id);

        return history;
    }
}
