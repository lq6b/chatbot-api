package cn.lqnb.chatbot.api.domain.zsxq.model.vo;

/**
 * @description:
 * @author：遇见你
 * @date: 2023-12-15
 * @Copyright： 只要学不死，就往死里学。
 */
public class OwnerDetail {

    private int questions_count;

    private String join_time;

    public void setQuestions_count(int questions_count){
        this.questions_count = questions_count;
    }
    public int getQuestions_count(){
        return this.questions_count;
    }
    public void setJoin_time(String join_time){
        this.join_time = join_time;
    }
    public String getJoin_time(){
        return this.join_time;
    }
}
