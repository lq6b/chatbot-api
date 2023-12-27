package cn.lqnb.chatbot.api.domain.ai.service;

import cn.lqnb.chatbot.api.domain.ai.IOpenAI;
import cn.lqnb.chatbot.api.domain.ai.model.aggregates.AIAnswer;
import cn.lqnb.chatbot.api.domain.ai.model.vo.Choices;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @description:
 * @author：遇见你
 * @date: 2023-12-26
 * @Copyright： 只要学不死，就往死里学。
 */
@Service
public class OpenAI implements IOpenAI {

    Logger logger = LoggerFactory.getLogger(OpenAI.class);

    @Value("${chatbot-api.openAiKey}")
    private String openAiKey;


    @Override
    public String doChatGPT(String question) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost("https://api.openai.com/v1/completions");
        httpPost.addHeader("Content-Type","application/json");
        httpPost.addHeader("Authorization", "Bearer " + openAiKey);

        String paramJson = "{\n" +
                "    \"model\": \"gpt-3.5-turbo-instruct\",\n" +
                "    \"prompt\": \" "+ question +" \",\n" +
                "    \"max_tokens\": 1024,\n" +
                "    \"temperature\": 0\n" +
                "  }";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String jsonStr = EntityUtils.toString(response.getEntity());
            AIAnswer aiAnswer = JSON.parseObject(jsonStr, AIAnswer.class);
            StringBuilder answers = new StringBuilder();
            List<Choices> choices = aiAnswer.getChoices();
            for (Choices choice : choices) {
                answers.append(choice.getText());
            }
            return answers.toString();
        }else{
            throw new RuntimeException("api.openai.com Err Code is " + response.getStatusLine().getStatusCode());
        }
    }
}
