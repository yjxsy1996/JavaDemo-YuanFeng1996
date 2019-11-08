package com.yuanfeng.crawler;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @ClassName CrawlerFirst
 * @Description T0D0
 * @Author yuanfeng
 * @Date 2019/11/8 17:50
 * @Version 1.0
 **/
public class CrawlerFirst {

    public static void main(String[] args) throws Exception{

        //1.打开浏览器.创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //输入网址,创建get对象
        HttpGet httpGet = new HttpGet("http://www.baidu.com");

        //按回车，发起请求,返回响应
        CloseableHttpResponse execute = httpClient.execute(httpGet);

        //解析响应获取数据
        //判断状态码是否是200
        if(execute.getStatusLine().getStatusCode() == 200){

            HttpEntity executeEntity = execute.getEntity();
            String resultUrl = EntityUtils.toString(executeEntity, "utf8");
            System.out.println(resultUrl);
        }

    }
}
