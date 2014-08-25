package com.netvn.converter;

import java.io.IOException;

import org.springframework.context.ApplicationContext;

import com.netvn.core.entity.Image;
import com.netvn.core.service.FileService;
import com.netvn.utils.ApplicationContextUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsonImageSerializer extends JsonSerializer<Image> {
	private static FileService imageService;
	
	public JsonImageSerializer() {
		if (imageService == null) {
			ApplicationContext applicationContext = ApplicationContextUtils
					.getApplicationContext();
			imageService = applicationContext.getBean(FileService.class);
		}
	}

	
	public void serialize(Image img, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		if (img == null) {
			return;
		}
		jgen.writeStartObject();
		jgen.writeFieldName("id");
		jgen.writeString(img.getId());
		jgen.writeFieldName("path");
		jgen.writeString(imageService.getPath(img));
		jgen.writeEndObject();
	}
}
