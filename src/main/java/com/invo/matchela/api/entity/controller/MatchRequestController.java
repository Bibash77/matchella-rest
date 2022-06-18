package com.invo.matchela.api.entity.controller;

import com.invo.matchela.api.entity.dto.MatchRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "MatchRequest API")
public interface MatchRequestController {
    @ApiOperation("Add new data")
    public MatchRequestDTO save(@RequestBody MatchRequestDTO matchRequest);

    @ApiOperation("Find by Id")
    public MatchRequestDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<MatchRequestDTO> list();

    @ApiOperation("Pagination request")
    public Page<MatchRequestDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public MatchRequestDTO update(@RequestBody MatchRequestDTO dto, @PathVariable("id") Long id);
}