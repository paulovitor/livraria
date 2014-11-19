package br.com.paulovitor.livraria.converter;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

import br.com.caelum.vraptor.converter.ConversionException;
import br.com.caelum.vraptor.converter.Converter;
import br.com.paulovitor.livraria.modelo.Dinheiro;
import br.com.paulovitor.livraria.modelo.Moeda;

public class DinheiroConverterTest {

	@Test
	public void converteUmValorEmReais() {
		Converter<Dinheiro> converter = new DinheiroConverter();

		assertThat(converter.convert("R$ 1,00", null), is(new Dinheiro(
				Moeda.REAL, new BigDecimal("1.00"))));
	}

	@Test
	public void converteUmValorEmDolares() {
		Converter<Dinheiro> converter = new DinheiroConverter();

		assertThat(converter.convert("US$ 49,50", null), is(new Dinheiro(
				Moeda.DOLAR, new BigDecimal("49.50"))));
	}

	@Test(expected = ConversionException.class)
	public void lancaErroDeConversaoQuandoOValorEhInvalido() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		converter.convert("noventa pratas!", null);
	}

	@Test(expected = ConversionException.class)
	public void lancaErroDeConversaoQuandoOMontanteEhInvalido() {
		Converter<Dinheiro> converter = new DinheiroConverter();
		converter.convert("R$ mil", null);
	}

	@Test
	public void converteStringVaziaEmNull() {
		Converter<Dinheiro> converter = new DinheiroConverter();

		assertThat(converter.convert("", null), is(nullValue()));
	}

}
