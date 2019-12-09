/**
 * @author Sharafan Oksana
 * @date 07.12.2019
 * @package lesson15.service
 */
package lesson15.service;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateHelper {

    /**
     *
     * @param str
     * @return
     */
    public static Date getDate(String str){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = null;
        try {
            java.util.Date dt = sdf1.parse(str);
            sqlDate = new java.sql.Date(dt.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sqlDate;
    }
}
