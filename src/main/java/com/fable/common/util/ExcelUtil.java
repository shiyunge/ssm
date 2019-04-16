package com.fable.common.util;


import com.fable.common.exception.BusinessException;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Scott on 2017/4/9.
 */
public class ExcelUtil {

    private static Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * 读取excle文件
     *
     * @param is         文件流
     * @param cellLenght 需要读取多少列
     * @param startIndex 开始读取的坐标
     * @return
     * @throws IOException
     */
    public static List<Map<String, Object>> readXls(InputStream is, int cellLenght, int startIndex) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        Map<String, Object> dataRow = null;
        List<Map<String, Object>> resultList = new ArrayList<>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = startIndex; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                dataRow = new HashMap<>();

                for (int i = 0; i < cellLenght; i++) {
                    HSSFCell xh = hssfRow.getCell(i);
                    if (xh == null) {
                        continue;
                    }
                    dataRow.put(Integer.valueOf(i).toString(), formatCell3(xh));
                }

                resultList.add(dataRow);
            }
        }
        return resultList;
    }

    /**
     * 处理单元格格式的第三种方法:比较全面
     *
     * @param cell
     * @return
     */
    public static String formatCell3(HSSFCell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_NUMERIC:

                //日期格式的处理
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue())).toString();
                }

                return String.valueOf(cell.getNumericCellValue());

            //字符串
            case HSSFCell.CELL_TYPE_STRING:
                return StringUtils.replace(cell.getStringCellValue(), " ", "");

            // 公式
            case HSSFCell.CELL_TYPE_FORMULA:
                return cell.getCellFormula();

            // 空白
            case HSSFCell.CELL_TYPE_BLANK:
                return "";

            // 布尔取值
            case HSSFCell.CELL_TYPE_BOOLEAN:
                return cell.getBooleanCellValue() + "";

            //错误类型
            case HSSFCell.CELL_TYPE_ERROR:
                return cell.getErrorCellValue() + "";
        }

        return "";
    }

    /**
     * 将数据以Excel格式输出到页面
     *
     * @param titles      表头
     * @param dataAryList 表内容
     * @author nimj 2015/11/18
     */
    public static void exportExcel(String[] titles, List<Object[]> dataAryList,
                                   String fileName, HttpServletResponse response) throws Exception {
        if (ArrayUtils.isEmpty(titles) || dataAryList == null || StringUtils.isEmpty(fileName) || response == null) {
            throw new BusinessException("00000014");
        }
        OutputStream output = null;
        // 创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet();
        // 在sheet中添加表头（第0行）
        HSSFRow row = sheet.createRow(0);
        // 创建居中单元格样式
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 设置表头
        HSSFCell cell = null;
        for (int i = 0, cols = titles.length; i < cols; i++) {
            cell = row.createCell(i);
            cell.setCellValue(titles[i]);
            cell.setCellStyle(style);
        }

        // 写入实体数据
        Object[] dataAry = null;
        Object data = null;
        for (int i = 0, size = dataAryList.size(); i < size; i++) {
            row = sheet.createRow(i + 1);
            dataAry = dataAryList.get(i);
            for (int j = 0, cols = dataAry.length; j < cols; j++) {
                data = dataAry[j];
                if (data instanceof Date) {
                    row.createCell(j).setCellValue(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data));
                } else {
                    row.createCell(j).setCellValue(String.valueOf(data));
                }
            }
        }
        for (int i = 0, cols = titles.length; i < cols; i++) {
            sheet.autoSizeColumn(i);// 列宽度自适应
        }
        // 将文件输出到页面
        response.setContentType("octets/stream");
        try {
            response.addHeader("Content-Disposition", "attachment;filename="
                    + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
            output = new BufferedOutputStream(response.getOutputStream());
            wb.write(output);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw e;
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    logger.warn(e.getMessage(), e);
                }
            }
        }

    }

    /**
     * 设置excel第一行标题行内容和格式
     *
     * @param sheet   页
     * @param style   格式
     * @param height  行高
     * @param content 内容数组
     */
    public static void setFirstRow(HSSFSheet sheet, HSSFCellStyle style, int height, String[] content) {
        Row header = sheet.createRow(0);
        header.setHeightInPoints(height);
        for (int i = 0; i < content.length; i++) {
            Cell cell = header.createCell(i);
            cell.setCellValue(content[i]);
            cell.setCellStyle(style);
        }
    }
}
