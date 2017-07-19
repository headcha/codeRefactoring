package com.seolgi.refactor.config.xss;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.nhncorp.lucy.security.xss.XssFilter;

import java.io.IOException;

public class XssModule extends SimpleModule {

	public XssModule() {
		super();

		addDeserializer(String.class, new XssDeserializer());
	}

	private class XssDeserializer extends JsonDeserializer<String> {

		@Override
		public String deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {
			String value = jsonParser.getValueAsString();
			return XssFilter.getInstance().doFilter(value);
		}
	}
}
