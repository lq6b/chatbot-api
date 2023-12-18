package cn.lqnb.chatbot.api.domain.zsxq;

import cn.lqnb.chatbot.api.domain.zsxq.model.aggregates.UnAnsweredQuestionsAggregates;

import java.io.IOException;

/**
 * @description: 知识星球api接口
 * @author：遇见你
 * @date: 2023-12-15
 * @Copyright： 只要学不死，就往死里学。
 */
public interface IZsxqApi {

    /**
     * 查询未回答的数据信息
     * @param groupId
     * @param cookie
     * @return
     * @throws IOException
     */
    UnAnsweredQuestionsAggregates queryUnAnsweredQuestionsTopicId(String groupId, String cookie) throws IOException;

    /**
     * 回答问题
     * @param groupId
     * @param cookie
     * @param topicId
     * @param text
     * @param silenced
     * @return
     * @throws IOException
     */
    boolean answer(String groupId, String cookie, String topicId, String text, boolean silenced) throws IOException;
}
