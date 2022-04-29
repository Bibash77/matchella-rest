package com.invo.matchela.api.entity.controller;

import com.invo.matchela.api.entity.dto.CardDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Card API")
public interface CardController {
    @ApiOperation("Add new data")
    public CardDTO save(@RequestBody CardDTO card);

    @ApiOperation("Find by Id")
    public CardDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<CardDTO> list();

    @ApiOperation("Pagination request")
    public Page<CardDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public CardDTO update(@RequestBody CardDTO dto, @PathVariable("id") Long id);
}