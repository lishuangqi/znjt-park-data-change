package org.spring.springboot.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = ZnjtDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "znjtSqlSessionFactory")
public class ZnjtDataSourceConfig {

    // 精确到 znjt 目录，以便跟其他数据源隔离
    static final String PACKAGE = "org.spring.springboot.dao.znjt";
    static final String MAPPER_LOCATION = "classpath:mapper/znjt/*.xml";

    @Value("${znjt.datasource.url}")
    private String url;

    @Value("${znjt.datasource.username}")
    private String user;

    @Value("${znjt.datasource.password}")
    private String password;

    @Value("${znjt.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "znjtDataSource")
    public DataSource znjtDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "znjtTransactionManager")
    public DataSourceTransactionManager znjtTransactionManager() {
        return new DataSourceTransactionManager(znjtDataSource());
    }

    @Bean(name = "znjtSqlSessionFactory")
    public SqlSessionFactory znjtSqlSessionFactory(@Qualifier("znjtDataSource") DataSource znjtDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(znjtDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ZnjtDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}