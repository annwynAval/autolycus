package com.annwyn.autolycus.platform.core.repository;

import com.annwyn.autolycus.platform.mybatis.mapper.RegionMapper;
import com.annwyn.autolycus.platform.mybatis.model.Region;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class RegionRepository {

    @Resource
    private RegionMapper regionMapper;

    /**
     * 根据父id与名称进行检索
     * @param parentId .
     * @param regionName .
     * @return .
     */
    public List<Region> listByParentId(Integer parentId, String regionName) {
        return this.regionMapper.listByParentId(parentId, regionName);
    }

    /**
     * 根据id查询城市数据
     * @param regionIds .
     * @return .
     */
    public List<Region> listByIds(List<Integer> regionIds) {
        return this.regionMapper.listByIds(regionIds);
    }

    /**
     * 根据id查询
     * @param regionId .
     * @return .
     */
    public Region listById(Integer regionId) {
        return this.regionMapper.listById(regionId);
    }
}
