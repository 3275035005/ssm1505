package com.cinema.controller;

import com.cinema.service.FileService;
import com.cinema.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 图片上传和下载入口
 */
@RestController
@RequestMapping("/files")
public class FileController {

    private final static String userFilePath = "G:\\成品项目\\2-SSM\\在线影院网址系统\\项目源码\\service\\files";

    private final static String baseUrl = "http://localhost:8081/files";

    @Autowired
    private FileService fileService;
    /**
     * 图片上传
     * @param
     * @return
     */
    @PostMapping("/file")
    public R uploadFile(HttpServletRequest request, MultipartFile file) {
        String uuid="file"+ System.currentTimeMillis();
        String fileName= uuid+ file.getOriginalFilename();
        try {
            if (fileService.uploadFile(file,fileName)) {
                return R.ok().put("row",baseUrl+"/download?fileName="+fileName);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return R.error();
    }

    /**
     * 文件下载
     * @param imageName
     * @param response
     * @throws IOException
     */
    @GetMapping("/download")
    public void getImage(@RequestParam("fileName") String imageName,
                         HttpServletResponse response) throws IOException {
        File fileDir = new File(userFilePath);
        File image=new File(fileDir.getAbsolutePath() +"/"+imageName);
        if (image.exists()){
            FileInputStream fileInputStream=new FileInputStream(image);
            byte[] bytes=new byte[fileInputStream.available()];
            if (fileInputStream.read(bytes)>0){
                OutputStream outputStream=response.getOutputStream();
                outputStream.write(bytes);
                outputStream.close();
            }
            fileInputStream.close();
        }
    }

    /**
     * 视频上传
     * @param
     * @return
     */
    @PostMapping("/fileVideo")
    public R fileVideo(HttpServletRequest request, MultipartFile file) {
        String uuid="file"+ System.currentTimeMillis();
        String fileName= uuid+ file.getOriginalFilename();
        try {
            if (fileService.uploadFile(file,fileName)) {
                return R.ok().put("row",baseUrl+"/downloadVideo?fileName="+fileName);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return R.error();
    }
    /**
     * 視頻下载
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/downloadVideo", method = RequestMethod.GET)
    public void downloadVideo(@RequestParam("fileName") String imageName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws IOException {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        String filePath = userFilePath+"/"+imageName;
        System.out.println(filePath);
        try {
            File file = new File(filePath);
            int fSize = Integer.parseInt(String.valueOf(file.length()));
            httpServletResponse.setCharacterEncoding("utf-8");
            httpServletResponse.setContentType("application/x-download");
            httpServletResponse.setHeader("Accept-Ranges", "bytes");
            httpServletResponse.setHeader("Content-Length", String.valueOf(fSize));
            //对下载的文件或者播放的视频等取个名字
            httpServletResponse.setHeader("Content-Disposition", "attachment;fileName=test.avi");
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            long position = 0;
            if (null != httpServletRequest.getHeader("Range")) {
                // 断点续传
                httpServletResponse.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                try {
                    position = Long.parseLong(httpServletRequest.getHeader("Range").replaceAll("bytes=", "").replaceAll("-", ""));
                } catch (NumberFormatException e) {
                    position = 0;
                }
            }
            bufferedOutputStream = new BufferedOutputStream(httpServletResponse.getOutputStream());
            // Content-Range的格式：bytes POSITION - ( FILE_SIZE - 1)/FILE_SIZE
            httpServletResponse.setHeader("Content-Range", "bytes " + position + "-" + (fSize - 1) + "/" + fSize);
            bufferedInputStream.skip(position);
            byte[] buffer = new byte[1024 * 10];
            int length = 0;
            while ((length = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
                bufferedOutputStream.write(buffer, 0, length);
                //TimeUnit.MILLISECONDS.sleep(30);
            }
        } catch (Exception e) {
        } finally {
            try {
                if (null != bufferedOutputStream)
                    bufferedOutputStream.flush();
                if (null != bufferedInputStream)
                    bufferedInputStream.close();
                if (null != bufferedOutputStream)
                    bufferedOutputStream.close();
            } catch (IOException e) {
            }
        }
    }

}
