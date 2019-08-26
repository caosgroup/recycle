import com.ares.recycle.RecyclingApplication;
import com.ares.recycle.common.base.SpringContextUtil;
import com.ares.recycle.mapper.UserMapper;
import com.ares.recycle.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RecyclingApplication.class)
@ActiveProfiles("dev")
public class TestUserSave {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void save() {
        int i = userMapper.insertUser(new User("1", "zhang3"));
        System.out.println(i);
    }

    @Test
    public void test() {

        ApplicationContext context = SpringContextUtil.getApplicationContext();
        Environment environment = context.getEnvironment();
        System.out.println(environment);
        System.out.println(environment.getActiveProfiles());
        System.out.println(environment.getDefaultProfiles());
        System.out.println(environment.containsProperty("dev"));

    }
}
