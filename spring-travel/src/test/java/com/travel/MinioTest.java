package com.travel;

import io.minio.GetObjectResponse;
import io.minio.errors.*;
import org.junit.Test;
import org.springframework.util.FileCopyUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 描述
 *
 * @author ddshuai
 * @date 2021-11-01 12:27
 **/
public class MinioTest {
    private MinioService minioService = new MinioService();
    @Test
    public void upload() {

        try {
           String object = minioService.upload();
            System.out.println(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void download(){
        try {
            GetObjectResponse response = minioService.download();
            FileCopyUtils.copy(response,new FileOutputStream("/Users/shuaidongdong/Downloads/t_amazon_unit_minio.sql"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidResponseException e) {
            e.printStackTrace();
        } catch (InsufficientDataException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (InternalException e) {
            e.printStackTrace();
        } catch (XmlParserException e) {
            e.printStackTrace();
        } catch (ErrorResponseException e) {
            e.printStackTrace();
        }
    }
}
