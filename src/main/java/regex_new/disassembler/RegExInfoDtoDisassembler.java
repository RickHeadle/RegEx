package regex_new.disassembler;

import org.springframework.stereotype.Component;
import regex_new.dto.RegExDto;
import regex_new.entity.RegExInfo;

@Component
public class RegExInfoDtoDisassembler {

  public RegExInfo toEntity(RegExDto dto) {
    return assemble(new RegExInfo(), dto);
  }

  private RegExInfo assemble(RegExInfo entity, RegExDto dto) {
    if (dto.getId() != null) {
      entity.setId(dto.getId());
    }
    entity.setDescription(dto.getDescription());
    entity.setRegularExpression(dto.getRegularExpression());

    return entity;
  }
}
