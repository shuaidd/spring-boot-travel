package com.travel.qywx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-06 22:47
 **/
public class AllowParty {
    @JsonProperty("partyid")
    private List<Integer> partys;
}
