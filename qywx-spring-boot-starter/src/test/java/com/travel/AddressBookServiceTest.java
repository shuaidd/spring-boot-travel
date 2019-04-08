package com.travel;

import com.travel.qywx.dto.Tag;
import com.travel.qywx.dto.WeChatUser;
import com.travel.qywx.response.AsyncJobResultResponse;
import com.travel.qywx.response.QueryTagUserResponse;
import com.travel.qywx.resquest.*;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-04 16:46
 **/
public class AddressBookServiceTest extends BaseTest {

    @Test
    public void createUser() {
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setAddress("浙江省西湖区跑马场路");
        createUserRequest.setAlias("flyBird");
        createUserRequest.setDepartment(Collections.singletonList(1));
        createUserRequest.setEmail("1325922028@qq.com");
        createUserRequest.setEnable(1);
        createUserRequest.setExternalPosition("UI视觉设计师");
        createUserRequest.setGender("1");
        createUserRequest.setMobile("15267897898");
        createUserRequest.setName("帅萌熊");
        createUserRequest.setUserId("1325922028");
        createUserRequest.setPosition("UI视觉设计师");
        weChatManager.addressBookService().createUser(createUserRequest, "address-book");
    }

    @Test
    public void getUser() {
        weChatManager.addressBookService().getUser("1325922028", "address-book");
    }

    @Test
    public void updateUser() {
        UpdateUserRequest request = new UpdateUserRequest();
        request.setUserId("1325922028");
        request.setAddress("浙江省西湖区跑体育场路");
        weChatManager.addressBookService().updateUser(request, "address-book");
    }

    @Test
    public void deleteUser() {
        weChatManager.addressBookService().deleteUser("1325922028", "address-book");
    }

    @Test
    public void batchDeleteUser() {
        BatchDeleteUserRequest request = new BatchDeleteUserRequest();
        request.setUserIdList(Collections.singletonList("PengRongChao"));
        weChatManager.addressBookService().batchDeleteUser(request, "address-book");
    }

    @Test
    public void getDepartmentUser() {
        List<WeChatUser> weChatUsers = weChatManager.addressBookService().getDepartmentUser(1531, true, "address-book");
        logger.info("查到的人数:{}", weChatUsers.size());
    }

    @Test
    public void getDepartmentUserDetail() {
        List<WeChatUser> weChatUsers = weChatManager.addressBookService().getDepartmentUserDetail(1531, true, "address-book");
        logger.info("查到的人数:{}", weChatUsers.size());
    }

    @Test
    public void convertToOpenId() {
        String openId = weChatManager.addressBookService().convertToOpenId("SiGuangMeng", "address-book");
        logger.info("openid:{}", openId);
    }

    @Test
    public void convertToUserId() {
        String userId = weChatManager.addressBookService().convertToUserId("ojkeO5lREx4fVAXcYEG3BDfk9LqA", "address-book");
        logger.info("userId:{}", userId);
    }

    @Test
    public void authSuccess() {
        weChatManager.addressBookService().authSuccess("SiGuangMeng", "address-book");
    }

    @Test
    public void invite() {
        InviteUserRequest request = new InviteUserRequest();
        request.setUser(Collections.singletonList("PengRongChao"));
        weChatManager.addressBookService().invite(request, "address-book");
    }

    @Test
    public void createDepartment() {
        DepartmentRequest request = new DepartmentRequest();
        request.setName("广州研发中心");
        request.setParentId(1);
        weChatManager.addressBookService().createDepartment(request, "address-book");
    }

    @Test
    public void updateDepartment() {
        DepartmentRequest request = new DepartmentRequest();
        request.setName("深圳研发中心");
        request.setId(3542);
        weChatManager.addressBookService().updateDepartment(request, "address-book");
    }

    @Test
    public void deleteDepartment() {
        weChatManager.addressBookService().deleteDepartment(3542, "address-book");
    }

    @Test
    public void departmentList() {
        weChatManager.addressBookService().departmentList(null, "address-book");
    }

    @Test
    public void createTag() {
        TagRequest tagRequest = new TagRequest();
        tagRequest.setTagName("深圳研发中心");
        weChatManager.addressBookService().createTag(tagRequest, "address-book");
    }

    @Test
    public void updateTag() {
        weChatManager.addressBookService().updateTagName(2, "深圳研发中心-1","address-book");
    }

    @Test
    public void deleteTag() {
        weChatManager.addressBookService().deleteTag(2,"address-book");
    }

    @Test
    public void addTagUsers() {
        TagUserRequest request = new TagUserRequest();
        request.setTagId(1);
        request.setUserList(Collections.singletonList("SiGuangMeng"));
        weChatManager.addressBookService().addTagUsers(request,"address-book");
    }

    @Test
    public void getTagUsers() {
        QueryTagUserResponse response = weChatManager.addressBookService().getTagUser(1,"address-book");
        logger.info("人数：{}，部门数：{}",response.getUserList() == null ? 0 :response.getUserList().size(),response.getPartyList() == null ? 0 :response.getPartyList().size());
    }

    @Test
    public void getTagList() {
        List<Tag> tags = weChatManager.addressBookService().getTagList("address-book");
        logger.info("标签总数：{}",tags.size());
    }

    @Test
    public void asyncBatchUpdateUser() {
        WeChatUser weChatUser = new WeChatUser();
        weChatUser.setAddress("浙江省西湖区跑马场路");
        weChatUser.setAlias("flyBird");
        weChatUser.setDepartment(Collections.singletonList(1));
        weChatUser.setEmail("1325922038@qq.com");
        weChatUser.setEnable(1);
        weChatUser.setExternalPosition("UI视觉设计师");
        weChatUser.setGender("1");
        weChatUser.setMobile("15267897894");
        weChatUser.setName("帅哒哒");
        weChatUser.setUserId("13259220281");
        weChatUser.setPosition("UI视觉设计师");
        String jobId = weChatManager.addressBookService().asyncBatchUpdateUser(Collections.singletonList(weChatUser),false,"address-book");
        logger.info("jobId：{}",jobId);
    }

    @Test
    public void fullCoverUser() {
        WeChatUser weChatUser = new WeChatUser();
        weChatUser.setAddress("浙江省西湖区跑马场路");
        weChatUser.setAlias("flyBird");
        weChatUser.setDepartment(Collections.singletonList(1));
        weChatUser.setEmail("1325922038@qq.com");
        weChatUser.setEnable(1);
        weChatUser.setExternalPosition("UI视觉设计师");
        weChatUser.setGender("1");
        weChatUser.setMobile("15267897894");
        weChatUser.setName("帅哒哒");
        weChatUser.setUserId("13259220281");
        weChatUser.setPosition("UI视觉设计师");
        String jobId = weChatManager.addressBookService().fullCoverUser(Collections.singletonList(weChatUser),false,"address-book");
        logger.info("jobId：{}",jobId);
    }

    @Test
    public void  jobResult(){
        AsyncJobResultResponse resultResponse = weChatManager.addressBookService().jobResult("3_1554687941_74556","address-book");
        logger.info("job执行结果：{}",resultResponse);

        AsyncJobResultResponse resultResponse2 = weChatManager.addressBookService().jobResult("2_1554689484_959292","address-book");
        logger.info("job执行结果：{}",resultResponse2);
    }

}
