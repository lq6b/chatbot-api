package cn.lqnb.chatbot.api.domain.zsxq.model.req;

/**
 * @description: 请求问答接口信息
 * @author：遇见你
 * @date: 2023-12-18
 * @Copyright： 只要学不死，就往死里学。
 */
public class AnswerReq {

    private ReqData req_data;

    public AnswerReq(ReqData req_data) {
        this.req_data = req_data;
    }

    public ReqData getReq_data() {
        return req_data;
    }

    public void setReq_data(ReqData req_data) {
        this.req_data = req_data;
    }
}
