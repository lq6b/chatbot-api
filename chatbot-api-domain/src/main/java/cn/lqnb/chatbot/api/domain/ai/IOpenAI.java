package cn.lqnb.chatbot.api.domain.ai;

import java.io.IOException;

/**
 * @description:
 * @author：遇见你
 * @date: 2023-12-26
 * @Copyright： 只要学不死，就往死里学。
 */
public interface IOpenAI {

    String doChatGPT(String question) throws IOException;
}
