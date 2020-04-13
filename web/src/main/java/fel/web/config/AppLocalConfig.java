package fel.web.config;

import fel.core.config.JPAConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"fel.core"})
@Import({JPAConfig.class})
@PropertySources({@PropertySource(value="classpath:local/db.properties"),})
public class AppLocalConfig {
    
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
