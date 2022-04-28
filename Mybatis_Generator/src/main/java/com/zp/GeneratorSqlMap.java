package com.zp;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * 逆向工程
 */
public class GeneratorSqlMap {
    public static void main(String[] args) {
        try {
        List<String> warnings = new ArrayList<>();

        File file = new File("./src/main/resources/generatorConfig.xml");
        ConfigurationParser configurationParser = new ConfigurationParser(warnings);
        Configuration configuration = configurationParser.parseConfiguration(file);
        DefaultShellCallback defaultShellCallback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,defaultShellCallback,warnings);
        myBatisGenerator.generate(null);
        } catch (IOException | XMLParserException | InvalidConfigurationException
                | SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
