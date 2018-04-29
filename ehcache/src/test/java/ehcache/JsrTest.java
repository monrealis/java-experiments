package ehcache;

import org.junit.Test;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import javax.cache.spi.CachingProvider;

public class JsrTest {
    @Test
    public void run() {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager();
        MutableConfiguration<Long, String> configuration =
                new MutableConfiguration<Long, String>()
                        .setTypes(Long.class, String.class)
                        .setStoreByValue(false)
                        .setExpiryPolicyFactory(CreatedExpiryPolicy.factoryOf(Duration.ONE_MINUTE));
        Cache<Long, String> cache = cacheManager.createCache("jCache", configuration);
        cache.put(1L, "one");
        String value = cache.get(1L);
    }
}
