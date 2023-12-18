package cn.lqnb.chatbot.api.domain.zsxq.model.res;

/**
 * @description: 请求问答接口结果
 * @author：遇见你
 * @date: 2023-12-18
 * @Copyright： 只要学不死，就往死里学。
 */
public class AnswerRes {

    // 是否成功
    private boolean succeeded;

    public boolean isSucceeded() {
        return succeeded;
    }

    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }
}
