package com.example.demo.filter;

import org.springframework.context.annotation.FilterType;

public class AbstractPreZuulFilter  extends AbstractZuulFilter {

	@Override
	public String filterType() {
		return FilterType.pre.name();
	}

}
