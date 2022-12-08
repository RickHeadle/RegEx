package regex_new.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import regex_new.assembler.RegExInfoModelAssembler;
import regex_new.disassembler.RegExInfoDtoDisassembler;
import regex_new.dto.RegExDto;
import regex_new.model.RegExInfoModel;
import regex_new.service.RegExInfoServiceImpl;
import regex_new.specification.RegExInfoSpecification;

@RestController
public class RegExInfoController {

  @Autowired
  private RegExInfoServiceImpl regExService;

  @Autowired
  private RegExInfoModelAssembler regExInfoModelAssembler;

  @Autowired
  private RegExInfoDtoDisassembler regExInfoDtoDisassembler;

  @GetMapping("/regex/all")
  public ResponseEntity<PagedModel<RegExInfoModel>> findAll(RegExInfoSpecification specification,
      Pageable pageable) {
    return Optional.of(specification)
        .map(spec -> regExService.findAll(spec, pageable))
        .map(regExInfoModelAssembler::toPagedModel)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.noContent().build());
  }

  @GetMapping("/regex/{id}")
  public ResponseEntity<RegExInfoModel> findById(@PathVariable Long id) {
    return Optional.of(id)
        .flatMap(identifier -> regExService.findById(identifier))
        .map(regEx -> regExInfoModelAssembler.toModel(regEx))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.noContent().build());
  }

  @PostMapping("/regex/create")
  public ResponseEntity<RegExInfoModel> create(@RequestBody RegExDto regExDto) {
    return Optional.of(regExDto)
        .map(regExInfoDtoDisassembler::toEntity)
        .map(regExService::save)
        .map(regExInfoModelAssembler::toModel)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.badRequest().build());
  }

  @PutMapping("/regex/update")
  public ResponseEntity<RegExInfoModel> updateByPut(@RequestBody RegExDto regExDto) {
    return Optional.of(regExDto)
        .map(regExInfoDtoDisassembler::toEntity)
        .map(regExService::save)
        .map(regExInfoModelAssembler::toModel)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.badRequest().build());
  }

  @PatchMapping("/regex/update")
  public ResponseEntity<RegExInfoModel> updateByPatch(@RequestBody RegExDto regExDto) {
    return Optional.of(regExDto)
        .map(regExInfoDtoDisassembler::toEntity)
        .map(regExService::save)
        .map(regExInfoModelAssembler::toModel)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.badRequest().build());
  }

  @DeleteMapping("/regex/{id}/delete")
  public ResponseEntity<Long> deleteById(@PathVariable Long id) {
    return Optional.of(id)
        .map(regExService::deleteById)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.noContent().build());
  }

}
