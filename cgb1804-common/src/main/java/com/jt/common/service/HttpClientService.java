package com.jt.common.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
@Service
public class HttpClientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientService.class);
    @Autowired(required=false)
    private CloseableHttpClient httpClient;   //定义httpClient
    
    @Autowired(required=false)
    private RequestConfig requestConfig;    //设定请求参数
    
    /**
     * 编辑get请求
     * 参数定义:定义几个?
     * 如何动态拼接
     * @throws URISyntaxException 
     * @throws IOException 
     * @throws ClientProtocolException 
     */
    public String get(String url ,Map<String,String> params,String charset) {
        
        String result = null;
        //1、判断字符集编码是否为空
        if(StringUtils.isEmpty(charset)) {
            charset = "UTF-8";
        }
        try {
        //2、判断参数是否为空
        if(params!=null) {
//            //拼接url
//            String paramUrl = url+"?";
//            for (Map.Entry<String, String> entry  : params.entrySet()) {
//                paramUrl = paramUrl+entry.getKey()+"="+entry.getValue()+"&";
//            }
//            //截取前面的 不要最后一个&
//            paramUrl = paramUrl.substring(0,paramUrl.length()-1);
            /*
             * 上面这个太啰嗦了
             * 使用工具类 来拼接url
             * URIBuilder的addParameter方法
             */
            URIBuilder builder=new URIBuilder(url);
            for (Map.Entry<String, String> entry  : params.entrySet()) {
                builder.addParameter(entry.getKey(), entry.getValue());
            }
            //生成具体urllocalhost:8091?id.....
            url = builder.build().toString();  
            System.out.println("HttpClientService:url:"+url);
        }
        //3、定义请求对象
        HttpGet httpGet = new HttpGet(url);
        //spring注入的对象 定义请求时长
        httpGet.setConfig(requestConfig);
        //4、发起请求
        CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
        System.out.println("HttpClientService:get:httpResponse"+httpResponse.toString());
        //5判断响应结果是否正确
        if(httpResponse.getStatusLine().getStatusCode()==200) {
            result = EntityUtils.toString(httpResponse.getEntity(),charset);            
        }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    //为了满足需要 添加下列方法
    public String get(String url)  {
        return get(url,null,null);
    }
    public String get(String url,Map<String,String> params) {
        return get(url,params,null);
    }
    
    
    /**
     * 实现post请求
     * post需要将请求数据封装到form表单对象中
     */
    public String post(String url,Map<String,String> params,String charset) {
        String result = null;
        //1、判断字符集编码是否为空
        if(StringUtils.isEmpty(charset)) {
            charset = "UTF-8";
        }
        //2、定义请求对象
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        //4 判断params不为空 否则不用进行第三部的封装
        if(params!=null) {
            //3人不认map只认entity，再封装一次
            List<NameValuePair> parmeters = new ArrayList<>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                BasicNameValuePair valuePair = new BasicNameValuePair(entry.getKey(), entry.getValue());
                parmeters.add(valuePair);
            }
            UrlEncodedFormEntity entity = null;
            try {
                entity = new UrlEncodedFormEntity(parmeters,charset);
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            httpPost.setEntity(entity);
            
        }
        
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            if(httpResponse.getStatusLine().getStatusCode()==200) {
                result = EntityUtils.toString(httpResponse.getEntity(),charset);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //抛出自定义异常 继承自RuntimeException
            throw new RuntimeException("httpClient.execute(httpPost);有问题");
        }
        return result;
    }
    
    //为了满足需要 添加下列方法
    public String post(String url)  {
        return post(url,null,null);
    }
    public String post(String url,Map<String,String> params) {
        return post(url,params,null);
    }
    
    
    
    
    
}
