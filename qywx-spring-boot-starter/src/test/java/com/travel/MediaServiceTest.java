package com.travel;

import com.github.shuaidd.service.MediaService;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.File;
import java.util.Objects;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2019-04-06 16:47
 **/
public class MediaServiceTest extends BaseTest {

    @Test
    public void upload() {
        String mediaId = weChatManager.mediaService().uploadMaterial(new File("/Users/shuaidongdong/Downloads/record.png"), MediaType.IMAGE_PNG, MediaService.IMAGE, "address-book");
        logger.info("media id:{}", mediaId);
    }

    @Test
    public void uploadIMg() {
        String url =  weChatManager.mediaService().uploadImage(new File("/Users/shuaidongdong/Downloads/日报.png"), MediaType.IMAGE_PNG, "address-book");
        logger.info("image url:{}", url);
    }

    @Test
    public void download() {
        ResponseEntity<byte[]> responseEntity =   weChatManager.mediaService().download("3g3C7kuD_ptJVDWDef6FWpgUDh-dAWAGZnhWgr-qudJw", "address-book");
        logger.info("文件大小:{}", Objects.requireNonNull(responseEntity.getBody()).length);
    }
}
