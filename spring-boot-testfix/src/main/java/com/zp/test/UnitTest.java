package com.zp.test;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 单元测试
 */
//@SpringBootTest
@DisplayName("单元测试类")
public class UnitTest {


    @DisplayName("see 方法")
    @Test
    void see(){
        System.out.println("see you again");
    }
    @DisplayName("登录方法")
    @BeforeEach
    void login(){
        System.out.println("login success");
    }
    @DisplayName("结束方法")
    @AfterEach
    void loginout(){
        System.out.println("thanks!");
    }

    @Disabled
    @DisplayName("skip方法")
    @Test
    void skip(){
        System.out.println("该方法不会执行");
    }

    @DisplayName("参数测试")
    @ParameterizedTest
    @ValueSource(strings ={ "3","4","5"})
    void param(String i){
        System.out.println(i);
    }
    @DisplayName("方法测试")
    @ParameterizedTest
    @MethodSource("method")
    void methodTest(int i){
        System.out.println(i);
    }
    static int[] method(){
        int[] ss1={3,2,7};
        return ss1;
    }
    @DisplayName("循环测试")
    @RepeatedTest(2)
    void fortest(){
        System.out.println(1);
    }
    @BeforeAll
    static void start(){
        System.out.println("测试开始");
    }
    @AfterAll
    static void end(){
        System.out.println("测试结束");
    }
}
