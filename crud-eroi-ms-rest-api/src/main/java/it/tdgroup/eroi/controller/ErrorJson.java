package it.tdgroup.eroi.controller;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Data
@NoArgsConstructor
public class ErrorJson {

    /**
     * Log applicativo.
     */
    private static final Log LOG = LogFactory.getLog(ErrorJson.class);

    public Integer status;
    public String error;
    public String message;
    public String timeStamp;
    public String trace;

    public ErrorJson(int status, Map<String, Object> errorAttributes) {
        this.status = status;
        this.error = (String) errorAttributes.get("error");
        this.message = (String) errorAttributes.get("message");
        this.timeStamp = errorAttributes.get("timestamp").toString();
        this.trace = (String) errorAttributes.get("trace");
    }

}
