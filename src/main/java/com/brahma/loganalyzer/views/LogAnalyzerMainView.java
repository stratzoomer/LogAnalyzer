package com.brahma.loganalyzer.views;

import io.dropwizard.views.View;
import com.brahma.loganalyzer.core.Contact;

public class LogAnalyzerMainView extends View {
    private final Contact contact;

    public Contact getContact() {
		return contact;
	}

	public LogAnalyzerMainView(Contact contact) {
        super("main.ftl");
        this.contact = contact;
    }
}
