package com.travel;

import io.minio.*;
import io.minio.errors.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 描述 minio 文件存储服务
 *
 * @author ddshuai
 * @date 2021-11-01 11:08
 **/

@Service
public class MinioService {

    private final MinioClient minioClient;

    public MinioService() {
        minioClient = MinioClient.builder()
                .endpoint("http://10.10.11.9:9000")
                .credentials("Q3AM3UQ867SPQQA43P2F", "zuf+tfteSlswRu7BJ86wekitnifILbZam1KYY3TG")
                .build();
    }

    public String upload() throws Exception {
        // Make 'asiatrip' bucket if not exist.
        boolean found = minioClient.bucketExists(BucketExistsArgs.builder().bucket("amazon").build());
        if (!found) {
            // Make a new bucket called 'asiatrip'.
            minioClient.makeBucket(MakeBucketArgs.builder().bucket("amazon").build());
        } else {
            System.out.println("Bucket 'amazon' already exists.");
        }

        ObjectWriteResponse response =  minioClient.uploadObject(
                UploadObjectArgs.builder()
                        .bucket("amazon")
                        .object("t_amazon_unit.sql")
                        .filename("/Users/shuaidongdong/Downloads/t_amazon_unit.sql")
                        .build());

        return response.object();
    }

    public GetObjectResponse download() throws IOException, InvalidKeyException, InvalidResponseException, InsufficientDataException, NoSuchAlgorithmException, ServerException, InternalException, XmlParserException, ErrorResponseException {
        GetObjectArgs args = GetObjectArgs.builder().bucket("amazon").object("t_amazon_unit.sql").build();
        return  minioClient.getObject(args);
    }
}
