package cn.lqnb.chatbot.api.domain.zsxq.model.res;

import cn.lqnb.chatbot.api.domain.zsxq.model.vo.Topics;

import java.util.List;

/**
 * @description: 结果数据
 * @author：遇见你
 * @date: 2023-12-18
 * @Copyright： 只要学不死，就往死里学。
 */
public class RespData {


    private List<Topics> topics;

    public List<Topics> getTopics() {
        return topics;
    }

    public void setTopics(List<Topics> topics) {
        this.topics = topics;
    }
}
