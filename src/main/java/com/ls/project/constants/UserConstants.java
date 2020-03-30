package com.ls.project.constants;

public interface UserConstants {

    /** 加密次数 */
    int HASH_ITERATIONS = 3;

    /** 加密算法 */
   String ALGORITHM_NAME = "MD5";

   /**  文件存储路径 */
   String UPLOAD_FILE_PATH = "E:/uploadFilePath/userAvatar/";

    /**  文件资源访问路径 */
    String FILE_ACCESS_PATH = "http://localhost:8081/file/avatar/";
}
