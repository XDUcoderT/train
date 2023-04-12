import com.tc.train.member.utils.RedisUtil;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;

public class RedisTest {
    @Resource
    private RedisUtil redisUtil;
    @Test
    public void test(){
        redisUtil.set("hello","world");
    }
}
