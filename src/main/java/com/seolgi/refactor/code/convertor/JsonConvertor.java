package com.seolgi.refactor.code.convertor;

import com.seolgi.refactor.advice.rule.model.Advice;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.seolgi.refactor.code.model.AdviceCollection;

public class JsonConvertor {
	public static JSONArray convertJsonArrayBy(AdviceCollection adviceCollection) throws JSONException {

		JSONArray adviceJsonArray = new JSONArray();

		for (Advice advice : adviceCollection.getAdviceList()) {
			JSONObject adviceJson = convertJsonBy(advice);
			adviceJsonArray.put(adviceJson);
		}

		return adviceJsonArray;
	}

	private static JSONObject convertJsonBy(Advice advice) throws JSONException {
		JSONObject adviceJson = new JSONObject();
		adviceJson.put("type", advice.getType());
		adviceJson.put("legacyCodeLines", advice.getLegacyLineNumberList());
		return adviceJson;
	}
}
