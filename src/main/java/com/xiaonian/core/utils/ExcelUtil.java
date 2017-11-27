package com.xiaonian.core.utils;

import com.xiaonian.core.vo.VoExport;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * excel 导入导出工具类
 *
 * Created by qqjbest on 2017/10/16.
 */
public class ExcelUtil {

    /**
     * 导出报表
     *
     * @param response
     * @param request
     */
    public static void export(VoExport voExport, HttpServletResponse response, HttpServletRequest request) throws Exception
    {
        OutputStream output=response.getOutputStream();
        response.reset();
        response.setHeader("Content-Disposition","attachment;filename="+new String(voExport.getFileName().getBytes(),"iso-8859-1")+".xls");
        response.setContentType("application/msexcel");
        WritableWorkbook wk=Workbook.createWorkbook(output);
        WritableSheet sheet=wk.createSheet("数据", 0);
        sheet.mergeCells(0,0, voExport.getCloumnCount()-1,0);
        WritableFont titleFont=new WritableFont(WritableFont.createFont("黑体"),12,WritableFont.BOLD,false, UnderlineStyle.NO_UNDERLINE, Colour.LIGHT_BLUE);
        WritableCellFormat titleFormat=new WritableCellFormat();
        titleFormat.setFont(titleFont);
        titleFormat.setAlignment(Alignment.CENTRE);
        titleFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
        titleFormat.setBackground(Colour.GRAY_25);
        titleFormat.setWrap(true);
        Label lab_00=new Label(0,0,voExport.getTopTitle(),titleFormat);
        sheet.addCell(lab_00);
        WritableCellFormat cloumnTitleFormat=new WritableCellFormat();
        cloumnTitleFormat.setFont(new WritableFont(WritableFont.createFont("宋体"),10,WritableFont.BOLD,false));
        cloumnTitleFormat.setAlignment(Alignment.CENTRE);

        for (int i=0;i< voExport.getCloumnCount() ;i++)
        {
            Label titleLabel = new Label(i,1,voExport.getCloumnTitles()[i], cloumnTitleFormat);
            sheet.addCell(titleLabel);
        }
        List<Map<String,Object>> data = voExport.getDatas();
        String[] fieldNames = voExport.getFieldNames();
        for (int i = 0; i < data.size(); i++) {
            Map<String,Object> tempData = data.get(i);
            for (int j = 0; j < fieldNames.length; j++) {
                Object value = tempData.get(fieldNames[j]);
                value = ValidatorUtil.isNotNull(value)?value:"";
                sheet.addCell(new Label(j,i+2,value.toString()));
            }
        }
        wk.write();
        wk.close();
       /* File file=new File("D://"+voExport.getFileName()+".xls");
        WritableWorkbook wwb = Workbook.createWorkbook(file);*/
    }

}
