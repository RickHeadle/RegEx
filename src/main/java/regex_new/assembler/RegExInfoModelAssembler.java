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
import regex_new.controller.RegExInfoController;
import regex_new.entity.RegExInfo;
import regex_new.model.RegExInfoModel;

@Component
public class RegExInfoModelAssembler extends RepresentationModelAssemblerSupport<RegExInfo, RegExInfoModel> {

  @Autowired
  private PagedResourcesAssembler<RegExInfo> pagedResourcesAssembler;

  public RegExInfoModelAssembler() {
    super(RegExInfoController.class, RegExInfoModel.class);
  }

  @Override
  public RegExInfoModel toModel(RegExInfo entity) {
    return assemble(new RegExInfoModel(), entity);
  }

  public PagedModel<RegExInfoModel> toPagedModel(Page<RegExInfo> entity) {
    return pagedResourcesAssembler.toModel(entity, this);
  }

  private RegExInfoModel assemble(RegExInfoModel model, RegExInfo entity) {
    model.setId(entity.getId());
    model.setRegularExpression(entity.getRegularExpression());
    model.setDescription(entity.getDescription());

    model.add(getSelfLink(entity.getId()));

    return model;
  }

  private Link getSelfLink(Long entityId) {
    return linkTo(methodOn(RegExInfoController.class).findById(entityId)).withSelfRel();
  }

}
