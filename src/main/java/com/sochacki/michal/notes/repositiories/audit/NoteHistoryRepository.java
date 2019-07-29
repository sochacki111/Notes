package com.sochacki.michal.notes.repositiories.audit;

import com.sochacki.michal.notes.entity.Note;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class NoteHistoryRepository implements INoteHistoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Note> listCustomerRevisions(int noteId) {

        // Create Audit Reader
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        // Create the Query of audited Note:
        AuditQuery auditQuery = auditReader.createQuery()
                .forRevisionsOfEntity(Note.class, true, true)
                .add(AuditEntity.id().eq(noteId));

        List<Note> audit = auditQuery.getResultList();

        return audit;
    }


}
