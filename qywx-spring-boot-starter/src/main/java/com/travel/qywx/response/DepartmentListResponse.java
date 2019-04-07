package com.travel.qywx.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.travel.qywx.dto.Department;

import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-06 07:18
 **/
public class DepartmentListResponse extends AbstractBaseResponse {

    @JsonProperty("department")
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

}
