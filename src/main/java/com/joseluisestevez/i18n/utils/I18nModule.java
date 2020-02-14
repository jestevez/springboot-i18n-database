package com.joseluisestevez.i18n.utils;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.joseluisestevez.i18n.service.I18nResourcesService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class I18nModule extends SimpleModule {

    private static final long serialVersionUID = -3060605154361115753L;
    private final I18nResourcesService i18nResourcesService;

    @Override
    public void setupModule(SetupContext context) {

	InternationalizedSerializer serializer = new InternationalizedSerializer(i18nResourcesService);
	context.addBeanSerializerModifier(new InternationalizingBeanSerializerModifier(serializer));
    }

    @RequiredArgsConstructor
    class InternationalizingBeanSerializerModifier extends BeanSerializerModifier {

	private final InternationalizedSerializer serializer;

	@Override
	public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc,
		List<BeanPropertyWriter> beanProperties) {

	    for (BeanPropertyWriter writer : beanProperties) {
		if (writer.getAnnotation(JsonInternationalized.class) != null) {
		    writer.assignSerializer(serializer);
		}
	    }

	    return beanProperties;
	}
    }

    @RequiredArgsConstructor
    class InternationalizedSerializer extends ToStringSerializer {

	private static final long serialVersionUID = -2391442803792997283L;

	private final I18nResourcesService i18nResourcesService;

	@Override
	public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {

	    Locale currentLocale = LocaleContextHolder.getLocale();
	    String traslator = i18nResourcesService.getMessage(value.toString(), value.toString(),
		    currentLocale.getLanguage());
	    gen.writeString(traslator);
	}
    }
}