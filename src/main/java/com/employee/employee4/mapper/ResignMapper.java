package com.employee.employee4.mapper;

import com.employee.employee4.dto.ResignDto;
import com.employee.employee4.entity.Resign;

public class ResignMapper {
    public static ResignDto mapToResignDto(Resign resign){
        ResignDto resignDto = new ResignDto(
                resign.getId(),
                resign.getEmployee().getNama(),
                resign.getAlasan(),
                resign.getCreatedAt()
        );
        return resignDto;
    }

    public static Resign mapToResign(ResignDto resignDto){
        Resign resign = new Resign(
                resignDto.getId(),
                resignDto.getEmployee().getNama(),
                resignDto.getAlasan(),
                resignDto.getCreatedAt()
        );
        return resign;
    }
}