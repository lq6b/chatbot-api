package cn.lqnb.chatbot.api.domain.zsxq.model.aggregates;

import cn.lqnb.chatbot.api.domain.zsxq.model.res.RespData;

/**
 * @description: 未回答问题的聚合信息
 * @author：遇见你
 * @date: 2023-12-18
 * @Copyright： 只要学不死，就往死里学。
 */
public class UnAnsweredQuestionsAggregates {

    private boolean succeeded;
    private RespData resp_data;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }

    public RespData getResp_data() {
        return resp_data;
    }

    public void setResp_data(RespData resp_data) {
        this.resp_data = resp_data;
    }
}
