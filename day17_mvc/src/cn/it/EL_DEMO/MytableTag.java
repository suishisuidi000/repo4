package cn.it.EL_DEMO;

import cn.it.domain.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

public class MytableTag extends TagSupport {
   private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int doStartTag() throws JspException {
        List<User> attribute = (List<User>)this.pageContext.getRequest().getAttribute(content);
        JspWriter out = this.pageContext.getOut();

        return super.doStartTag();
    }
}
