package com.fable.common.util;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FileServicePathUtils {

    private static final Logger logger = LoggerFactory.getLogger(FileServicePathUtils.class);

    @Value("${file.save.dir}")
    private String fileSaveDir;             //文件保存目录（物理路径）
    @Value("${file.browse.url.prefix}")
    private String fileBrowseUrlPrefix;     //文件HTTP访问地址前缀

    /**
     * 获取文件访问地址URL前缀
     * 示例："uploadfile" 、 "uploadfile/files"
     *
     * @return 上下文目录
     */
    public String getFileBrowseUrlPrefix() {
        logger.debug("file browse url prefix: {}", fileBrowseUrlPrefix);
        return fileBrowseUrlPrefix;
    }

    /**
     * 获取文件访问URL
     * URL格式：访问前缀/ + temp/+ 目录/ + fileID/ + fileID + 扩展名
     * 示例："uploadfile/temp/document/1731a93488614c7e96b2383dc3922787/1731a93488614c7e96b2383dc3922787.docx"
     *
     * @param fileId   文件ID
     * @param fileName 文件名称
     * @param dir      目录
     * @return 文件访问URL
     */
    public String getFileBrowseUrl(String fileId, String fileName, String dir) {
        String url = fileBrowseUrlPrefix + "/temp" + "/" + dir + "/" + fileId + "/" + fileId + "." + FilenameUtils.getExtension(fileName).toLowerCase();
        logger.debug("file browse url: {}", url);
        return url;
    }

    /**
     * 获取文件PDF缓存访问URL（非PDF文件使用此方法）
     *
     * @param fileId 文件ID
     * @return 访问URL
     */
    public String getPdfBrowseUrl(String fileId) {
        return fileBrowseUrlPrefix + "/pdf/" + fileId + ".pdf";
    }

    /**
     * 获取上传根目录
     *
     * @return 目录（物理目录）
     */
    public String getFileSaveDir() {
        logger.debug("file save dir: {}", fileSaveDir);
        return fileSaveDir;
    }

    /**
     * 获取PDF文件物理目录
     *
     * @return 物理目录
     */
    public String getPdfSaveDir() {
        String dir = fileSaveDir + File.separator + "pdf";
        logger.debug("pdf save dir: {}", dir);
        return dir;
    }

    /**
     * 获取Swf文件保存目录（物理路径）
     *
     * @return 物理目录
     */
    public String getSwfSaveDir() {
        String dir = fileSaveDir + File.separator + "swf";
        logger.debug("swf save dir: {}", dir);
        return dir;
    }

    /**
     * 获取文件保存路径（物理路径）
     *
     * @param fileUrl 文件访问URL
     * @return 物理路径
     */
    public String getFileSavePath(String fileUrl) {
        String path = fileSaveDir + FileUtils.toSysSeparator(fileUrl);                           //获得物理路径
        logger.debug("file save path: {}", path);
        return path;
    }

    /**
     * 获取PDF文件保存路径（物理路径）
     *
     * @param fileId 文件ID
     * @return 物理路径
     */
    public String getPdfSavePath(String fileId) {
        String path = getPdfSaveDir() + File.separator + fileId + ".pdf";
        logger.debug("swf save path: {}", path);
        return path;
    }

    /**
     * 获取SWF文件保存路径（物理路径）
     *
     * @param fileId 文件ID
     * @param page   页码（完整文件设置null或""）
     * @return 物理路径
     */
    public String getSwfSavePath(String fileId, String page) {
        page = StringUtils.isEmpty(page) ? "" : "_" + page;
        String path = getSwfSaveDir() + File.separator + fileId + File.separator + fileId + page + ".swf";
        logger.debug("swf save path: {}", path);
        return path;
    }

}
