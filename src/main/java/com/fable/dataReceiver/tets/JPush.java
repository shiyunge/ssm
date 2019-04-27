package com.fable.dataReceiver.tets;


import cn.jiguang.common.ClientConfig;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.Notification;
import org.testng.annotations.Test;

/**
 * 测试极光推送信息
 */
public class JPush {

    private String MASTER_SECRET = "46f6cddf57a09f7d24b6a2a1";
    private String APP_KEY = "0ed3e59c63ef513c2cbc179a";
    private String ID = "13065ffa4e47f3aacb1";//设备别名
    private String title = "消息通知";
    private String alert = "测试消息通知";
    private ClientConfig config = ClientConfig.getInstance();
    private JPushClient client = new JPushClient(MASTER_SECRET, APP_KEY, null, config);


    /**
     * 面向的是安卓端   发送给指定的目标
     */
    @Test
    public void pushAline() {
        PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android())//推送平台
                .setAudience(Audience.registrationId("13065ffa4e47f3aacb1"))//推送目标
                .setNotification(Notification.newBuilder().addPlatformNotification(AndroidNotification.newBuilder().
                        setAlert(alert).setTitle(title).build()).build())//通知消息（标题，内容）
                .setOptions(Options.newBuilder().setApnsProduction(true).setTimeToLive(86400).build()//离线消息保存时间
                )
                .build();
        try {
            PushResult result = client.sendPush(payload);//推送
            System.out.println("推送结果：" + result.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
