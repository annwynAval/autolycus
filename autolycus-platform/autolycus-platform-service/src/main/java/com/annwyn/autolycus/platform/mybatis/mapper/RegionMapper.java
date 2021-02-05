package com.annwyn.autolycus.platform.mybatis.mapper;

import com.annwyn.autolycus.platform.mybatis.model.Region;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RegionMapper {

    /**
     * 根据父id与名称进行检索
     * @param parentId .
     * @param regionName .
     * @return .
     */
    List<Region> listByParentId(@Param("parentId") Integer parentId, @Param("regionName") String regionName);

    /**
     * 根据id查询城市数据
     * @param regionIds .
     * @return .
     */
    List<Region> listByIds(@Param("regionIds") List<Integer> regionIds);

    /**
     * 根据id查询
     * @param regionId .
     * @return .
     */
    Region listById(@Param("regionId") Integer regionId);
}
