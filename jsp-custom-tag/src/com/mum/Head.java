package com.mum;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class Head extends SimpleTagSupport {
    String theColor;
    String words;

    //This is called from JSP servlet to render custom tag
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (theColor != null)
            out.write(String.format("<h2 style='color:%s'>%s</h2>", theColor, words));
        else
            out.write(String.format("<h2>%s</h2>",words));
    }

    //Need a setter for each attribute of custom tag
    public void setTheColor(String theColor) {
        this.theColor = theColor;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
