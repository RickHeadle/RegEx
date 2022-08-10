package regex_new.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import regex_new.controller.RegExController;
import regex_new.entity.RegEx;
import regex_new.model.RegExModel;

@Component
public class RegExModelAssembler extends RepresentationModelAssemblerSupport<RegEx, RegExModel> {

  @Autowired
  private PagedResourcesAssembler<RegEx> pagedResourcesAssembler;

  public RegExModelAssembler() {
    super(RegExController.class, RegExModel.class);
  }

  @Override
  public RegExModel toModel(RegEx entity) {
    return assemble(new RegExModel(), entity);
  }

  public PagedModel<RegExModel> toPagedModel(Page<RegEx> entity) {
    return pagedResourcesAssembler.toModel(entity, this);
  }

  private RegExModel assemble(RegExModel model, RegEx entity) {
    model.setId(entity.getId());
    model.setRegularExpression(entity.getRegularExpression());
    model.setDescription(entity.getDescription());

    model.add(getSelfLink(entity.getId()));

    return model;
  }

  private Link getSelfLink(Long entityId) {
    return linkTo(methodOn(RegExController.class).findById(entityId)).withSelfRel();
  }

}
