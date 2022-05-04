package com.invo.matchela.web.rest.controller.user;

import com.invo.matchela.api.dto.CardCategoryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "CardCategory API")
public interface UserController {

    @ApiOperation("Add new data")
    public void assignCategory(@RequestBody CardCategoryDTO cardCategory);

}
