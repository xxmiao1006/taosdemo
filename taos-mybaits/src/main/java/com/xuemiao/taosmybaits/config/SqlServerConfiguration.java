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
 * @date 2021/3/10 10:51
 */
@Configuration
@MapperScan(basePackages = "com.xuemiao.taosmybaits.sqlserver.dao",sqlSessionFactoryRef = "sqlserverSqlSessionFactory")
public class SqlServerConfiguration {


    @Bean(name="sqlserverDataSource")
    //下面的注解作用就是从application.properties中读取以这个字符串开头的那些配置，设置为数据源的配置
    @ConfigurationProperties(prefix ="spring.datasource.sqlserver")
    public DataSource sqlserverDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean(name="sqlserverSqlSessionFactory")
    public SqlSessionFactory sqlserverSqlSessionFactory(@Qualifier("sqlserverDataSource") DataSource dataSource)throws Exception{
        SqlSessionFactoryBean bean=new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        // 这里配置的是sqlserver需要读取的xml文件路径
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/sqlserver/*Mapper.xml"));

        SqlSessionFactory sqlSessionFactory = bean.getObject();
        // 这里就是第二步中提到的数据库字段下划线转驼峰的配置
        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory;
    }
    @Bean(name = "sqlserverTransactionManager")
    public DataSourceTransactionManager sqlserverTransactionManager(@Qualifier("sqlserverDataSource")DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
    @Bean(name="sqlserverSqlSessionTemplate")
    public SqlSessionTemplate sqlserverSqlSessionTemplate(@Qualifier("sqlserverSqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
