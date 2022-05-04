package com.invo.matchela.web.rest.controller.card;

import com.invo.matchela.api.dto.CardCategoryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "CardCategory API")
public interface CardCategoryController {
    @ApiOperation("Add new data")
    public CardCategoryDTO save(@RequestBody CardCategoryDTO cardCategory);

    @ApiOperation("Find by Id")
    public CardCategoryDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<CardCategoryDTO> list();

    @ApiOperation("Pagination request")
    public Page<CardCategoryDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public CardCategoryDTO update(@RequestBody CardCategoryDTO dto, @PathVariable("id") Long id);
}