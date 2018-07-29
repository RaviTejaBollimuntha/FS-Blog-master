package com.fs.config;

import java.util.Properties;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fs.framework.mapper.IMyMapper;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
* MyBatis scan interface, using the tk.mybatis.spring.mapper.MapperScannerConfigurer
 * If you don't use generic Mapper, you can change it to org.xxx...
 * Since the MapperScannerConfigurer is executed earlier, you must have the following annotation @Autoconfigureaafter
 *
 * @author raviteja
 */
@Configuration
@AutoConfigureAfter(MybatisAutoConfiguration.class)
public class MyBatisMapperScannerConfig {

  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
    mapperScannerConfigurer.setBasePackage("com.fs.mapper");
    Properties properties = new Properties();
    // Here to pay special attention to, do not put mymapper in basePackage, that is not the same as other Mapper to be scanned.
    properties.setProperty("mappers", IMyMapper.class.getName());
    properties.setProperty("notEmpty", "false");
    properties.setProperty("IDENTITY", "MYSQL");
    mapperScannerConfigurer.setProperties(properties);
    return mapperScannerConfigurer;
  }

}
