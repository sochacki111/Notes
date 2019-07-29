package com.sochacki.michal.notes.repositiories.audit;


import com.sochacki.michal.notes.entity.Note;

import java.util.List;

public interface INoteAuditRepository {

    List<Note> listNoteRevisions(int noteId);

}
