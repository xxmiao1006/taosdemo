package com.xuemiao.taosmybaits.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author xxm
 * @date 2021/3/10 10:12
 */
@Configuration
@MapperScan(basePackages = "com.xuemiao.taosmybaits.taos.dao",sqlSessionFactoryRef = "taosdbSqlSessionFactory")
public class TaosdbConfiguration {

    @Bean(name="taosdbDataSource")
    @ConfigurationProperties(prefix ="spring.datasource.taos")
    public DataSource taosdbDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean(name="taosdbSqlSessionFactory")
    public SqlSessionFactory taosdbSqlSessionFactory(@Qualifier("taosdbDataSource") DataSource dataSource)throws Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/taos/*Mapper.xml"));

        SqlSessionFactory sqlSessionFactory = bean.getObject();
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }
    @Bean(name = "taosdbTransactionManager")
    public DataSourceTransactionManager taosdbTransactionManager(@Qualifier("taosdbDataSource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name="taosdbSqlSessionTemplate")
    public SqlSessionTemplate taosdbSqlSessionTemplate(@Qualifier("taosdbSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
