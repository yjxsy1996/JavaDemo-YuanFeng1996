package com.yuanfeng.crawler;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName HttpGetTest
 * @Description Get请求不带参数
 * @Author yuanfeng
 * @Date 2019/11/8 21:41
 * @Version 1.0
 **/
public class HttpGetTest {

    public static void main(String[] args) throws IOException {

        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

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
