package mbs.perenoël.présentation;

import java.util.HashMap;
import java.util.Map;

import org.restlet.data.MediaType;
import org.restlet.ext.freemarker.TemplateRepresentation;
import org.restlet.representation.Representation;

import freemarker.template.Configuration;

public class PatronDeVue {
	private final String nomPatron;
	private Map<String, Object> données = new HashMap<String, Object>();

	public PatronDeVue(String nomPatron) {
		this.nomPatron = nomPatron;
	}

	public Representation representation() {
		return new TemplateRepresentation(nomPatron,
				getFreemarkerConfiguration(), données, MediaType.TEXT_HTML);
	}

	private Configuration getFreemarkerConfiguration() {
		Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(getClass(), "/patrons");
		return configuration;
	}

	public void ajouteAuModèle(String clé, Object valeur) {
		données.put(clé, valeur);
	}

	public PatronDeVue avec(String clé, Object valeur) {
		ajouteAuModèle(clé, valeur);
		return this;
	}
}
