import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shenzc.ShardingJdbcApplication;
import com.shenzc.entity.ShardingTest;
import com.shenzc.mapper.ShardingTestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * 分表操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJdbcApplication.class)
public class fen_biao_test {

    @Autowired
    private ShardingTestMapper shardingTestMapper;

    //添加课程
    //@Test
    //public void addCourse() {
    //    for (int i=0;i<20;i++){
    //        ShardingTest shardingTest = new ShardingTest();
    //        //cid由我们设置的策略，雪花算法进行生成
    //        shardingTest.setCname("Java");
    //        shardingTest.setUserId(100L);
    //        shardingTest.setStatus("Normal");
    //        shardingTestMapper.insert(shardingTest);
    //    }
    //}

    @Test
    public void findCourse() {
        QueryWrapper<ShardingTest> wrapper = new QueryWrapper<ShardingTest>();
        wrapper.eq("cid", 919257671);
        System.out.println(shardingTestMapper.selectOne(wrapper));;
    }
}