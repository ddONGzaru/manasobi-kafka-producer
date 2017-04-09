package tv.anypoint.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by kwlee on 15. 9. 22.
 */
@Data
public class ImpressionLogPeriod implements Serializable {

    private static final long serialVersionUID = 5250700409134262786L;

    private int id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date impressionTime;

    private int totalImpression;

    private int totalAmount;

    private int serviceOperator;

    private int inventory;

    private int deviceTotalImpression;

}
