package com.yuanfeng.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @ClassName HttpGetTest
 * @Description Get请求带带参数
 * @Author yuanfeng
 * @Date 2019/11/8 21:41
 * @Version 1.0
 **/
public class HttpGetTestParam {

    public static void main(String[] args) throws IOException, URISyntaxException {

        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //设置请求地址是:http://yun.itheima.com/search?keys=Java
        //创建URIBuilder
        URIBuilder uriBuilder = new URIBuilder("http://yun.itheima.com/search");
        //设置参数
        uriBuilder.setParameter("keys","Java");

        //创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        System.out.println("发起请求的信息"+httpGet);
        //使用HttpClient发送Post请求，返回响应结果
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);

            //解析响应
            if(response.getStatusLine().getStatusCode() == 200){
                String content = EntityUtils.toString(response.getEntity(), "utf8");
                System.out.println(content.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭response
            response.close();
            httpClient.close();
        }
    }



}
