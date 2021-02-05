package com.annwyn.autolycus.platform.core.service.impl;

import com.annwyn.autolycus.extra.model.QueryResponse;
import com.annwyn.autolycus.extra.model.ResponseStatus;
import com.annwyn.autolycus.platform.core.repository.RegionRepository;
import com.annwyn.autolycus.platform.core.service.RegionService;
import com.annwyn.autolycus.platform.mybatis.model.Region;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RegionServiceImpl implements RegionService {

    @Resource
    private RegionRepository regionRepository;

    @Override
    public QueryResponse<Region> listChildren(Integer regionId, String regionName) {
        List<Region> regions = this.regionRepository.listByParentId(regionId == null ? 0 : regionId, regionName);

        return QueryResponse.build(ResponseStatus.STATUS_SUCCESS, regions.size(), regions);
    }


}
