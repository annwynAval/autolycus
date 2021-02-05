package com.annwyn.autolycus.platform.core.service;


import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.platform.mybatis.model.Region;

public interface RegionService {

    /**
     * 根据父id与名称进行检索
     * @param regionId .
     * @param regionName .
     * @return .
     */
    QueryResponse<Region> listChildren(Integer regionId, String regionName);

}
