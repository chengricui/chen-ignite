package io.project.app;

import io.project.model.Flight;
import io.project.model.ProductType;
import io.project.repositories.FlightRepository;
import javax.cache.configuration.FactoryBuilder;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import static org.apache.ignite.Ignition.ignite;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.apache.ignite.cache.CacheAtomicityMode.TRANSACTIONAL;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.spring.SpringCacheManager;
import org.apache.ignite.cache.store.CacheStore;

/**
 *
 * @author armdev
 */
@Configuration
public class IgniteConfig {

    @Bean(destroyMethod = "close")
    @SuppressWarnings("unchecked")
    public Ignite igniteInstance() {
        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
        // Setting some custom name for the node.
        igniteConfiguration.setIgniteInstanceName("springDataNode");
        // Enabling peer-class loading feature.
        igniteConfiguration.setPeerClassLoadingEnabled(true);

        CacheConfiguration ccfgFlight = new CacheConfiguration("FlightCache");
//        cacheConfiguration.setAtomicityMode(TRANSACTIONAL);
//        cacheConfiguration.setCacheMode(CacheMode.REPLICATED);
        ccfgFlight.setIndexedTypes(Long.class, Flight.class);

        CacheConfiguration ccfgProductType = new CacheConfiguration("ProductTypeCache");
        ccfgProductType.setIndexedTypes(Long.class, ProductType.class);

        igniteConfiguration.setActiveOnStart(true);

        igniteConfiguration.setCacheConfiguration(new CacheConfiguration[]{ccfgFlight, ccfgProductType});
        SpringCacheManager springCacheManager = new SpringCacheManager();
        springCacheManager.setConfiguration(igniteConfiguration);

        return Ignition.start(igniteConfiguration);

        //return ignite;
    }

    // https://github.com/apache/ignite/blob/master/examples/src/main/java/org/apache/ignite/examples/datagrid/CacheQueryExample.java
}
