package com.travel.qywx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-06 22:47
 **/
public class AllowTag {

    @JsonProperty("tagid")
    private List<Integer> tagIdList;

    public List<Integer> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<Integer> tagIdList) {
        this.tagIdList = tagIdList;
    }
}
