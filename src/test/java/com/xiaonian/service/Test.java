package com.xiaonian.service;

import java.io.*;
import java.sql.DriverManager;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.xiaonian.baseTest.SpringTestCase;
import com.xiaonian.core.entity.Bank;
import com.xiaonian.core.service.IRoleService;
import com.xiaonian.core.service.impl.RoleService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class Test extends SpringTestCase
{
    @Autowired
    IRoleService roleService;
    @org.junit.Test
	public  void test() throws IOException, ParseException
	{

//		Document doc = Jsoup.connect("http://www.xmut.edu.cn/mtlg/").get();
//		Elements bodys = doc.getElementsByClass("container-list");
//		Elements contents  = bodys.select("li");
//		for (Element element : contents)
//		{
//			String text = element.select("a").text(); // "An example link"//取得字符串中的文本
//			String linkHref = element.select("a").attr("href"); // "http://example.com/"//取得链接地址
//			System.out.println(text);
//			System.out.println(linkHref);
//			String spanText = element.select("span").text().trim();
//			System.out.println(spanText);
//		}
		
		
		
		
		String driver = "com.mysql.jdbc.Driver"; 
//        String url = "jdbc:mysql://120.76.219.219:3306/sail"; 
        String url = "jdbc:mysql://127.0.0.1:3306/my_maven_web?useUnicode=true&allowMultiQueries=true&autoReconnect=true";
        
        String user = "root";
        String password = "123456";
        try {
            Class.forName(driver); 
            Connection conn = (Connection) DriverManager.getConnection(url, user, password); 
            Statement stmt = (Statement) conn.createStatement(); 
//            stmt.executeUpdate("insert into test_aaa (content) values ('测试MySQL编码')"); 
//            ResultSet rs = stmt.executeQuery("select * from my_test;"); 
           // boolean rs = stmt.execute("insert into test_aaa(content) values('😀你好a');");
//            ResultSet rs = stmt.executeQuery("select * from my_test;"); 
           // System.out.println(rs);
            
            stmt.close(); 
            conn.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        }

        List<Bank> list = new ArrayList<>();
        String laststr="";
        File file = new File("C:/Users/Administrator/Downloads/wechat-banks-master/data/banks.json");
        BufferedReader reader = null;

        try{
            FileInputStream in = new FileInputStream(file);
            reader=new BufferedReader(new InputStreamReader(in,"UTF-8"));// 读取文件
            String tempString=null;
            while((tempString=reader.readLine())!=null){
                laststr=laststr+tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader!=null){
                try{
                    reader.close();
                }catch(IOException el){
                }
            }
        }

        JSONArray js = new JSONArray(laststr);

        for(int i = 0; i < js.length(); i++ ){
            JSONObject item = js.getJSONObject(i);
            Bank bank = new Bank();
            bank.setBankId(item.getInt("bankId"));
            bank.setCode(item.getString("code"));
            bank.setName(item.getString("subBranchName"));
            bank.setProvinceId(item.getInt("provinceId"));
            bank.setCityId(item.getInt("cityId"));
            // System.out.println(bank.toString());
            list.add(bank);
        }

        List newList = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            newList.add(list.get(i));
            if(i % 100 == 0){
                roleService.insertList(newList);
                newList.clear();
            }
        }
        roleService.insertList(newList);
        //System.out.println(list);
       // roleService.insertList(list);
//		String auctionLogStr = "{'auctionId': 27,'createTime': 1467598099000,'price': 220,'userName': '哥伦布大仙','userId': 55}";
//		
//		JSONObject aucJson = new JSONObject(auctionLogStr);
//		AuctionLog tempLog = new AuctionLog();
//		tempLog.setAuctionId(aucJson.getInt("auctionId"));
//		tempLog.setCreateTime(new Date(aucJson.getLong("createTime")));
//		tempLog.setPrice(aucJson.getInt("price"));
//		tempLog.setUserId(aucJson.getInt("userId"));
//		tempLog.setUserName(aucJson.getString("userName"));
//		tempLog.setStatus(AUCTIONLOG_STATUS.OUT);
		
//		Map<String, String> emApnsExt = new HashMap<>();
//		emApnsExt.put("em_push_title", "恭喜，您通过审核");
//		emApnsExt.put("position", "1");
//		
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put("em_push_title", "恭喜，您通过审核");
//		jsonObject.put("position", "1");
//		System.out.println(emApnsExt.toString());
//		System.out.println(jsonObject.toString());
//		 System.out.println(A);
//		System.out.println('O'-1);
//		6500001
//		9099999
//		int existCode = 6500005;
//		String subStr = 6500005 + "";
//		System.out.println(((char)(existCode / 100000)) + subStr.substring(2, subStr.length()));
		
//		UserInfo userInfo = new UserInfo();
//		userInfo.setId(1);
//		List<UserInfo> userInfos = new ArrayList<>();
//		userInfos.add(userInfo);
//		
//		boolean flag = userInfos.contains(userInfo);
//		System.out.println(flag);
		
//		System.out.println(new Date(1471845927000L));
//		System.out.println(new Date(1471770663000L));
//		System.out.println(new Date(1471674579000L));
//		System.out.println(new Date(1471593500000L));
//		System.out.println(new Date(1471521561000L));
//		System.out.println(new Date(1471442730000L));
//		System.out.println(new Date(1471412642000L));
//		System.out.println(new Date(1471357617000L));
//		System.out.println(new Date(1471332213000L));
//		System.out.println(new Date(1471249040000L));
		
		
//		try
//		{
//			String name = new String("æå®¤".getBytes("iso-8859-1"), "utf-8");
//			System.out.println(name);
//			
//		}
//		catch (UnsupportedEncodingException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		Integer a = 1;
//		Integer b = null;
//		System.out.println(ValidatorUtil.isNotNull(b) && a.intValue() != b);
		
		
//		int element1Count = 53;
//		int element2Count = 3;
//		int element3Count = 216;
//		
//		{
//			int userCount = 1081;
//			if(userCount < element1Count * element2Count * element3Count)
//			{
//				int firstElementIndex =  userCount % element3Count == 0?(userCount/element3Count % element2Count == 0?userCount/element3Count/element2Count:1+userCount/element3Count/element2Count) : userCount/(element2Count * element3Count) + 1;
//				int tempSecond = userCount - (firstElementIndex-1) * element2Count * element3Count;
//				int secondElementIndex = tempSecond % element3Count == 0? tempSecond/element3Count : tempSecond/element3Count+1;
//				int thirdElementIndex = userCount - ((firstElementIndex-1) * element2Count + secondElementIndex - 1) * element3Count;
//				
//				System.out.println("userCount="+userCount);
//				System.out.println("firstElementIndex="+firstElementIndex);
//				System.out.println("secondElementIndex="+secondElementIndex);
//				System.out.println("thirdElementIndex="+thirdElementIndex);
//				
//				if(userCount % 216 == 0)
//				{
//					System.out.println("=====================================");
//				}
//			}
//		}
		
//		Timestamp curr = new Timestamp(116,10,16,14,26,50, 0);
//		System.out.println(curr);
//		System.out.println(curr.getTime());
//		Timestamp curr = new Timestamp(1487618146000l);
//		System.out.println(curr);
		
//		String str = UUID.randomUUID().toString();
//		String str = "Fl3NgQ3s9o 8MCD8zah2xPJ6cmiZD#772701#1124.000000#5096.000000";
//		System.out.println(str.length());
//		System.out.println(str);
		
		
//          XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(new File(filePath)));
//          SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(workbook1, 100);
////              Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(filePath)));
//	      Sheet first = sxssfWorkbook.getSheetAt(0);
//	      for (int i = 0; i < 100000; i++) {
//	          Row row = first.createRow(i);
//	          for (int j = 0; j < 11; j++) {
//	              if(i == 0) {
//	                 // 首行
//	                 row.createCell(j).setCellValue("column" + j);
//	             } else {
//	                 // 数据
//	                 if (j == 0) {
//	                     CellUtil.createCell(row, j, String.valueOf(i));
//	                 } else
//	                     CellUtil.createCell(row, j, String.valueOf(Math.random()));
//	             }
//	         }
//	     }
//	     FileOutputStream out = new FileOutputStream("workbook.xlsx");
//	     sxssfWorkbook.write(out);
//	     out.close();
		
		
//		System.out.println(new Date(1483545600000L));
		
		
//		boolean hitFlag = false;
//		String hundredProbability = BusinessUtil.getHundredSignProbability();
//		if(ValidatorUtil.isNotNull(hundredProbability))
//		{
//			if(hundredProbability.split("\\.").length == 2)
//			{
//				String fractionalPartStr = hundredProbability.substring(hundredProbability.indexOf(".")+1);
//				
//				int len =  fractionalPartStr.length();
//				
//				double fractionalPar =  Double.parseDouble(hundredProbability);
//				
//				int hitRange = (int) (fractionalPar * Math.pow(10,len));
//				
//				int sumRange =  (int) (100 * Math.pow(10,len));
//				
//				int focus = new Random().nextInt(sumRange) + 1;
//				
//				if(focus >= 1 && focus <= hitRange)
//				{
//					hitFlag = true;
//				}
//			}
//			else if(hundredProbability.split("\\.").length == 1)
//			{
//				int hitRange = Integer.parseInt(hundredProbability);
//				
//				int sumRange =  100;
//				
//				int focus = new Random().nextInt(sumRange) + 1;
//				
//				if(focus >= 1 && focus <= hitRange)
//				{
//					// 抽中第100签
//					hitFlag = true;
//				}
//			}
//		}
//		System.out.println(hitFlag);
		
//		boolean hitFlag = false;
//		String hundredProbability = "0.5";
//		if(ValidatorUtil.isNotNull(hundredProbability))
//		{
//			if(hundredProbability.split("\\.").length == 2)
//			{
//				String fractionalPartStr = hundredProbability.substring(hundredProbability.indexOf(".")+1);
//				
//				int len =  fractionalPartStr.length();
//				
//				double fractionalPar =  Double.parseDouble(hundredProbability);
//				
//				int hitRange = (int) (fractionalPar * Math.pow(10,len));
//				
//				int sumRange =  (int) (100 * Math.pow(10,len));
//				
//				int focus = new Random().nextInt(sumRange) + 1;
//				
//				if(focus >= 1 && focus <= hitRange)
//				{
//					hitFlag = true;
//				}
//			}
//			else if(hundredProbability.split("\\.").length == 1)
//			{
//				int hitRange = Integer.parseInt(hundredProbability);
//				
//				int sumRange =  100;
//				
//				int focus = new Random().nextInt(sumRange) + 1;
//				
//				if(focus >= 1 && focus <= hitRange)
//				{
//					// 抽中第100签
//					hitFlag = true;
//				}
//			}
//		}
//		System.out.println(hitFlag);
//		System.out.println(DateUtils.getSystemTime().getTime());
		
//		Integer[] i1 = {1,2,3,4,5};
//		Integer[] i2 = {2,3,4,5,6};
//		Integer[] i3 = {1,1,4,4,5};
//		
//		int sum1 = 0;
//		int sum2 = 0;
//		int sum3 = 0;
//		for(int i=0; i< 4; i++)
//		{
//			sum1 = sum1 += Math.pow(i1[i]-i2[i], 2);
//			sum2 = sum2 += Math.pow(i1[i]-i3[i], 2);
//			sum3 = sum3 += Math.pow(i2[i]-i3[i], 2);
//		}
//		System.out.println(sum1);
//		System.out.println(sum2);
//		System.out.println(sum3);
		
//		String s = "[{\"id\": \"2\",\"qType\": \"0\",\"type\": \"1\",\"isMatch\": \"0\",\"options\": [{\"id\": \"1\",\"checked\": 1,\"text\": \"方便与朋友联系，分享乐趣\"},{\"id\": \"2\",\"checked\": 0,\"text\": \"\"},{\"id\": \"-1\",\"checked\": 1,\"text\": \"\"}]},{\"id\": \"3\",\"qType\": \"0\",\"type\": \"2\",\"isMatch\": \"1\",\"options\": [{\"id\": \"1\",\"checked\": 0,\"text\": \"\"},{\"id\": \"2\",\"checked\": 1,\"text\": \"分享新鲜事\"},{\"id\": \"-1\",\"checked\": 0,\"text\": \"\"}]}]";
//		//个人经历json处理
//		JSONArray experience = new JSONArray(s);
//		
//		for(int i=0; i< experience.length(); i++)
//		{
//			JSONObject questionJson = experience.getJSONObject(i);
//			System.out.println(questionJson.get("id"));
//		}
//		
	}
}
