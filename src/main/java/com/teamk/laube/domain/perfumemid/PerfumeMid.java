package com.teamk.laube.domain.perfumemid;

import com.teamk.laube.domain.note.Note;
import com.teamk.laube.domain.perfume.Perfume;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class PerfumeMid {
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
