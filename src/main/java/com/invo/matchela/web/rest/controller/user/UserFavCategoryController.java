package com.invo.matchela.web.rest.controller.user;

import com.invo.matchela.api.dto.UserFavCategoryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "UserFavCategory API")
public interface UserFavCategoryController {
    @ApiOperation("Add new data")
    public UserFavCategoryDTO save(@RequestBody UserFavCategoryDTO userFavCategory);

    @ApiOperation("Add favorite category  multiple by dto")
    public List<UserFavCategoryDTO> saveAll(@RequestBody List<UserFavCategoryDTO> userFavCategory);

    @ApiOperation("Add favorite category mutiple by id")
    public ResponseEntity<?> saveAllByIds(@RequestBody List<Long> ids);

    @ApiOperation("Find by Id")
    public UserFavCategoryDTO findById(@PathVariable("id") Long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") Long id);

    @ApiOperation("Find all data")
    public List<UserFavCategoryDTO> list();

    @ApiOperation("Pagination request")
    public Page<UserFavCategoryDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public UserFavCategoryDTO update(@RequestBody UserFavCategoryDTO dto, @PathVariable("id") Long id);
}