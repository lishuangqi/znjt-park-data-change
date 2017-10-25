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
@MapperScan(basePackages = ZhddparkDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "zhddparkSqlSessionFactory")
public class ZhddparkDataSourceConfig {

    // 精确到 zhddpark 目录，以便跟其他数据源隔离
    static final String PACKAGE = "org.spring.springboot.dao.zhddpark";
    static final String MAPPER_LOCATION = "classpath:mapper/zhddpark/*.xml";

    @Value("${zhddpark.datasource.url}")
    private String url;

    @Value("${zhddpark.datasource.username}")
    private String user;

    @Value("${zhddpark.datasource.password}")
    private String password;

    @Value("${zhddpark.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "zhddparkDataSource")
    public DataSource zhddparkDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "zhddparkTransactionManager")
    public DataSourceTransactionManager zhddparkTransactionManager() {
        return new DataSourceTransactionManager(zhddparkDataSource());
    }

    @Bean(name = "zhddparkSqlSessionFactory")
    public SqlSessionFactory zhddparkSqlSessionFactory(@Qualifier("zhddparkDataSource") DataSource zhddparkDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(zhddparkDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ZhddparkDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}