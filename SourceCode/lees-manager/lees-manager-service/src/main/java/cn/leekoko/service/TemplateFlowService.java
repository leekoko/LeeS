package cn.leekoko.service;

import cn.leekoko.pojo.Templateflow;

import java.util.List;

public interface TemplateFlowService {
    boolean save(Templateflow templateflow);
    List<Templateflow> getList();
    boolean delete(String code);
}
