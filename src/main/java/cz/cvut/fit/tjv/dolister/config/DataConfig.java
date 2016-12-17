package cz.cvut.fit.tjv.dolister.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@PropertySource("app.properties")
public class DataConfig {
    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        // Driver class name
        dataSource.setDriverClassName(environment.getProperty("dolister.db.driver"));

        // Set URL
        dataSource.setUrl(environment.getProperty("dolister.db.url"));

        // Set username & password
        dataSource.setUsername(environment.getProperty("dolister.db.username"));
        dataSource.setPassword(environment.getProperty("dolister.db.password"));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        Resource resource = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
        localSessionFactoryBean.setConfigLocation(resource);
        localSessionFactoryBean.setPackagesToScan(environment.getProperty("dolister.entity.package"));
        localSessionFactoryBean.setDataSource(dataSource());
        return localSessionFactoryBean;
    }
}
