import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shenzc.ShardingJdbcApplication;
import com.shenzc.entity.ShardingUser;
import com.shenzc.mapper.ShardingTestMapper;
import com.shenzc.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 水平分库分表操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJdbcApplication.class)
public class chui_zhi_fen_ku_test {

    @Autowired
    private ShardingTestMapper shardingTestMapper;

    //添加课程
    //@Test
    //public void addCourse() {
    //    for (int i=0;i<20;i++){
    //        ShardingTest shardingTest = new ShardingTest();
    //        //cid由我们设置的策略，雪花算法进行生成
    //        shardingTest.setCname("Java");
    //        shardingTest.setUserId(new Integer(i).longValue());
    //        shardingTest.setStatus("Normal");
    //        shardingTestMapper.insert(shardingTest);
    //    }
    //}

    //@Test
    //public void findCourse() {
    //    QueryWrapper<ShardingTest> wrapper = new QueryWrapper<ShardingTest>();
    //    wrapper.eq("user_id", 13);
    //    wrapper.eq("cid", 563727912461664256L);
    //    System.out.println(shardingTestMapper.selectOne(wrapper));;
    //}

    @Autowired
    private UserMapper userMapper;

    //@Test
    //public void addUser(){
    //    ShardingUser shardingUser = new ShardingUser();
    //    shardingUser.setUsername("Jack");
    //    shardingUser.setStatus("Normal");
    //    userMapper.insert(shardingUser);
    //}

    @Test
    public void findUser() {
        QueryWrapper<ShardingUser> wrapper = new QueryWrapper<ShardingUser>();
        wrapper.eq("user_id", 563736839387611137L);
        userMapper.selectOne(wrapper);
    }
}