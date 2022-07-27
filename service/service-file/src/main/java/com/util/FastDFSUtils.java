package com.util;

import com.file.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lxy
 * 实现FastFDS文件管理
 * 文件上传
 * 文件删除
 * 文件下载
 * 文件信息获取
 * Storage信息获取
 * Tracker信息获取
 */
public class FastDFSUtils {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FastDFSUtils.class);

    private static StorageClient storageClient;
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    /***
     * 初始化加载FastDFS的TrackerServer配置
     */
    static {
        try {
            ClassPathResource filePath = new ClassPathResource("fdfs_client.conf");
            ClientGlobal.init(filePath.getClassLoader().getResource("fdfs_client.conf").toURI().getPath());
            StorageServer storageServer = null;
            //创建一个Tracker的客户端对象
            trackerClient = new TrackerClient();
            //通过TrackerClient访问TrackerServer服务，获取连接对象
            trackerServer = trackerClient.getConnection();
            //通过TrackerServer的连接信息去获取Storage的连接信息，存储进StorageClient对象中
            storageClient = new StorageClient(trackerServer, storageServer);
        } catch (Exception e) {
            e.printStackTrace();
         }
    }

    /***
     * 文件上传
     * @param file
     * @return 1.文件的组名  2.文件的路径信息
     */
    public static String[] upload(FastDFSFile file) throws MyException, IOException {
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());

//接收返回数据
        String[] uploadResults = null;
        try {
//创建StorageClient客户端对象
            storageClient = getTrackerClient();
 uploadResults = storageClient.upload_file(file.getName(), file.getExt(), meta_list);
 } catch (Exception e) {
 logger.error("Exception when uploadind the file:" + file.getName(), e);
 }
 if (uploadResults == null && storageClient!=null) {
 logger.error("upload file fail, error code:" + storageClient.getErrorCode());
 }
 return uploadResults;
    }

    /***
     * 获取文件信息
     * @param groupName:组名
     * @param remoteFileName：文件存储完整名
     * @return
     */
    public static FileInfo getFile(String groupName, String remoteFileName) {
        try {
            StorageClient storageClient = getTrackerClient();
            return storageClient.get_file_info(groupName, remoteFileName);
        } catch (Exception e) {
        }
        return null;
    }

    /***
     * 文件下载
     * @param groupName
     * @param remoteFileName
     * @return
     */
    public static InputStream downFile(String groupName, String remoteFileName) {
        try {
            //创建StorageClient
            StorageClient storageClient = getTrackerClient();

            //下载文件
            byte[] fileByte = storageClient.download_file(groupName, remoteFileName);
            InputStream ins = new ByteArrayInputStream(fileByte);
            return ins;
        } catch (Exception e) {
        }
        return null;
    }

    /***
     * 文件删除
     * @param groupName
     * @param remoteFileName
     * @throws Exception
     */
    public static void deleteFile(String groupName, String remoteFileName)
            throws Exception {
        //创建StorageClient
        StorageClient storageClient = getTrackerClient();

        //删除文件
        int i = storageClient.delete_file(groupName, remoteFileName);
    }

    /***
     * 获取Storage组
     * @param
     * @return
     * @throws IOException
     */
    public static StorageServer getStoreStorages()
            throws IOException {
        //创建TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //获取TrackerServer
        TrackerServer trackerServer = trackerClient.getConnection();
        //获取Storage组
        trackerClient.getStoreStorage(trackerServer);
        return trackerClient.getStoreStorage(trackerServer);
    }

    /***
     * 获取Storage信息,IP和端口
     * @param groupName
     * @param remoteFileName
     * @return
     * @throws IOException
     */
    public static ServerInfo[] getFetchStorages(String groupName,
                                                String remoteFileName) throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerClient.getFetchStorages(trackerServer, groupName, remoteFileName);
    }

    /***
     * 获取Tracker服务地址
     * @return
     * @throws IOException
     */
    public static String getTrackerUrl() throws IOException {
        return "http://"+getTrackerServer().getInetSocketAddress().getHostString()+":"+ClientGlobal.getG_tracker_http_port()+"/";
    }

    /***
     * 获取Storage客户端
     * @return
     * @throws IOException
     */
    private static StorageClient getTrackerClient() throws IOException {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return  storageClient;
    }

    /***
     * 获取Tracker
     * @return
     * @throws IOException
     */
    private static TrackerServer getTrackerServer() throws IOException {
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        return  trackerServer;
    }

}
