package com.controller;


import com.file.FastDFSFile;
import com.util.FastDFSUtils;
import entity.Result;
import entity.StatusCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileUploadController {

    @PostMapping("/upload")
    public Result uploadFile(@RequestParam(value = "file") MultipartFile file) {
        try {
            //判断文件是否存在
            if (file == null) {
                throw new RuntimeException("文件不存在");
            }
            //获取文件的完整名称
            String originalFilename = file.getOriginalFilename();
            if (StringUtils.isEmpty(originalFilename)) {
                throw new RuntimeException("文件不存在");
            }

            //获取文件的扩展名称  abc.jpg   jpg

            //获取文件内容
//            byte[] content = file.getBytes();

            //创建文件上传的封装实体类
            FastDFSFile fastDFSFile = new FastDFSFile(originalFilename,
                    org.springframework.util.StringUtils.getFilenameExtension(file.getOriginalFilename()));

            //基于工具类进行文件上传,并接受返回参数  String[]
            String[] upload = FastDFSUtils.upload(fastDFSFile);
//            String groupName = upload[1];
          String fileName = upload[0];
//            System.out.println(groupName);
            System.out.println(fileName);
            System.out.println("------------------");
            System.out.println("获取文件信息");
//            FileInfo fileInfo = FastDFSUtils.getFileInfo(groupName, fileName);
//            System.out.println(fileInfo.getSourceIpAddr());
//            System.out.println(fileInfo.getFileSize());
//            System.out.println(fileInfo.getCreateTimestamp());
//            System.out.println(fileInfo.getCrc32());
//            System.out.println("----------------------");
//            System.out.println("获取Storage信息");
//            StorageServer storage = FastDFSUtils.getStorage();
//            System.out.println(storage.getStorePathIndex());
//            System.out.println("-----------------");
//            System.out.println("获取Storage的IP和端口信息");
//            ServerInfo[] storageInfo = FastDFSUtils.getStorageInfo(groupName, fileName);
//            for (ServerInfo serverInfo : storageInfo) {
//                System.out.println(serverInfo.getIpAddr());
//                System.out.println(serverInfo.getPort());
//            }
//            System.out.println("--------------------");
//            System.out.println("获取Tracker信息");
//            String trackerInfo = FastDFSUtils.getTrackerInfo();
//            System.out.println(trackerInfo);

            //封装返回结果
//            String url = FastDFSUtils.getTrackerUrl()+uploadResult[0]+"/"+uploadResult[1];
//            return new Result(true,StatusCode.OK,"文件上传成功");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return new Result(false, StatusCode.ERROR,"文件上传失败");
//    }
        }catch (Exception e){
            e.printStackTrace();
        }
        return new Result<>(true, StatusCode.OK, "文件上传成功", "---");

    }
}
