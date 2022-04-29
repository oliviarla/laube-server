package com.teamk.laube.dto;

import com.teamk.laube.domain.note.Note;
import lombok.Getter;

@Getter
public class NoteResponseDto {
    private String name_kor;

    public NoteResponseDto(Note entity){
        this.name_kor= entity.getName_kor();
    }
}
