package com.xiaonian.easemob.server.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * @author qqjbest
 * @since 2016年5月23日 上午11:04:51
 */
public class Main {

	public static void main(String[] args) throws Exception {
//		EasemobRestAPIFactory factory = ClientContext.getInstance().init(ClientContext.INIT_FROM_PROPERTIES).getAPIFactory();
//		
//		IMUserAPI user = (IMUserAPI)factory.newInstance(EasemobRestAPIFactory.USER_CLASS);
//		ChatMessageAPI chat = (ChatMessageAPI)factory.newInstance(EasemobRestAPIFactory.MESSAGE_CLASS);
//		FileAPI file = (FileAPI)factory.newInstance(EasemobRestAPIFactory.FILE_CLASS);
//		SendMessageAPI message = (SendMessageAPI)factory.newInstance(EasemobRestAPIFactory.SEND_MESSAGE_CLASS);
//		ChatGroupAPI chatgroup = (ChatGroupAPI)factory.newInstance(EasemobRestAPIFactory.CHATGROUP_CLASS);
//		ChatRoomAPI chatroom = (ChatRoomAPI)factory.newInstance(EasemobRestAPIFactory.CHATROOM_CLASS);

//        ResponseWrapper fileResponse = (ResponseWrapper) file.uploadFile(new File("E:/我的图片/p_large_QiwF_225a000075d25c41.jpg"));
//        String uuid = ((ObjectNode) fileResponse.getResponseBody()).get("entities").get(0).get("uuid").asText();
//        String shareSecret = ((ObjectNode) fileResponse.getResponseBody()).get("entities").get(0).get("share-secret").asText();
//        InputStream in = (InputStream) ((ResponseWrapper) file.downloadFile(uuid, shareSecret, false)).getResponseBody();
//        FileOutputStream fos = new FileOutputStream("E:/我的图片/p_large_QiwF_225a000075d25c41.jpg");
//        byte[] buffer = new byte[1024];
//        int len1 = 0;
//        while ((len1 = in.read(buffer)) != -1) {
//            fos.write(buffer, 0, len1);
//        }
//        fos.close();

//		AuthTokenBody payload = new AuthTokenBody(ClientContext.getInstance().getClientId(), ClientContext.getInstance().getClientSecret());
//        System.out.println("ClientId:" + payload.getClientId());
//        System.out.println("ClientSecret:" + payload.getClientSecret());
        
		Map<String, String> ext = new HashMap<String, String>();
        ext.put("sd", "sd");
      //发送文本消息
//        MessageBody messageB = new TextMessageBody("users", new String[] {"jiang"}, "ios", ext, "hehehe");
//        ResponseWrapper responseWrapper = (ResponseWrapper) message.sendMessage(messageB);
        
        //发送透传消息ok
//        MessageBody cmdB = new CommandMessageBody(targetType, targets, from, ext, msg);
//        ResponseWrapper responseWrapper = (ResponseWrapper) message.sendMessage(cmdB);
        //创建聊天室ok
//        String[] member = {"jiang"};
//        ChatRoomBody chatRoomBody = new ChatRoomBody("竞拍聊天室", "竞拍聊天", 10000l, "ios", member);
//        chatroom.createChatRoom(chatRoomBody);
        
        //往聊天室发送消息ok
//        MessageBody messageChat = new TextMessageBody("chatrooms", new String[] {"197868566295347644"}, "ios", ext, "1545454");
//      ResponseWrapper responseWrapper = (ResponseWrapper) message.sendMessage(messageChat);
        
       //删除聊天室ok
//        chatroom.deleteChatRoom("197868566295347644");
      
		// Create a IM user
		
//		user.createNewIMUserSingle(userBody);
//		user.createNewIMUserBatch(payload);

		// Create some IM users
//		List<IMUserBody> users = new ArrayList<IMUserBody>();
//		users.add(new IMUserBody("18750937104", "123456", null));
//		IMUserBody imUserBody = new IMUserBody("18750937208", "123456", null);
//		users.add(new IMUserBody("test05", "123456", null));
//		ResponseWrapper object = (ResponseWrapper) user.createNewIMUserBatch(imUserBody);
//		{"action":"post","application":"80331e70-1674-11e6-b0e9-332ce828c858","path":"/users","uri":"https://a1.easemob.com/xiaonian/xiaonian/users","entities":[{"uuid":"349af96a-1c28-11e6-92c4-25755188512f","type":"user","created":1463486968822,"modified":1463486968822,"username":"18750937106","activated":true}],"timestamp":1463486968820,"duration":38,"organization":"xiaonian","applicationName":"xiaonian"}
//		
		// Get a IM user    
//		System.out.println(user.getIMUsersByUserName("User001").toString());
//		
//		// Get a fake user
//		user.getIMUsersByUserName("FakeUser001");
//		
//		// Get 12 users
//		user.getIMUsersBatch(null, null);
		
//        System.out.println(EasemobUtil.createChatRoom("你好呀", "haha"));
        
//        EasemobUtil.sendChatRoomMessage(new String[] {"197889500511207852"}, null, "adsad");
        
//        String query = "chat_type=chat";
////       
//        String curser = "MTQzNjgyOTEyMDpnR2tBQVFNQWdHa0FCZ0ZVdkw0bjBRQ0FkUUFRMTc1dWxodmVFZWFPZS1zdXBFNDFod0NBZFFBUTE3NXVqQnZlRWVhSVNoTWd6LS1xd0FB";
//        
//        ResponseWrapper object =  (ResponseWrapper) chat.exportChatMessages(5L, null, null);
//        System.out.println(object.getResponseBody());
	}

}
