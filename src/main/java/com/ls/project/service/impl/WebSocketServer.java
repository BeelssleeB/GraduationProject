package com.ls.project.service.impl;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/webSocket/{cid}")
@Component
public class WebSocketServer {
    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    // 客户端声明的ID，可能不止一个
    private String cid = "";

    // 连接建立成功调用的方法
    @OnOpen
    public void onOpen(Session session, @PathParam("cid") String cid) throws IOException {
        addOnlineCount(); // 在线数加1
        System.out.println(new Throwable().getStackTrace()[0] + "连接建立成功, session.id = " + session.getId() + ", cid = " + cid + "，当前在线人数为：" + getOnlineCount());
        if (cid == null) {
            //L.e(new Throwable().getStackTrace()[0] + "无法取得cid，设置cid为：" + session.getId());
            cid = session.getId();
        }
        this.cid = cid;
        this.session = session;
        webSocketSet.add(this); // 加入set中
    }

    // 连接关闭调用的方法
    @OnClose
    public void onClose() {
        System.out.println(new Throwable().getStackTrace()[0] + ", 连接关闭，cid =  " + this.cid);
        webSocketSet.remove(this); // 从set中删除
        subOnlineCount(); // 在线数减1
    }


    /**
     * 发生错误时调用的方法
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println(new Throwable().getStackTrace()[0] + "session.id = " + session.getId() + "，发生错误：\n" + error);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 当前的会话，全局唯一
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        System.out.println(new Throwable().getStackTrace()[0] + ", cid = " + cid + ", session.id = " + session.getId() + ", \nmessage = \n" + message);
        sendMessage("消息处理成功：" + message);

        //消息转发给其他客户端
        JSONObject o = JSONObject.parseObject(message);
        String toCid = o.getString("toCid");
        if(toCid != null) {
            System.out.println("转发消息给：" + toCid);
            sendTo("来自" + cid + "发给" + toCid + "的消息：" + o.getString("message"), toCid);
        }
    }

    // 实现服务器立刻主动推送到当前连接过来的客户端
    public void sendMessage(String message) throws IOException {
        System.out.println(new Throwable().getStackTrace()[0] + ", cid = " + this.cid);
        this.session.getBasicRemote().sendText(message);
    }

    // 群发消息到所有客户端
    public static void sendToAll(String message) throws IOException {
        System.out.println(new Throwable().getStackTrace()[0] + "正在群发消息：" + message);
        for (WebSocketServer item : webSocketSet) {
            try {
                System.out.println("正在推送到：cid = " + item.cid + ", session.id = " + item.session.getId());
                item.sendMessage(message);
            } catch (IOException e) {
                continue;
            }
        }
    }

    /**
     * 发送一个消息到指定的客户端
     *
     * @param message 消息
     * @param toCid   客户端ID，可能不止一个，有可能同一个cid在多处登录
     */
    public static JSONObject sendTo(String message, @PathParam("toCid")String toCid) {
        System.out.println(new Throwable().getStackTrace()[0] + "\ntoCid = " + toCid + ", message = " + message);
        int coun = 0;
        JSONObject o = new JSONObject();
        o.put("success", false);
        o.put("message", "发送的对象【" + toCid + "】尚未连接");
        for (WebSocketServer item : webSocketSet) {
            try {
                if (item.cid.equals(toCid)) {
                    coun++;
                    o.put("success", true);
                    o.put("message", "成功发送到【" + toCid + "】");
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                //L.e(new Throwable().getStackTrace()[0] + "异常：" + e);
                continue;
            }
        }
        o.put("coun", coun);
        //System.out.println("发送结果：" + o);
        return o;
    }

    /*
     * 取得在线会话个数
     */
    public static synchronized int getOnlineCount() {
        //
        return onlineCount;
    }

    /*
     * 增加一个会话
     */
    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    /*
     * 减少一个会话
     */
    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

}

