package com.teamk.laube.domain.perfumebase;

import com.teamk.laube.domain.note.Note;
import com.teamk.laube.domain.perfume.Perfume;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PerfumeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="perfume_id")
    private Perfume perfume;
    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;
}
