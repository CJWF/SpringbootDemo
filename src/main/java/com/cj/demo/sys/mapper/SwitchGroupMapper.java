package com.cj.demo.sys.mapper;

import com.cj.demo.sys.model.SwitchGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("switchGrouprMapper")
public interface SwitchGroupMapper {

    public void insertSwitchGroup(SwitchGroup switchGroup);

    public void deleteSwitchGroup(String gId);

    public void updateSwitchGroup(SwitchGroup switchGroup);

    public SwitchGroup selectSwitchGroup(String gID);

    public List<SwitchGroup> getSwitchGroup();

}
