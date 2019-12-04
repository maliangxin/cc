package com.mal.core.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mal.core.LogExampleOther;

@RestController
public class Log4j2Controller {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(LogExampleOther.class);
	/**
	 * LOG4j2动态修改包名的日志级别
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/log4j.do")
	public String update(@RequestParam(value = "level") String level) {
		String msg = "success";
		level = level.toLowerCase();
		org.apache.logging.log4j.core.LoggerContext ctx = (org.apache.logging.log4j.core.LoggerContext) LogManager
				.getContext(false);
		Configuration config = ctx.getConfiguration();
		LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
		switch (level) {
		case "trace":
			loggerConfig.setLevel(org.apache.logging.log4j.Level.TRACE);
			break;
		case "debug":
			loggerConfig.setLevel(org.apache.logging.log4j.Level.DEBUG);
			break;
		case "info":
			loggerConfig.setLevel(org.apache.logging.log4j.Level.INFO);
			break;
		case "warn":
			loggerConfig.setLevel(org.apache.logging.log4j.Level.WARN);
			break;
		case "error":
			loggerConfig.setLevel(org.apache.logging.log4j.Level.ERROR);
			break;
		default:
			msg = "日志级别修改失败！";
			break;
		}
		ctx.updateLoggers();
		return msg;
	}

	@GetMapping("/level.do")
	public String testLevel() {

		org.apache.logging.log4j.core.LoggerContext ctx = (org.apache.logging.log4j.core.LoggerContext) LogManager
				.getContext(false);
		Configuration config = ctx.getConfiguration();
		LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
		String level = loggerConfig.getLevel().name();
		level = level.toLowerCase();
		switch (level) {
		case "trace":
			log.trace("现在日志级别是trace");
			break;
		case "debug":
			log.debug("现在日志级别是debug");
			break;
		case "info":
			log.info("现在日志级别是info");
			break;
		case "warn":
			log.warn("现在日志级别是warn"); 
			break;
		case "error":
			log.error("现在日志级别是error");
			break;
		default:
			break;
		}
		return "当前日志级别是："+level;
	}

}
