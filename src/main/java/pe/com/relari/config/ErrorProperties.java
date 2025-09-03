package pe.com.relari.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "app.error")
public interface ErrorProperties {

    String defaultMessage();
    Integer status();

}
