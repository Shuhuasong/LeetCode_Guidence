package OnlineCodingChallege.CapitalOne;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shuhua Song
 *
 * 设计一个验证码系统，所有的验证码都存在cache里，可以用 用户名 和 发送验证码的时间来搜索验证码，
 * 验证码还有有效期限，如果过期了就无效，要从cache里删掉
 * OOD设计验证码系统什么思路？也用map吗
 * LC-1797 Design Authentication Manager
 *
 * 第二题是类似system design， 要求设计一个验证码系统，所有的验证码都存在cache里，可以用 用户名 和
 * 发送验证码的时间来搜索验证码， 验证码还有有效期限，如果过期了就无效，要从cache里删掉
 *
 * 第二轮 case interview, 和地里提到的银行收购问题完全不同。 是银行自动回复机器人系统，给你一段代码，
 * 问你这个能不能帮助这个系统预测用户需要什么帮助。 然后让你修改一下
 * 就是会问各种testing的区别(unit test vs integration test vs system test vs functional test)和作用，
 * 会给你一个类似报表的东西，然后让你改几行代码让其输出正确
 *
 *
 * 第三轮 BQ，面试官很nice, 问的都不难。 tell me a time you need to make change in your project
 * in the last minutes, tell me a time you work in a team, tell me a time you consider youself
 * as a team leader even though you are not the team leader.
 *
 *

 *
 */
public class VerificationCodeSystem {


    Map<String, Integer> tokenMap = new HashMap<>();
    int timeToLive;
    public VerificationCodeSystem(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if(!tokenMap.containsKey(tokenId)) return;
        if(tokenMap.get(tokenId) <= currentTime){
            tokenMap.remove(tokenId);
            return;
        }
        tokenMap.put(tokenId, currentTime+timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for(String id : tokenMap.keySet()){
            if(tokenMap.get(id) > currentTime){
                count++;
            }
        }
        return count;
    }
}
