package cn.lqnb.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @description: 单元测试
 * @author：遇见你
 * @date: 2023-12-13
 * @Copyright： 只要学不死，就往死里学。
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        // 创建 CloseableHttpClient
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建HttpGet请求
        HttpGet httpGet = new HttpGet("https://api.zsxq.com/v2/groups/28885518425541/topics?scope=all&count=20");
        // 添加请求头信息
        httpGet.addHeader("Cookie", "zsxq_access_token=3EB63313-5C9C-8189-F7D7-AF06DF289378_FE54C5CF7E4C1B87; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22185285552184552%22%2C%22first_id%22%3A%2218c13ac6677104-0d0df9f5bef6cc8-26031051-2073600-18c13ac6678660%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjMTNhYzY2NzcxMDQtMGQwZGY5ZjViZWY2Y2M4LTI2MDMxMDUxLTIwNzM2MDAtMThjMTNhYzY2Nzg2NjAiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODUyODU1NTIxODQ1NTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22185285552184552%22%7D%2C%22%24device_id%22%3A%2218c13ac6677104-0d0df9f5bef6cc8-26031051-2073600-18c13ac6678660%22%7D; zsxqsessionid=d3b6ddf2ba7136cae7617af3f25178d2; abtest_env=product");
        httpGet.addHeader("Content-Type","application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(httpGet);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println("==============================");
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }


    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpclient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://api.zsxq.com/v2/topics/188121881415482/comments");
        httpPost.addHeader("Cookie", "zsxq_access_token=3EB63313-5C9C-8189-F7D7-AF06DF289378_FE54C5CF7E4C1B87; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22185285552184552%22%2C%22first_id%22%3A%2218c13ac6677104-0d0df9f5bef6cc8-26031051-2073600-18c13ac6678660%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjMTNhYzY2NzcxMDQtMGQwZGY5ZjViZWY2Y2M4LTI2MDMxMDUxLTIwNzM2MDAtMThjMTNhYzY2Nzg2NjAiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIxODUyODU1NTIxODQ1NTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22185285552184552%22%7D%2C%22%24device_id%22%3A%2218c13ac6677104-0d0df9f5bef6cc8-26031051-2073600-18c13ac6678660%22%7D; zsxqsessionid=d3b6ddf2ba7136cae7617af3f25178d2; abtest_env=product");
        httpPost.addHeader("Content-Type","application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpclient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }

    @Test
    public void test_ChatGPT() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://api.openai.com/v1/completions");
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Authorization", "Bearer $OPENAI_API_KEY");

        String paramJson = "{\n" +
                "    \"model\": \"gpt-3.5-turbo-instruct\",\n" +
                "    \"prompt\": \"写个Java冒泡排序\",\n" +
                "    \"max_tokens\": 1024,\n" +
                "    \"temperature\": 0\n" +
                "  }";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }

    }


}
