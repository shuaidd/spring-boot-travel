package com.travel.qywx.service;

import com.travel.qywx.dto.Department;
import com.travel.qywx.dto.Tag;
import com.travel.qywx.dto.WeChatUser;
import com.travel.qywx.response.*;
import com.travel.qywx.resquest.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 企业微信通讯录管理
 *
 * @author ddshuai
 * @date 2019-04-04 14:22
 **/
@Service
public class AddressBookService extends AbstractBaseService {

    /**
     * 创建用户
     *
     * @param request
     */
    public void createUser(CreateUserRequest request, String applicationName) {
        if (Objects.nonNull(request)) {
            BaseResponse baseResponse = weChatClient.createUser(request, applicationName);
            if (isSuccess(baseResponse)) {
                logger.info("用户创建成功:{}", request);
            }
        }
    }

    /**
     * 读取成员信息
     *
     * @param userId          用户编号
     * @param applicationName 应用
     * @return WeChatUserResponse
     */
    public WeChatUserResponse getUser(String userId, String applicationName) {
        WeChatUserResponse weChatUserResponse = null;
        if (StringUtils.isNotEmpty(userId)) {
            weChatUserResponse = weChatClient.getUser(userId, applicationName);
            if (isSuccess(weChatUserResponse)) {
                if (logger.isInfoEnabled()) {
                    logger.info("读取到成员信息：{}", weChatUserResponse);
                }
            }
        }

        return weChatUserResponse;
    }

    /**
     * 更新成员信息
     *
     * @param request         更新信息
     * @param applicationName 应用
     */
    public void updateUser(UpdateUserRequest request, String applicationName) {
        if (Objects.nonNull(request) && StringUtils.isNotEmpty(request.getUserId())) {
            BaseResponse baseResponse = weChatClient.updateUser(request, applicationName);
            if (isSuccess(baseResponse)) {
                if (logger.isInfoEnabled()) {
                    logger.info("更新成员信息成功：userId-{},applicationName-{}", request.getUserId(), applicationName);
                }
            }
        }
    }

