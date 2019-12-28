/**
 * @author Sharafan Oksana
 * @date 26.12.2019
 * @package lesson15.servlet
 */
package lesson15.servlet;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDate;

public class DateTag extends TagSupport {
    private String plus = "0";
    public int doStarting() throws JspTagException{
        try {
            pageContext.getOut().write(String.valueOf(LocalDate.now().plusDays(Integer.parseInt(plus))));
        }catch (IOException e){
            throw new JspTagException(e.getMessage());
        }
        return SKIP_BODY;
    }
    public String getPlus(){
        return plus;
    }

    public  void setPlus(String plus){
        this.plus = plus;
    }
}
