package com.teamk.laube.domain.perfumetop;

import com.teamk.laube.domain.note.Note;
import com.teamk.laube.domain.perfume.Perfume;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class PerfumeTop {
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
