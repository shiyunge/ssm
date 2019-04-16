package com.fable.common.util;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Base64;

/**
 * 文件工具类
 *
 * @author afeey
 */
public class FileUtils extends org.apache.commons.io.FileUtils {
    private static Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 转换分隔符为系统分隔符
     *
     * @param path 路径
     * @return 转换后字符串
     */
    public static String toSysSeparator(String path) {
        return path.replace("/", File.separator).replace("\\", File.separator);
    }

    /**
     * 创建目录
     *
     * @param dirName 目录名称（物理路径）
     */
    public static void mkdir(String dirName) throws IOException {
        forceMkdir(new File(dirName));
    }

    /**
     * 删除文件
     *
     * @param fileName 文件名（物理路径）
     * @throws IOException IO异常
     */
    public static void delete(String fileName) throws IOException {
        if (exist(fileName)) {
            forceDelete(new File(fileName));
        }
    }

    /**
     * 文件是否存在
     *
     * @param fileName 文件名（物理路径）
     * @return 是否存在
     */
    public static boolean exist(String fileName) {
        return new File(fileName).exists();
    }

    public static String getMd5(String filePath) throws FileNotFoundException {
        String md5 = null;
        File file = new File(filePath);
        FileInputStream in = new FileInputStream(file);

        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md.digest());
            md5 = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return md5;
    }

    /**
     * 下载网络图片到服务器
     *
     * @param fileUrl  http路径
     * @param filePath 文件物理路径
     */
    public static void saveHttpFile(String fileUrl, String filePath) {
        InputStream is = null;
        OutputStream os = null;
        try {
            // 创建目录
            String dir = FilenameUtils.getFullPathNoEndSeparator(filePath);
            org.apache.commons.io.FileUtils.forceMkdir(new File(dir));

            URL url = new URL(fileUrl); // 构造URL
            URLConnection con = url.openConnection();  // 打开连接
            con.setConnectTimeout(5 * 1000); //设置请求超时为5s
            is = con.getInputStream();  // 输入流
            byte[] bs = new byte[1024];  // 1K的数据缓冲
            int len;   // 读取到的数据长度
            // 开始读取
            os = new FileOutputStream(filePath);
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
        } catch (UnknownHostException exception) {
            exception.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // 完毕，关闭所有链接
            if (os != null) {
                try {
                    os.close();
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 文件转化成base64字符串
     *
     * @param filePath 文件路径
     * @return base64编码字符串
     */
    public static String getBase64(String filePath) {
        // 将文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in;
        byte[] data = null;
        // 读取字节数组
        try {
            in = new FileInputStream(filePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        String base64 = Base64.getEncoder().encodeToString(data);
        return base64.replaceAll("[\\s*\t\n\r]", "");
    }

    /**
     * base64字符串转化成文件
     *
     * @param base64Str base64字符串
     * @param filePath  文件生成路径
     * @return 是否转换成功
     */
    public static boolean base64ToFile(String base64Str, String filePath) {
        // 图像数据为空
        if (base64Str == null)
            return false;

        try {
            mkdir(FilenameUtils.getFullPathNoEndSeparator(filePath));

            // Base64解码
            byte[] b = Base64.getDecoder().decode(base64Str);
            for (int i = 0; i < b.length; ++i) {
                // 调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            // 生成图片
            OutputStream out = new FileOutputStream(filePath);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
