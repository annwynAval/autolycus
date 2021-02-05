package com.annwyn.autolycus.platform.core.controller;

import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.core.service.RegionService;
import com.annwyn.autolycus.platform.mybatis.model.Region;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("region")
@Api("城市数据相关api")
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
    public QueryResponse<Region> listChildren(Integer regionId, String regionName) {
        return this.regionService.listChildren(regionId, regionName);
    }

}
