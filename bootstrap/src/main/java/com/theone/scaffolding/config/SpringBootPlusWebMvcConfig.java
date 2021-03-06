/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.theone.scaffolding.config;

import com.alibaba.fastjson.JSON;
import com.theone.scaffolding.config.properties.SpringBootPlusFilterProperties;
import com.theone.scaffolding.config.properties.SpringBootPlusInterceptorProperties;
import com.theone.scaffolding.config.properties.SpringBootPlusProperties;
import com.theone.scaffolding.framework.core.filter.RequestDetailFilter;
import com.theone.scaffolding.framework.core.interceptor.PermissionInterceptor;
import com.theone.scaffolding.framework.core.xss.XssFilter;
import com.theone.scaffolding.framework.util.IniUtil;
import com.theone.scaffolding.system.interceptor.DownloadInterceptor;
import com.theone.scaffolding.system.interceptor.ResourceInterceptor;
import com.theone.scaffolding.system.interceptor.UploadInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * WebMvc??????
 *
 * @author geekidea
 * @date 2018-11-08
 */
@Slf4j
@Configuration
public class SpringBootPlusWebMvcConfig implements WebMvcConfigurer {

    /**
     * spring-boot-plus????????????
     */
    @Autowired
    private SpringBootPlusProperties springBootPlusProperties;

    /**
     * Filter??????
     */
    private SpringBootPlusFilterProperties filterConfig;

    /**
     * ???????????????
     */
    private SpringBootPlusInterceptorProperties interceptorConfig;

    /**
     * RequestDetailFilter??????
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean requestDetailFilter() {
        SpringBootPlusFilterProperties.FilterConfig requestFilterConfig = filterConfig.getRequest();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new RequestDetailFilter());
        filterRegistrationBean.setEnabled(requestFilterConfig.isEnable());
        filterRegistrationBean.addUrlPatterns(requestFilterConfig.getUrlPatterns());
        filterRegistrationBean.setOrder(requestFilterConfig.getOrder());
        filterRegistrationBean.setAsyncSupported(requestFilterConfig.isAsync());
        return filterRegistrationBean;
    }

    /**
     * XssFilter??????
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean xssFilter() {
        SpringBootPlusFilterProperties.FilterConfig xssFilterConfig = filterConfig.getXss();
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new XssFilter());
        filterRegistrationBean.setEnabled(xssFilterConfig.isEnable());
        filterRegistrationBean.addUrlPatterns(xssFilterConfig.getUrlPatterns());
        filterRegistrationBean.setOrder(xssFilterConfig.getOrder());
        filterRegistrationBean.setAsyncSupported(xssFilterConfig.isAsync());
        return filterRegistrationBean;
    }


    /**
     * ????????????????????????
     *
     * @return
     */
    @Bean
    public PermissionInterceptor permissionInterceptor() {
        return new PermissionInterceptor();
    }

    /**
     * ???????????????
     *
     * @return
     */
    @Bean
    public UploadInterceptor uploadInterceptor() {
        return new UploadInterceptor();
    }

    /**
     * ???????????????
     *
     * @return
     */
    @Bean
    public ResourceInterceptor resourceInterceptor() {
        return new ResourceInterceptor();
    }

    /**
     * ???????????????
     *
     * @return
     */
    @Bean
    public DownloadInterceptor downloadInterceptor() {
        return new DownloadInterceptor();
    }


    @PostConstruct
    public void init() {
        filterConfig = springBootPlusProperties.getFilter();
        interceptorConfig = springBootPlusProperties.getInterceptor();
        // ??????SpringBootPlusProperties????????????
        log.debug("SpringBootPlusProperties???{}", JSON.toJSONString(springBootPlusProperties));
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // ???????????????
        if (interceptorConfig.getUpload().isEnable()) {
            registry.addInterceptor(uploadInterceptor())
                    .addPathPatterns(interceptorConfig.getUpload().getIncludePaths());
        }

        // ?????????????????????
        if (interceptorConfig.getResource().isEnable()) {
            registry.addInterceptor(resourceInterceptor())
                    .addPathPatterns(interceptorConfig.getResource().getIncludePaths());
        }

        // ?????????????????????
        if (interceptorConfig.getDownload().isEnable()) {
            registry.addInterceptor(downloadInterceptor())
                    .addPathPatterns(interceptorConfig.getDownload().getIncludePaths());
        }

        // ??????????????????????????????
        if (interceptorConfig.getPermission().isEnable()) {
            registry.addInterceptor(permissionInterceptor())
                    .addPathPatterns(interceptorConfig.getPermission().getIncludePaths())
                    .excludePathPatterns(interceptorConfig.getPermission().getExcludePaths());
        }

    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // ??????????????????????????????
        String resourceHandlers = springBootPlusProperties.getResourceHandlers();
        if (StringUtils.isNotBlank(resourceHandlers)) {
            Map<String, String> map = IniUtil.parseIni(resourceHandlers);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String pathPatterns = entry.getKey();
                String resourceLocations = entry.getValue();
                registry.addResourceHandler(pathPatterns)
                        .addResourceLocations(resourceLocations);
            }
        }

        // ??????????????????????????????
        registry.addResourceHandler(springBootPlusProperties.getResourceAccessPatterns())
                .addResourceLocations("file:" + springBootPlusProperties.getUploadPath());
    }

}
