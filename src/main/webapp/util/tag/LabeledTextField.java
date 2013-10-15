package main.webapp.util.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import static main.webapp.util.Constants.*;

public class LabeledTextField extends SimpleTagSupport {

	private String label;
	private String value = "";
	private String name;

	@Override
	public void doTag() throws JspException, IOException {
		JspContext jspContext = getJspContext();
		JspWriter writer = jspContext.getOut();
		writer.append(HTML_TAG_TR_OPEN).append(HTML_TAG_TD_OPEN)
				.append(HTML_TAG_B_OPEN).append(label).append(HTML_TAG_B_CLOSE)
				.append(HTML_TAG_TD_CLOSE).append(HTML_TAG_TD_OPEN)
				.append("<input type=\"text\" name=\">").append(name)
				.append("\" value=\"").append(value).append("\"/>")
				.append(HTML_TAG_TD_CLOSE).append(HTML_TAG_TR_CLOSE);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
