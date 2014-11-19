package br.com.paulovitor.livraria.converter;

import java.math.BigDecimal;
import java.util.ResourceBundle;

import com.google.common.base.Strings;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.ConversionMessage;
import br.com.caelum.vraptor.converter.Converter;
import br.com.caelum.vraptor.util.SafeResourceBundle;
import br.com.paulovitor.livraria.modelo.Dinheiro;
import br.com.paulovitor.livraria.modelo.Moeda;

@Convert(Dinheiro.class)
public class DinheiroConverter implements Converter<Dinheiro> {

	@Override
	public Dinheiro convert(String value, Class<? extends Dinheiro> type) {
		if (Strings.isNullOrEmpty(value)) {
			return null;
		}
		for (Moeda moeda : Moeda.values()) {
			if (value.startsWith(moeda.getSimbolo())) {
				return new Dinheiro(moeda, criaMontante(value, moeda));
			}
		}
		throw new ConversionException(getConversionMessage(value));
	}

	private BigDecimal criaMontante(String value, Moeda moeda) {
		try {
			return new BigDecimal(value.replace(moeda.getSimbolo(), "")
					.replace(",", ".").trim());
		} catch (NumberFormatException e) {
			throw new ConversionException(getConversionMessage(value));
		}
	}

	private ConversionMessage getConversionMessage(String value) {
		ConversionMessage conversionMessage = new ConversionMessage(
				"dinheiro.invalido", value);
		conversionMessage.setBundle(new SafeResourceBundle(ResourceBundle
				.getBundle("messages")));
		return conversionMessage;
	}

}
