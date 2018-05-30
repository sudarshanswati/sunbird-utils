package org.sunbird.telemetry.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sunbird.common.request.ExecutionContext;

import java.util.UUID;

/**
 * @author Mahesh Kumar Gangula
 */

public class PerformanceLogger {

    private static final Logger perfLogger = LogManager.getLogger("PerformanceTestLogger");

    public static void log(long duration, String action, String className, String requestId, String status, String scenario) {
        if (perfLogger.isInfoEnabled()) {

            String msg = "{\"eid\": \"LOG\", \"ets\":" + System.currentTimeMillis()
                    + ", \"ver\": \"3.0\", \"mid\": " + "\"PERFLOG."+ UUID.randomUUID() + "\""
                    + ", \"actor\": { \"id\": \"org.sunbird.learning.service\", \"type\": \"system\"}, \"context\": { \"channel\": \"NA\""
                    + ", \"pdata\": { \"id\": \"org.sunbird.learning.service\", \"ver\": \"1.7.0\" }, \"env\": \"learner\" }, \"edata\": {\"type\": \"perf_log\", \"level\": \"INFO\",\"message\": \"\", \"params\":["
                    + "{\"duration\": " + duration + "},"
                    + "{ \"action\": \"" + action + "\"},"
                    + "{ \"class\": \"" + className + "\"},"
                    + "{ \"scenario\": \"" + scenario + "\"},"
                    + "{ \"requestId\": \"" + requestId + "\"},"
                    + "{ \"status\": \"" + status + "\"}"
                    + "]}}";

                perfLogger.info(msg);
        }
    }


}
