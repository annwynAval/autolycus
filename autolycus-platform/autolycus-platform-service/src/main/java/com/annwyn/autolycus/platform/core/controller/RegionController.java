package com.annwyn.autolycus.platform.core.controller;

import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.core.service.RegionService;
import com.annwyn.autolycus.platform.mybatis.model.Region;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.annwyn.autolycus.platform.utils.ConstantUtils.RegionValidUtils.NAME_MAX_LENGTH;

@RestController
@RequestMapping("region")
@Api(tags = "城市数据相关api")
public class RegionController {

    @Resource
    private RegionService regionService;

    /**
     * 城市数据级联请求
     * @param regionId .
     * @param regionName .
     * @return .
     */
    @RequestMapping("listChildren")
    @ApiOperation("城市数据级联获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionId", value = "省市区id", paramType = "query"),
            @ApiImplicitParam(name = "regionName", value = "省市区名称", paramType = "query")
    })
    public QueryResponse<Region> listChildren(Integer regionId,
                                              @Length(max = NAME_MAX_LENGTH) String regionName) {
        return this.regionService.listChildren(regionId, regionName);
    }

}
