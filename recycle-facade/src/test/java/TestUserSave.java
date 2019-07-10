import com.ares.recycle.RecyclingApplication;
import com.ares.recycle.mapper.UserMapper;
import com.ares.recycle.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RecyclingApplication.class)
public class TestUserSave {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void save() {
        int i = userMapper.insertUser(new User("1", "zhang3"));
        System.out.println(i);
    }
}
