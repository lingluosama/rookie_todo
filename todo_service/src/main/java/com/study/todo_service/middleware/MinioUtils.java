package com.study.todo_service.middleware;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MinioUtils {
    private static final String endpoint="http://localhost:9000";
    private static final String accessKey="rookie_todo";
    private static final String secretKey="1145141918";
    private final MinioClient minioClient=MinioClient.builder().endpoint(endpoint)
            .credentials(accessKey,secretKey).build();
    public  String upload_icon(MultipartFile file,String user_id){
        try {
            PutObjectArgs objectArgs=PutObjectArgs.builder().bucket("icon").object(user_id)
                    .stream(file.getInputStream(),file.getSize(),-1).contentType("image/png").build();
            minioClient.putObject(objectArgs);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return "http://lochost:9000/icon/"+user_id;
    }
}
