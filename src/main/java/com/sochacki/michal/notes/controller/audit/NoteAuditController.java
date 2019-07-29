package com.sochacki.michal.notes.controller.audit;


import com.sochacki.michal.notes.entity.Note;
import com.sochacki.michal.notes.repositiories.audit.INoteAuditRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/audit")
public class NoteAuditController {

    private final INoteAuditRepository repository;

    public NoteAuditController(INoteAuditRepository repository) {
        this.repository = repository;
    }


    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public @ResponseBody List<Note> getNoteHistory(@PathVariable(value = "id") int id) {

        List<Note> history = repository.listNoteRevisions(id);

        return history;
    }
}
