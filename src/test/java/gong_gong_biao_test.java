import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shenzc.ShardingJdbcApplication;
import com.shenzc.entity.ShardingDict;
import com.shenzc.mapper.DictMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @shenzc
 * @2021/2/3 15:24
 * 文件说明：
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShardingJdbcApplication.class)
public class gong_gong_biao_test {

    @Autowired
    private DictMapper dictMapper;

    //@Test
    //public void addDict() {
    //    ShardingDict dict = new ShardingDict();
    //    dict.setStatus("Normal");
    //    dict.setValue("启用");
    //    dictMapper.insert(dict);
    //}

    @Test
    public void addDict() {
        QueryWrapper<ShardingDict> wrapper = new QueryWrapper<ShardingDict>();
        wrapper.eq("dict_id", 563746716633792513L);
        System.out.println(dictMapper.selectOne(wrapper));
    }

    //@Test
    //public void deleteDict() {
    //    QueryWrapper<ShardingDict> wrapper = new QueryWrapper<ShardingDict>();
    //    wrapper.eq("dict_id", 563746238965481473L);
    //    dictMapper.delete(wrapper);
    //}
}