    /**
     * 删除成员
     *
     * @param userId
     * @param applicationName
     */
    public void deleteUser(String userId, String applicationName) {
        if (StringUtils.isNotEmpty(userId)) {
            BaseResponse response = weChatClient.deleteUser(userId, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("删除成员成功：userId-{},applicationName-{}", userId, applicationName);
                }
            }
        }
    }

    /**
     * 批量删除成员
     *
     * @param request
     * @param applicationName
     */
    public void batchDeleteUser(BatchDeleteUserRequest request, String applicationName) {
        if (Objects.nonNull(request) && CollectionUtils.isNotEmpty(request.getUserIdList())) {
            BaseResponse response = weChatClient.batchDelete(request, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("批量删除成员成功：{},applicationName-{}", request, applicationName);
                }
            }
        }
    }

    /**
     * 获取部门成员
     *
     * @param departmentId    企业微信端部门编号
     * @param fetchChild      是否获取子部门人员
     * @param applicationName 应用
     * @return
     */
    public List<WeChatUser> getDepartmentUser(Integer departmentId, boolean fetchChild, String applicationName) {
        List<WeChatUser> weChatUsers = new ArrayList<>(1);
        if (Objects.nonNull(departmentId)) {
            Integer getChild = fetchChild ? 1 : 0;
            DepartmentUserResponse departmentUserResponse = weChatClient.getDepartmentUser(departmentId, getChild, applicationName);
            if (isSuccess(departmentUserResponse)) {
                weChatUsers = departmentUserResponse.getWeChatUserList();

                if (logger.isInfoEnabled()) {
                    logger.info("获取部门成员成功：applicationName-{}", applicationName);
                }
            }
        }

        return weChatUsers;
    }

    /**
     * 获取部门成员详情
     *
     * @param departmentId    企业微信端部门编号
     * @param fetchChild      是否获取子部门人员
     * @param applicationName 应用
     * @return
     */
    public List<WeChatUser> getDepartmentUserDetail(Integer departmentId, boolean fetchChild, String applicationName) {
        List<WeChatUser> weChatUsers = new ArrayList<>(1);
        if (Objects.nonNull(departmentId)) {
            Integer getChild = fetchChild ? 1 : 0;
            DepartmentUserResponse departmentUserResponse = weChatClient.getDepartmentUserDetail(departmentId, getChild, applicationName);
            if (isSuccess(departmentUserResponse)) {
                weChatUsers = departmentUserResponse.getWeChatUserList();

                if (logger.isInfoEnabled()) {
                    logger.info("获取部门成员成功：applicationName-{}", applicationName);
                }
            }
        }

        return weChatUsers;
    }

    /**
     * userid转openid
     *
     * @param userId
     * @param applicationName
     * @return
     */
    public String convertToOpenId(String userId, String applicationName) {
        String openId = null;
        if (StringUtils.isNotEmpty(userId)) {
            ConvertUserIdOpenIdResponse response = weChatClient.convertToOpenId(new ConvertUserIdOpenIdRequest(userId, null), applicationName);
            if (isSuccess(response)) {
                openId = response.getOpenId();
                if (logger.isInfoEnabled()) {
                    logger.info("获取openId成功：openid-{}applicationName-{}", openId, applicationName);
                }
            }
        }

        return openId;
    }

    /**
     * openid转userid
     *
     * @param openId
     * @param applicationName
     * @return
     */
    public String convertToUserId(String openId, String applicationName) {
        String userId = null;
        if (StringUtils.isNotEmpty(openId)) {
            ConvertUserIdOpenIdResponse response = weChatClient.convertToUserId(new ConvertUserIdOpenIdRequest(null, openId), applicationName);
            if (isSuccess(response)) {
                userId = response.getUserId();
                if (logger.isInfoEnabled()) {
                    logger.info("获取用户ID成功：userId-{},applicationName-{}", userId, applicationName);
                }
            }
        }

        return userId;
    }

    /**
     * 二次验证
     *
     * @param userId
     * @param applicationName
     */
    public void authSuccess(String userId, String applicationName) {
        if (StringUtils.isNotEmpty(userId)) {
            BaseResponse response = weChatClient.authSucc(userId, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("二次验证成功：userId-{},applicationName-{}", userId, applicationName);
                }
            }
        }
    }

    /**
     * 邀请成员
     *
     * @param request
     * @param applicationName
     */
    public void invite(InviteUserRequest request, String applicationName) {
        if (Objects.nonNull(request)) {
            if (CollectionUtils.isEmpty(request.getParty()) && CollectionUtils.isEmpty(request.getTag()) && CollectionUtils.isEmpty(request.getUser())) {
                return;
            }
            BaseResponse baseResponse = weChatClient.invite(request, applicationName);
            if (isSuccess(baseResponse)) {
                if (logger.isInfoEnabled()) {
                    logger.info("邀请成功：applicationName-{}", applicationName);
                }
            }
        }
    }

    /**
     * 创建部门
     *
     * @param request
     * @param applicationName
     * @return
     */
    public CreateDepartmentResponse createDepartment(DepartmentRequest request, String applicationName) {
        CreateDepartmentResponse response = null;
        if (Objects.nonNull(request) && StringUtils.isNotEmpty(request.getName())) {
            response = weChatClient.createDepartment(request, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("创建部门成功：部门编号-{},applicationName-{}", response.getId(), applicationName);
                }
            }
        }

        return response;
    }

    /**
     * 更新部门信息
     *
     * @param request
     * @param applicationName
     */
    public void updateDepartment(DepartmentRequest request, String applicationName) {
        if (Objects.nonNull(request) && Objects.nonNull(request.getId())) {
            BaseResponse response = weChatClient.updateDepartment(request, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("更新部门成功：更新信息-{},applicationName-{}", request, applicationName);
                }
            }
        }
    }

    /**
     * 删除部门
     *
     * @param id
     * @param applicationName
     */
    public void deleteDepartment(Integer id, String applicationName) {
        if (Objects.nonNull(id)) {
            BaseResponse response = weChatClient.deleteDepartment(id, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("删除部门成功：部门编号-{},applicationName-{}", id, applicationName);
                }
            }
        }
    }

    /**
     * 拉取部门列表
     *
     * @param id
     * @param applicationName
     * @return
     */
    public List<Department> departmentList(Integer id, String applicationName) {
        List<Department> departments = new ArrayList<>(1);
        DepartmentListResponse response = weChatClient.departmentList(id, applicationName);
        if (isSuccess(response)) {
            departments = response.getDepartments();
            if (logger.isInfoEnabled()) {
                logger.info("拉取部门列表成功：部门数量-{},applicationName-{}", departments.size(), applicationName);
            }
        }

        return departments;
    }

    /**
     * 创建标签
     *
     * @param request
     * @param applicationName
     * @return
     */
    public Integer createTag(TagRequest request, String applicationName) {
        Integer tagId = null;
        if (Objects.nonNull(request) && StringUtils.isNotEmpty(request.getTagName())) {
            CreateTagResponse createTagResponse = weChatClient.createTag(request, applicationName);
            if (isSuccess(createTagResponse)) {
                tagId = createTagResponse.getTagId();
                if (logger.isInfoEnabled()) {
                    logger.info("创建标签成功：标签编号-{},applicationName-{}", tagId, applicationName);
                }
            }
        }

        return tagId;
    }

    /**
     * 更新标签名字
     *
     * @param tagId
     * @param tagName
     * @param applicationName
     */
    public void updateTagName(Integer tagId, String tagName, String applicationName) {
        if (Objects.nonNull(tagId) && StringUtils.isNotEmpty(tagName)) {
            TagRequest tagRequest = new TagRequest();
            tagRequest.setTagId(tagId);
            tagRequest.setTagName(tagName);
            BaseResponse response = weChatClient.updateTag(tagRequest, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("更新标签名字成功：标签编号[{}],标签名称[{}],applicationName-{}", tagId, tagName, applicationName);
                }
            }
        }
    }

    /**
     * 删除标签
     *
     * @param tagId
     * @param applicationName
     */
    public void deleteTag(Integer tagId, String applicationName) {
        if (Objects.nonNull(tagId)) {
            BaseResponse response = weChatClient.deleteTag(tagId, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("删除标签成功：标签编号[{}],applicationName-{}", tagId, applicationName);
                }
            }
        }
    }

    /**
     * 获取标签成员
     *
     * @param tagId
     * @param applicationName
     * @return
     */
    public QueryTagUserResponse getTagUser(Integer tagId, String applicationName) {
        QueryTagUserResponse response = null;
        if (Objects.nonNull(tagId)) {
            response = weChatClient.getTagUser(tagId, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("获取标签成员成功：标签编号[{}],applicationName-{}", tagId, applicationName);
                }
            }
        }

        return response;
    }

    /**
     * 增加标签成员
     *
     * @param request
     * @param applicationName
     * @return
     */
    public TagUserResponse addTagUsers(TagUserRequest request, String applicationName) {
        TagUserResponse response = null;
        if (Objects.nonNull(request) && Objects.nonNull(request.getTagId())) {
            response = weChatClient.addTagUsers(request, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("增加标签成员成功：标签编号[{}],applicationName-{}", request.getTagId(), applicationName);
                }
            }
        }
        return response;
    }

    /**
     * 删除标签成员
     *
     * @param request
     * @param applicationName
     * @return
     */
    public TagUserResponse deleteTagUsers(TagUserRequest request, String applicationName) {
        TagUserResponse response = null;
        if (Objects.nonNull(request) && Objects.nonNull(request.getTagId())) {
            response = weChatClient.deleteTagUsers(request, applicationName);
            if (isSuccess(response)) {
                if (logger.isInfoEnabled()) {
                    logger.info("删除标签成员成功：标签编号[{}],applicationName-{}", request.getTagId(), applicationName);
                }
            }
        }
        return response;
    }

    /**
     * 获取标签列表
     *
     * @param applicationName
     * @return
     */
    public List<Tag> getTagList(String applicationName) {
        List<Tag> tags = new ArrayList<>(1);
        TagListResponse response = weChatClient.getTagList(applicationName);
        if (isSuccess(response)) {
            tags = response.getTagList();
            if (logger.isInfoEnabled()) {
                logger.info("获取标签列表成功：applicationName-{}", applicationName);
            }
        }

        return tags;
    }
}
