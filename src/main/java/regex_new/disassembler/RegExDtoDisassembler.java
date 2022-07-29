package regex_new.disassembler;

import org.springframework.stereotype.Component;
import regex_new.dto.RegExDto;
import regex_new.entity.RegEx;

@Component
public class RegExDtoDisassembler {

    public RegEx toEntity(RegExDto dto) {
        return assemble(new RegEx(), dto);
    }

    private RegEx assemble(RegEx entity, RegExDto dto) {
        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        entity.setDescription(dto.getDescription());
        entity.setRegularExpression(dto.getRegularExpression());

        return entity;
    }
}
