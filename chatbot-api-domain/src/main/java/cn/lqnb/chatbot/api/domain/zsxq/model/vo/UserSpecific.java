package cn.lqnb.chatbot.api.domain.zsxq.model.vo;

/**
 * @description:
 * @author：遇见你
 * @date: 2023-12-15
 * @Copyright： 只要学不死，就往死里学。
 */
public class UserSpecific {

    private boolean liked;

    private boolean subscribed;

    public void setLiked(boolean liked){
        this.liked = liked;
    }
    public boolean getLiked(){
        return this.liked;
    }
    public void setSubscribed(boolean subscribed){
        this.subscribed = subscribed;
    }
    public boolean getSubscribed(){
        return this.subscribed;
    }
}
