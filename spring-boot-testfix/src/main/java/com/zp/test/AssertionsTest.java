package com.zp.test;

import org.junit.jupiter.api.*;
import java.time.Duration;

/**
 * 断言
 */
@DisplayName("断言测试类")
public class AssertionsTest {

    int exp(int i,int j){
        return i+j;
    }

    @Test
    void isequals(){
        Assertions.assertEquals(7,exp(3,4),"计算失败");
        System.out.println("断言值相等成功");
    }

    @Test
    void array(){
        Assertions.assertArrayEquals(new int[]{1,2},new int[]{1,2},"数组值不同，断言失败");
        System.out.println("success");
    }
    @DisplayName("断言对象")
    @Test
    void test(){
//        Assertions.assertSame(new String("4"),"4","两个字符串不是一个对象");
        Assertions.assertSame("4","4","两个字符串不是一个对象");
        System.out.println("success");
    }
    @DisplayName("组合断言")
    @Test
    void all(){
        Assertions.assertAll(
                ()->{Assertions.assertEquals(1,1,"条件一不满足");}
        ,       ()->{Assertions.assertSame("3","3","条件2不是同一个对象");}
                );
        System.out.println("success");
    }
    @Test
    @DisplayName("异常断言")
    void exception(){
        ArrayIndexOutOfBoundsException aThrows=Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,()->{
            int[] ints = new int[3];
            System.out.println(ints[2]);
        },"数组下标没有越界");
        System.out.println("异常存在");
    }

    @DisplayName("超时断言")
    @Test
    void timeOut(){
        Assertions.assertTimeout(Duration.ofMillis(1000),()->{Thread.sleep(3000);},"超时");
        System.out.println("程序正常运行");
    }

    @Test
    @DisplayName("快速失败")
    void fail(){
        Assertions.fail("666");
        System.out.println("快速失败");
    }

    @Nested
    @DisplayName("嵌套测试")
    class preTest{
        private final String even="yy";

        @DisplayName("前置条件1")
        @Test
        void seeBefore(){
            Assumptions.assumeTrue(this.even.equals("yy"));
            Assumptions.assumeFalse(this.even.equals("tt"));
            System.out.println("success");
        }
        @DisplayName("前置条件2")
        @Test
        void see2(){
            Assumptions.assumingThat(this.even.equals("e"),()-> System.out.println("999"));
            System.out.println("success");
        }

    }
}
