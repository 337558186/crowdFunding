package cn.cf.test;

import cn.cf.util.Md5Util;
import org.junit.Test;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/12/4 - 15:59
 * @description ：
 */
public class CommomTest {

    /**
     * 测试md5工具
     */
    @Test
    public void testMd5(){

        String source = "admin";
        String output = Md5Util.md5Encrypt(source);
        System.out.println(output);
    }
}
