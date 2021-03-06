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

package com.theone.scaffolding.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author geekidea
 * @date 2020/3/16
 **/
@Slf4j
@Component
public class HelloSchedule {

    /**
     * 每小时执行一次
     */
    @Scheduled(cron = "0 0 0/1 * * ? ")
    public void hello() throws Exception {
        log.debug("HelloScheduled...");
    }

}
