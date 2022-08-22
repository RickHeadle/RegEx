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
import regex_new.assembler.RegExModelAssembler;
import regex_new.disassembler.RegExDtoDisassembler;
import regex_new.dto.RegExDto;
import regex_new.model.RegExModel;
import regex_new.service.RegExServiceImpl;
import regex_new.specification.RegExSpecification;

@RestController
public class RegExController {

  @Autowired
  private RegExServiceImpl regExService;

  @Autowired
  private RegExModelAssembler regExModelAssembler;

  @Autowired
  private RegExDtoDisassembler regExDtoDisassembler;

  @GetMapping("/regex/all")
  public ResponseEntity<PagedModel<RegExModel>> findAll(RegExSpecification specification,
      Pageable pageable) {
    return Optional.of(specification)
        .map(spec -> regExService.findAll(spec, pageable))
        .map(regExModelAssembler::toPagedModel)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.noContent().build());
  }

  @GetMapping("/regex/{id}")
  public ResponseEntity<RegExModel> findById(@PathVariable Long id) {
    return Optional.of(id)
        .flatMap(identifier -> regExService.findById(identifier))
        .map(regEx -> regExModelAssembler.toModel(regEx))
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.noContent().build());
  }

  @PostMapping("/regex/create")
  public ResponseEntity<RegExModel> create(@RequestBody RegExDto regExDto) {
    return Optional.of(regExDto)
        .map(regExDtoDisassembler::toEntity)
        .map(regExService::save)
        .map(regExModelAssembler::toModel)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.badRequest().build());
  }

  //TODO: переписать под изменение по ID
  @PutMapping("/regex/update")
  public ResponseEntity<RegExModel> updateByPut(@RequestBody RegExDto regExDto) {
    return Optional.of(regExDto)
        .map(regExDtoDisassembler::toEntity)
        .map(regExService::save)
        .map(regExModelAssembler::toModel)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.badRequest().build());
  }

  @PatchMapping("/regex/update")
  public ResponseEntity<RegExModel> updateByPatch(@RequestBody RegExDto regExDto) {
    return Optional.of(regExDto)
        .map(regExDtoDisassembler::toEntity)
        .map(regExService::save)
        .map(regExModelAssembler::toModel)
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
