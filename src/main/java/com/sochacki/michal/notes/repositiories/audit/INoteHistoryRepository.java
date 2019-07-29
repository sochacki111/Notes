// Copyright (c) Philipp Wagner. All rights reserved.
// Licensed under the MIT license. See LICENSE file in the project root for full license information.

package com.sochacki.michal.notes.repositiories.audit;


import com.sochacki.michal.notes.entity.Note;

import java.util.List;

public interface INoteHistoryRepository {

    List<Note> listCustomerRevisions(int noteId);

}
